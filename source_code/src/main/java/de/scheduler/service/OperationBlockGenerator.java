package de.scheduler.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import de.scheduler.model.BlockPredecessor;
import de.scheduler.model.OpBlock;
import de.scheduler.model.OpCatalogue;
import de.scheduler.model.Project;
import de.scheduler.util.DifficultyLevel;
import de.scheduler.util.OpBlockType;

/**
 * Utility class OperationBlockGenerator. This class is used to regenerate the
 * model when a new block size is set for a catalog.
 */
@Service("operationBlockGeneratorService")
public class OperationBlockGenerator {

	protected static Logger logger = Logger
			.getLogger("operationBlockGeneratorService");

	@Resource(name = "opCatalogueService")
	private OpCatalogueService catalogService;

	@Resource(name = "blockPredecessorsService")
	private BlockPredecessorService blockPredecessorsService;

	@Resource(name = "opBlockService")
	private OpBlockService opBlockService;

	@Resource(name = "projectService")
	private ProjectService projectService;

	/**
	 * Generates operation blocks for the specified new block size. First it
	 * deletes all the blocks with the specified catalog id and the it
	 * regenerates the model.
	 * 
	 * @param catalogID 			the catalog id
	 * @param newDesiredSize 		the new block size value
	 * 
	 * @return 		true, if successful
	 */
	public boolean generateOpBlockForCatalog(int catalogID, int newDesiredSize) {

		OpCatalogue opCatalogue = catalogService.get(catalogID);

		if (opCatalogue == null) {
			throw new IllegalArgumentException("Catalog with catalog id: "
					+ catalogID + " not found!");
		}

		List<Project> projects = projectService.getAllProjectsForCatalog(catalogID);
		
		// deletes opBlocks with old Size
		if (!deleteOpBlocksWithOldSize(catalogID))
			return false;

		boolean isSpecialTrunk = opCatalogue.getSpecialTrunk();
		
		for (Project p : projects) {
			// retrieve dummy operation for specific project
			OpBlock dummyOperation = opBlockService.getOperationByProjID(
					p.getProjectID(), OpBlockType.DUMMY);

			if (dummyOperation == null) {
				logger.debug("Dummy operation not found for project id"
						+ p.getProjectID());
				throw new IllegalStateException(
						"It is mandatory that the project with id: "
								+ p.getProjectID() + " has a dummy operation.");
			}

			// generates the easy op blocks and the predecessors for the new op
			// size
			int easyOpBlocks = opCatalogue.getLeve1OpNo();
			if (easyOpBlocks != 0) {
				generateAndInsertOperationBlocks(catalogID, newDesiredSize,
						isSpecialTrunk, p, dummyOperation, easyOpBlocks,
						DifficultyLevel.EASY);
			}

			// generates the normal op blocks and the predecessors for the new
			// op size
			int normalOpBlocks = opCatalogue.getLeve2OpNo();
			if (normalOpBlocks != 0) {
				generateAndInsertOperationBlocks(catalogID, newDesiredSize,
						isSpecialTrunk, p, dummyOperation, normalOpBlocks,
						DifficultyLevel.NORMAL);
			}

			// generates the difficult op blocks and the predecessors for the
			// new op size
			int difficultOpBlocks = opCatalogue.getLeve3OpNo();
			if (difficultOpBlocks != 0) {
				generateAndInsertOperationBlocks(catalogID, newDesiredSize,
						isSpecialTrunk, p, dummyOperation, difficultOpBlocks,
						DifficultyLevel.DIFFICULT);
			}
		}

		return true;
	}

	/**
	 * Generate and insert operation blocks and block predecessors.
	 * 
	 * @param catalogID 			the catalog id
	 * @param newDesiredSize 		the new desired size of operation blocks
	 * @param isSpecialTrunk 		the is special trunk
	 * @param p 					the Project aka the resident schedule
	 * @param dummyOperation 		the dummy operation
	 * @param opBlocksSize 			the op blocks size
	 * @param levelOfDifficulty		the level of difficulty for the new blocks
	 */
	private void generateAndInsertOperationBlocks(int catalogID,
			int newDesiredSize, boolean isSpecialTrunk, Project p,
			OpBlock dummyOperation, int opBlocksSize,
			DifficultyLevel levelOfDifficulty) {
		// compute the new block size for operations
		int[] newOperationBlockSizes = getNoOfOpBlocks(opBlocksSize,
				newDesiredSize);
		if(newOperationBlockSizes != null) {
			// generate the actual block operations
			List<OpBlock> easyBlocks = generateNewOpBlockSizes(
					newOperationBlockSizes, p, catalogID, levelOfDifficulty);
			// perform a batch insert on the generated operations
			opBlockService.performBatchInsert(easyBlocks);
			
			// generate predecessors for the new generated operations
			List<BlockPredecessor> predForDummy = generatePredecessors(easyBlocks,
					dummyOperation, isSpecialTrunk);
			// perform a batch insert for the predecessors
			blockPredecessorsService.performBatchInsert(predForDummy);			
		}
	}

	/**
	 * Generate predecessors either for the dummy operation or for the given
	 * operations.
	 * 
	 * @param easyBlocks 			the easy blocks
	 * @param dummyOperation 		the dummy operation
	 * @param isSpecialTrunk 		the is special trunk
	 * 
	 * @return 		the list
	 */
	private List<BlockPredecessor> generatePredecessors(
			List<OpBlock> easyBlocks, OpBlock dummyOperation,
			boolean isSpecialTrunk) {
		List<BlockPredecessor> blockPredecessors = new LinkedList<BlockPredecessor>();
		for (OpBlock blocks : easyBlocks) {
			BlockPredecessor blockPredecessor = new BlockPredecessor();
			if (isSpecialTrunk) {
				blockPredecessor.setOpBlockID(blocks.getOpBlockId());
				blockPredecessor.setPredID(dummyOperation.getOpBlockId());
			} else {
				// we assume we are in the common trunk, hence only the dummy
				// operations will have predecessors
				blockPredecessor.setOpBlockID(dummyOperation.getOpBlockId());
				blockPredecessor.setPredID(blocks.getOpBlockId());
			}
			blockPredecessors.add(blockPredecessor);
		}
		return blockPredecessors;
	}

	/**
	 * Generates the operation blocks for the given project that will be
	 * inserted in the database.
	 * 
	 * @param opBlocksSize 		the easy blocks size
	 * @param p 				the Project aka the resident Training
	 * @param catalogID 		the catalog id
	 * @param difficultyLevel 	the difficulty level
	 * 
	 * @return 		the list with the generated operation blocks
	 */
	private List<OpBlock> generateNewOpBlockSizes(int[] opBlocksSize,
			Project p, int catalogID, DifficultyLevel difficultyLevel) {
		List<OpBlock> opBlocks = new LinkedList<OpBlock>();
		// generate a block for each block size
		for (int blockSize : opBlocksSize) {
			if (blockSize != 0) {
				OpBlock op = new OpBlock();
				// this is a normal block not a dummy block
				op.setType(OpBlockType.NORMAL.toString());
				op.setDefaultSize(blockSize);
				op.setActualSize(0);
				op.setCatalogID(catalogID);
				op.setProjectID(p.getProjectID());
				op.setDifficultyLevel(difficultyLevel.toString());
				opBlocks.add(op);
			}
		}
		return opBlocks;
	}

	/**
	 * Delete op blocks with old size from opblocks and blockpredecessors.
	 * 
	 * @param catalogID 		the catalog id
	 * 
	 * @return 		true, if successful
	 */
	public boolean deleteOpBlocksWithOldSize(int catalogID) {
		// first delete all the operation from block predecessors
		boolean predDeleted = blockPredecessorsService
				.deletePredecessorsByCatalogId(catalogID);

		// second delete the operation blocks from the operation blocks table
		boolean opBlocksDeleted = opBlockService
				.deleteOpBlockByCatalogId(catalogID);

		return (predDeleted && opBlocksDeleted);
	}

	/**
	 * Computes in an array of ints the op block sizes that need to be
	 * generated.
	 * 
	 * @param opBlocksSize 		the op blocks size that need to be performed by the residents
	 * @param desiredSize 		the desired size
	 * 
	 * @return 		the no of op blocks
	 */
	private int[] getNoOfOpBlocks(final int opBlocksSize, final int desiredSize) {
		int[] opBlocksSizes = null;
		if(desiredSize == 0) return opBlocksSizes;
		// check if the desired size is greater that the current size
		if ((opBlocksSize < desiredSize)) {
			opBlocksSizes = new int[] { opBlocksSize };
		} else {
			// find out how many blocks should be generated
			int size = opBlocksSize / desiredSize;
			int reminderBlockSize = opBlocksSize % desiredSize;
			// check if the division is not exact
			if (reminderBlockSize != 0) {
				size++;
			}
			opBlocksSizes = new int[size];
			// fill the array of sizes with the desired si
			Arrays.fill(opBlocksSizes, desiredSize);
			// if the division was not exact set the last block size
			if (reminderBlockSize != 0) {
				opBlocksSizes[size - 1] = (reminderBlockSize);
			}

		}
		return opBlocksSizes;
	}

	/**
	 * Generates dummy operation block for the specified project.
	 * 
	 * @param projectID		the catalog id
	 * 
	 * @return 		true, if successful
	 */
	public boolean generateDummyOpBlockForProject(int projectID) {
		OpBlock dummyBlock = new OpBlock();
		dummyBlock.setActualSize(new Integer(-1));
		dummyBlock.setCatalogID(new Integer(0));
		dummyBlock.setDefaultSize(new Integer(0));
		dummyBlock.setProjectID(projectID);
		dummyBlock.setType("DUMMY");
		
		List<OpBlock> blocks = new LinkedList<OpBlock>();
		blocks.add(dummyBlock);
		
		opBlockService.performBatchInsert(blocks);

		return true;
	}
	
	/**
	 * Generates initial NORMAL operation blocks for the specified project.
	 * 
	 * @param projectID		the project id
	 * 
	 * @return 		true, if successful
	 */
	public boolean generateInitialOpBlocks(int projectID, int specialtyID) {
		Project project = projectService.get(projectID);		
		List<OpCatalogue> opCatalogues = catalogService.getAllForSpecialty(specialtyID);
		
		if (opCatalogues == null) {
			throw new IllegalArgumentException("No catalogues found!");
		}
		
		for (OpCatalogue cat : opCatalogues) {
			boolean isSpecialTrunk = cat.getSpecialTrunk();
			Integer blockSize = cat.getBlockSize();
			Integer catalogID = cat.getCatalogueID();
	
				// retrieve dummy operation for specific project
				OpBlock dummyOperation = opBlockService.getOperationByProjID(projectID, OpBlockType.DUMMY);
				
				if (dummyOperation == null) {
					logger.debug("Dummy operation not found for project id"	+ projectID);
					throw new IllegalStateException(
							"It is mandatory that the project with id: "
									+ projectID + " has a dummy operation.");
				}
					
				// generates the easy op blocks and the predecessors
				int easyOpBlocks = cat.getLeve1OpNo();
				if (easyOpBlocks != 0) {
						generateAndInsertOperationBlocks(catalogID, blockSize,
								isSpecialTrunk, project, dummyOperation, easyOpBlocks,
								DifficultyLevel.EASY);
				}
					
				// generates the normal op blocks and the predecessors
				int normalOpBlocks = cat.getLeve2OpNo();
				if (normalOpBlocks != 0) {
					generateAndInsertOperationBlocks(catalogID, blockSize,
							isSpecialTrunk, project, dummyOperation, normalOpBlocks,
							DifficultyLevel.NORMAL);
				}

				// generates the difficult op blocks and the predecessors
				int difficultOpBlocks = cat.getLeve3OpNo();
				if (difficultOpBlocks != 0) {
					generateAndInsertOperationBlocks(catalogID, blockSize,
							isSpecialTrunk, project, dummyOperation, difficultOpBlocks,
							DifficultyLevel.DIFFICULT);
				}
		}
		
		return true;
	}
	
	
	/**
	 * Generates operation blocks for the specified catalogID and projectID. 
	 * 
	 * @param catalogID            the catalog id
	 * @param projectID            the project/resident id
	 * 
	 * @return 		true, if successful
	 */
	public boolean generateOpBlockForCatalogOfResident(int catalogID, int projectID) {

		OpCatalogue opCatalogue = catalogService.get(catalogID);
		Project p = projectService.get(projectID);

		if (opCatalogue == null) {
			throw new IllegalArgumentException("Catalog with catalog id: "
					+ catalogID + " not found!");
		} 
			
		int blockSize = opCatalogue.getBlockSize();

		boolean isSpecialTrunk = opCatalogue.getSpecialTrunk();

		// retrieve dummy operation for specific project
		OpBlock dummyOperation = opBlockService.getOperationByProjID(
				p.getProjectID(), OpBlockType.DUMMY);

		if (dummyOperation == null) {
			logger.debug("Dummy operation not found for project id"
					+ p.getProjectID());
			throw new IllegalStateException(
					"It is mandatory that the project with id: "
							+ p.getProjectID() + " has a dummy operation.");
		}

		// generates the easy op blocks and the predecessors for the new op
		// size
		int easyOpBlocks = opCatalogue.getLeve1OpNo();
		if (easyOpBlocks != 0) {
			generateAndInsertOperationBlocks(catalogID, blockSize,
					isSpecialTrunk, p, dummyOperation, easyOpBlocks,
					DifficultyLevel.EASY);
		}

		// generates the normal op blocks and the predecessors for the new
		// op size
		int normalOpBlocks = opCatalogue.getLeve2OpNo();
		if (normalOpBlocks != 0) {
			generateAndInsertOperationBlocks(catalogID, blockSize,
					isSpecialTrunk, p, dummyOperation, normalOpBlocks,
					DifficultyLevel.NORMAL);
		}

		// generates the difficult op blocks and the predecessors for the
		// new op size
		int difficultOpBlocks = opCatalogue.getLeve3OpNo();
		if (difficultOpBlocks != 0) {
			generateAndInsertOperationBlocks(catalogID, blockSize,
					isSpecialTrunk, p, dummyOperation, difficultOpBlocks,
					DifficultyLevel.DIFFICULT);
		}

		return true;
	}

}
