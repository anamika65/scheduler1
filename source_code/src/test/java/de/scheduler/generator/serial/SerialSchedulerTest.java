package de.scheduler.generator.serial;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import de.scheduler.generator.AvailabilityResourceManger;
import de.scheduler.generator.ResourceLabelToIndex;
import de.scheduler.generator.Scheduler;
import de.scheduler.generator.serial.SerialScheduler;
import de.scheduler.generator.serial.priority.SerialSchedulerRule;
import de.scheduler.model.OpBlock;
import de.scheduler.model.Project;
import de.scheduler.util.DifficultyLevel;
import de.scheduler.util.OpBlockType;
import de.scheduler.util.ResourceType;

/*
 * CatalogID mapping:
 * 1 - BloodVessel
 * 2 - Breast
 * 3 - Head
 * 4 - Stomache
 * 
 * ProjectId mapping: 
 * 1 - Resident 1
 * 2 - Resident 2
 * 3 - Resident 3
 * 4 - Resident 4
 * 
 * //id 1 = "DrainInsertions"
 * //id 2 = "Assistances"
 * //id 3 = "BloodVessel"
 * //id 4 = "Head"
 * //id 5 = "Breast"
 * //id 6 = "Stomache"
 * //id 7 = "Difficult"
 * //id 8 = "Cholecystectomy"
 * //id 9 = "Hernia"
 */

public class SerialSchedulerTest {

	private static String[] catalogues = { "3", "5", "4", "6", "7", "8", "9",
			"2", "1" };
	private static String[] projects = { "1", "2", "3" };

	private Map<Integer, OpBlock> activities;
	private AvailabilityResourceManger resMan;
	private ResourceLabelToIndex resToIndex;

	@Before
	public void runBeforeEveryTest() {
		activities = new HashMap<Integer, OpBlock>();
		List<OpBlock> opBlocks = new LinkedList<OpBlock>();
		// id 1 = "DrainInsertions"
		// common trunk
		final OpBlock simple1 = new OpBlock();
		simple1.setCatalogID(1);
		simple1.setType(OpBlockType.NORMAL.toString());
		simple1.setDifficultyLevel(DifficultyLevel.EASY.toString());
		simple1.setDefaultSize(10);
		simple1.setActualSize(0);
		simple1.setOpBlockId(10);
		simple1.setProjectID(1);
		Project p = new Project();
		p.setPersID(1);
		simple1.setProject(p);
		opBlocks.add(simple1);
		// id 1 = "DrainInsertions"
		OpBlock simple2 = new OpBlock();
		simple2.setCatalogID(1);
		simple2.setType(OpBlockType.NORMAL.toString());
		simple2.setDifficultyLevel(DifficultyLevel.EASY.toString());
		simple2.setDefaultSize(10);
		simple2.setActualSize(0);
		simple2.setOpBlockId(11);
		simple2.setProjectID(2);
		Project p2 = new Project();
		p2.setPersID(2);
		simple2.setProject(p2);

		opBlocks.add(simple2);
		// id 2 = "Assistances"
		OpBlock simple3 = new OpBlock();
		simple3.setCatalogID(2);
		simple3.setType(OpBlockType.NORMAL.toString());
		simple3.setDifficultyLevel(DifficultyLevel.EASY.toString());
		simple3.setDefaultSize(10);
		simple3.setActualSize(0);
		simple3.setOpBlockId(12);
		simple3.setProjectID(3);
		Project p3 = new Project();
		p3.setPersID(3);
		simple3.setProject(p3);
		opBlocks.add(simple3);

		// dummy operations for common trunk
		OpBlock dummy1 = new OpBlock();
		dummy1.setType(OpBlockType.DUMMY.toString());
		dummy1.setOpBlockId(13);
		Set<OpBlock> s = new HashSet<OpBlock>();
		s.add(simple1);
		dummy1.setPredecessors(s);
		dummy1.setDefaultSize(0);
		dummy1.setActualSize(-1);
		dummy1.setProjectID(1);
		opBlocks.add(dummy1);

		OpBlock dummy2 = new OpBlock();
		dummy2.setType(OpBlockType.DUMMY.toString());
		dummy2.setOpBlockId(14);
		Set<OpBlock> s1 = new HashSet<OpBlock>();
		s1.add(simple2);
		dummy2.setPredecessors(s1);
		dummy2.setDefaultSize(0);
		dummy2.setActualSize(-1);
		dummy2.setProjectID(2);
		opBlocks.add(dummy2);

		OpBlock dummy3 = new OpBlock();
		dummy3.setType(OpBlockType.DUMMY.toString());
		dummy3.setOpBlockId(15);
		Set<OpBlock> s2 = new HashSet<OpBlock>();
		s2.add(simple3);
		dummy3.setPredecessors(s2);
		dummy3.setDefaultSize(0);
		dummy3.setActualSize(-1);
		dummy3.setProjectID(3);
		opBlocks.add(dummy3);

		// resident 1:
		Set<OpBlock> dummyPred1 = new HashSet<OpBlock>();
		dummyPred1.add(dummy1);

		Set<OpBlock> predDummyRes1 = new HashSet<OpBlock>();

		OpBlock op1 = new OpBlock();
		op1.setCatalogID(3);
		op1.setType(OpBlockType.NORMAL.toString());
		op1.setDifficultyLevel(DifficultyLevel.EASY.toString());
		op1.setDefaultSize(10);
		op1.setActualSize(0);
		op1.setOpBlockId(1);
		op1.setProjectID(1);
		Project p1 = new Project();
		p1.setPersID(1);
		op1.setProject(p1);
		op1.setPredecessors(dummyPred1);
		opBlocks.add(op1);
		predDummyRes1.add(op1);

		OpBlock op2 = new OpBlock();
		op2.setCatalogID(4);
		op2.setType(OpBlockType.NORMAL.toString());
		op2.setDifficultyLevel(DifficultyLevel.NORMAL.toString());
		op2.setDefaultSize(5);
		op2.setActualSize(0);
		op2.setOpBlockId(2);
		op2.setProjectID(1);
		op2.setProject(p1);
		op2.setPredecessors(dummyPred1);
		opBlocks.add(op2);
		predDummyRes1.add(op2);

		OpBlock op3 = new OpBlock();
		op3.setCatalogID(5);
		op3.setPredecessors(dummyPred1);
		op3.setType(OpBlockType.NORMAL.toString());
		op3.setDifficultyLevel(DifficultyLevel.EASY.toString());
		op3.setDefaultSize(5);
		op3.setActualSize(0);
		op3.setOpBlockId(3);
		op3.setProjectID(1);
		op3.setProject(p1);
		opBlocks.add(op3);
		predDummyRes1.add(op3);

		OpBlock dummyFinRes1 = new OpBlock();
		dummyFinRes1.setType(OpBlockType.DUMMY.toString());
		dummyFinRes1.setDifficultyLevel(DifficultyLevel.EASY.toString());
		dummyFinRes1.setDefaultSize(0);
		dummyFinRes1.setOpBlockId(16);
		dummyFinRes1.setPredecessors(predDummyRes1);
		dummyFinRes1.setProjectID(1);
		// opBlocks.add(dummyFinRes1); for now ignore the third dummy operation.

		// resident 2:
		Set<OpBlock> predDummyRes2 = new HashSet<OpBlock>();

		Set<OpBlock> dummyPred2 = new HashSet<OpBlock>();
		dummyPred2.add(dummy2);

		OpBlock op4 = new OpBlock();
		op4.setCatalogID(6);
		op4.setPredecessors(dummyPred2);
		op4.setType(OpBlockType.NORMAL.toString());
		op4.setDifficultyLevel(DifficultyLevel.NORMAL.toString());
		op4.setDefaultSize(10);
		op4.setActualSize(0);
		op4.setOpBlockId(4);
		op4.setProjectID(2);
		op4.setProject(p2);
		opBlocks.add(op4);
		predDummyRes2.add(op4);

		OpBlock op5 = new OpBlock();
		op5.setPredecessors(dummyPred2);
		op5.setCatalogID(5);
		op5.setType(OpBlockType.NORMAL.toString());
		op5.setDifficultyLevel(DifficultyLevel.EASY.toString());
		op5.setDefaultSize(5);
		op5.setActualSize(0);
		op5.setOpBlockId(5);
		op5.setProjectID(2);
		op5.setProject(p2);
		opBlocks.add(op5);
		predDummyRes2.add(op5);

		OpBlock op6 = new OpBlock();
		op6.setPredecessors(dummyPred2);
		op6.setCatalogID(3);
		op6.setType(OpBlockType.NORMAL.toString());
		op6.setDifficultyLevel(DifficultyLevel.NORMAL.toString());
		op6.setDefaultSize(5);
		op6.setActualSize(0);
		op6.setOpBlockId(6);
		op6.setProjectID(2);
		op6.setProject(p2);
		opBlocks.add(op6);
		predDummyRes2.add(op6);

		OpBlock dummyFinRes2 = new OpBlock();
		dummyFinRes2.setType(OpBlockType.DUMMY.toString());
		dummyFinRes2.setDifficultyLevel(DifficultyLevel.EASY.toString());
		dummyFinRes2.setDefaultSize(0);
		dummyFinRes2.setOpBlockId(17);
		dummyFinRes2.setPredecessors(predDummyRes2);
		dummyFinRes2.setProjectID(2);
		// opBlocks.add(dummyFinRes2); ignore last

		// resident 3:
		Set<OpBlock> dummyPred3 = new HashSet<OpBlock>();
		dummyPred3.add(dummy3);

		Set<OpBlock> predDummyRes3 = new HashSet<OpBlock>();

		OpBlock op7 = new OpBlock();
		op7.setPredecessors(dummyPred3);
		op7.setCatalogID(3);
		op7.setType(OpBlockType.NORMAL.toString());
		op7.setDifficultyLevel(DifficultyLevel.EASY.toString());
		op7.setDefaultSize(10);
		op7.setActualSize(0);
		op7.setOpBlockId(7);
		op7.setProjectID(3);
		op7.setProject(p3);
		predDummyRes3.add(op7);
		opBlocks.add(op7);

		OpBlock op8 = new OpBlock();
		op8.setPredecessors(dummyPred3);
		op8.setCatalogID(5);
		op8.setType(OpBlockType.NORMAL.toString());
		op8.setDifficultyLevel(DifficultyLevel.EASY.toString());
		op8.setDefaultSize(5);
		op8.setActualSize(0);
		op8.setOpBlockId(8);
		op8.setProjectID(3);
		op8.setProject(p3);
		predDummyRes3.add(op8);
		opBlocks.add(op8);

		OpBlock op9 = new OpBlock();
		op9.setPredecessors(dummyPred3);
		op9.setType(OpBlockType.NORMAL.toString());
		op9.setDifficultyLevel(DifficultyLevel.DIFFICULT.toString());
		op9.setCatalogID(4);
		op9.setDefaultSize(5);
		op9.setActualSize(0);
		op9.setOpBlockId(9);
		predDummyRes3.add(op9);
		op9.setProjectID(3);
		op9.setProject(p3);
		opBlocks.add(op9);

		OpBlock dummyFinRes3 = new OpBlock();
		dummyFinRes3.setType(OpBlockType.DUMMY.toString());
		dummyFinRes3.setDifficultyLevel(DifficultyLevel.EASY.toString());
		dummyFinRes3.setDefaultSize(0);
		dummyFinRes3.setOpBlockId(18);
		dummyFinRes3.setPredecessors(predDummyRes3);
		dummyFinRes3.setProjectID(3);
		// opBlocks.add(dummyFinRes3);

		resToIndex = new ResourceLabelToIndex();
		Map<Integer, Integer> resources = new HashMap<Integer, Integer>();
		for (String operation : catalogues) {
			for (DifficultyLevel d : DifficultyLevel.values()) {
				int resIndex = resToIndex
						.setIndexForLabel(ResourceType.OPERATION_CAPACITY.toString()
								+ operation + d.toString());
				int capacity = 10;
				resources.put(resIndex, capacity);
			}
		}
		int res1 = resToIndex.setIndexForLabel(ResourceType.PROJECT_CAPACITY.toString()
				+ "1"); // be careful
		int res2 = resToIndex.setIndexForLabel(ResourceType.PROJECT_CAPACITY.toString()
				+ "2");
		int res3 = resToIndex.setIndexForLabel(ResourceType.PROJECT_CAPACITY.toString()
				+ "3");

		resources.put(res1, 20); // an average of 20 operations
		resources.put(res2, 20); // an average of 20 operations
		resources.put(res3, 20); // an average of 20 operations

		for (OpBlock o : opBlocks) {
			activities.put(o.getOpBlockId(), o);
		}

		// Average operations per month
		resMan = new AvailabilityResourceManger(resources);

	}

	@Test
	public void testParallelScheduleWithSmallestDuration() {

		Scheduler<OpBlock> parallelSche = new SerialScheduler(activities,
				resMan, 66, resToIndex, SerialSchedulerRule.INSTANCE);
		Map<Integer, List<OpBlock>> schedule = parallelSche.schedule();
		Map<String, List<OpBlock>> schForResidents = getScheduleForPeriod(1,
				schedule);
		assertTrue(schForResidents.size() == 3);
		assertTrue(schForResidents.get("1").size() == 2);
		assertTrue(schForResidents.get("2").size() == 3);
		assertTrue(schForResidents.get("3").size() == 3);
	}

	public static Map<String, List<OpBlock>> getScheduleForPeriod(int period,
			Map<Integer, List<OpBlock>> fullSchedule) {

		Map<String, List<OpBlock>> schedule = new TreeMap<String, List<OpBlock>>();
		List<OpBlock> scheduledBlocks = fullSchedule.get(period);
		if (scheduledBlocks != null) {
			for (String resident : projects) {
				List<OpBlock> schBlockForResidents = new LinkedList<OpBlock>();
				for (OpBlock o : scheduledBlocks) {
					if (o.getType().equalsIgnoreCase(
							OpBlockType.NORMAL.toString())
							&& o.getProjectID().equals(
									Integer.parseInt(resident))) {
						schBlockForResidents.add(o);
					}
				}
				schedule.put(resident, schBlockForResidents);
			}
		}
		return schedule;

	}

}
