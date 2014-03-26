package de.scheduler.importer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import de.scheduler.model.Operation;
import de.scheduler.service.PersonService;


public class FileImportParser {
	
	@Resource(name = "personService")
	private PersonService personService;
	
	protected static Logger logger = Logger.getLogger("ImportParser");
	protected static int defaultColumnNumber = 6;
	protected static String[] defaultColumns = {"OPSC01","OPSC02","OPDatum","OP1","OP2","ASS1"};
	protected static Integer[] allowedColumnNumbers = new Integer[defaultColumnNumber];


	/**
	 * Process excel file that contains the performed operations. Can handle xls
	 * and xslx file. The format of the excel file should be OPSC 01, OPSC 02,
	 * OP Datum, OP1, OP2, ASS1
	 * 
	 * @param inputFile
	 *            the input file
	 * @return the parsed operations as a list of operations objects
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 */
	public static List<Operation> processExcelFile(InputStream inputFile) throws IOException, InvalidFormatException {

		List<Operation> operations = new LinkedList<Operation>();
		try {
			// create an Workbook based on an xls or xslx file.
			Workbook wb = WorkbookFactory.create(inputFile); // Or InputStream
			Sheet sheet = wb.getSheetAt(0);
			
			//Sakib Anamika - start
			//extract the row from the worksheet
			Row r0 = sheet.getRow(0);
			//get the last column so that we now how many columns should be looped
			int lastColumn0 = r0.getLastCellNum();
			String cellNameBefore;
			String cellName;
			
			for (int cn = 0; cn < lastColumn0; cn++) {
				Cell cell = r0.getCell(cn, Row.RETURN_BLANK_AS_NULL);
				cellNameBefore = cell.getStringCellValue();
				cellName = cellNameBefore.replaceAll("\\s+","");
				for(int in = 0; in < defaultColumns.length; in++) {
					if(cellName.equalsIgnoreCase(defaultColumns[in])) {
						allowedColumnNumbers[in]=cn;
					}
				}
				
			}
			//Sakib Anamika - end
			
			// start from the second row, since the first row contains only info
			int rowStart = sheet.getFirstRowNum() + 1;
			int rowEnd = sheet.getLastRowNum();
			//loop each row starting with rowStart and ending with rowEnd
			for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
				//extract the row from the worksheet
				Row r = sheet.getRow(rowNum);
				//get the last column so that we now how many columns should be looped
				int lastColumn = r.getLastCellNum();
				//create a operation for each row
				Operation op = new Operation();
				//fill the op object with the required data from the excel
				for (int cn = 0; cn < lastColumn; cn++) {
					Cell cell = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
					//Sakib Anamika - start
					if(cn == allowedColumnNumbers[0]) {
						if (cell != null) {
							op.setOpsc1(cell.getStringCellValue());
						} else {
							// TODO handle null case of OP1
							op.setOpsc1("");
						}
					} else if(cn == allowedColumnNumbers[1]) {
						if (cell != null) {
							op.setOpsc2(cell.getStringCellValue());
						} else {
							// TODO handle null case of OP1
							op.setOpsc2("");
						}
					} else if(cn == allowedColumnNumbers[2]) {
						if (cell != null
								&& HSSFDateUtil.isCellDateFormatted(cell)) {
							op.setOpDate(cell.getDateCellValue());
						} else {
							// TODO handle null case of OP1
						}
					} else if(cn == allowedColumnNumbers[3]) {
						System.out.println("allowedColumnNumbeeeee:" + allowedColumnNumbers[3]);
						if (cell != null) {
							System.out.println("allowedColumnNumb:" + allowedColumnNumbers[3]);
							op.setOp1(cell.getStringCellValue());
							
						} else {
							// TODO handle null case of OP1
							op.setOp1("");
						}
					} else if(cn == allowedColumnNumbers[4]) {
						System.out.println("allowedColumnNumbers[4]:" + allowedColumnNumbers[4]);
						if (cell != null) {
							System.out.println("allowedColumnNumbers[4]:" + allowedColumnNumbers[4]);
							op.setOp2(cell.getStringCellValue());
							//isResident = ;
							//System.out.println("isResident:" + isResident);
							/*if(!personService.checkNickName(cell.getStringCellValue())){
								setResident(false);
								notFoundResident = cell.getStringCellValue(); //get the OP1 name to show on jsp not found
								setNotFoundResident(notFoundResident);
								System.out.println("ResidentName:" + notFoundResident);
								//break;
							}*/
						} else {
							// TODO handle null case of OP1
							op.setOp2("");
						}
					} else if(cn == allowedColumnNumbers[5]) {
						if (cell != null) {
							System.out.println("allowedColumnNumbers[5]:" + allowedColumnNumbers[5]);
							op.setAss1(cell.getStringCellValue());
							
						} else {
							// TODO handle null case of OP1
							op.setAss1("");
						}
					}
					//Sakib Anamika - end
				}
				operations.add(op);
			}
			// close the input stream.
			inputFile.close();
		} catch (FileNotFoundException e) {
			logger.debug(e.getLocalizedMessage());
			throw e;
		} catch (IOException e) {
			logger.debug(e.getLocalizedMessage());
			throw e;
		} catch (InvalidFormatException e) {
			logger.debug(e.getLocalizedMessage());
			throw e;
		}

		return operations;
	}

	
	public static List<String> getXcelResidentNames(InputStream inputFile) throws IOException, InvalidFormatException {
		List<String> names = new ArrayList<String>();
		try {
			// create an Workbook based on an xls or xslx file.
			Workbook wb = WorkbookFactory.create(inputFile); // Or InputStream
			Sheet sheet = wb.getSheetAt(0);
			
			//Sakib Anamika - start
			//extract the row from the worksheet
			Row r0 = sheet.getRow(0);
			//get the last column so that we now how many columns should be looped
			int lastColumn0 = r0.getLastCellNum();
			String cellNameBefore;
			String cellName;
			
			for (int cn = 0; cn < lastColumn0; cn++) {
				Cell cell = r0.getCell(cn, Row.RETURN_BLANK_AS_NULL);
				cellNameBefore = cell.getStringCellValue();
				cellName = cellNameBefore.replaceAll("\\s+","");
				for(int in = 0; in < defaultColumns.length; in++) {
					if(cellName.equalsIgnoreCase(defaultColumns[in])) {
						allowedColumnNumbers[in]=cn;
					}
				}
				
			}
			//Sakib Anamika - end
			
			// start from the second row, since the first row contains only info
			int rowStart = sheet.getFirstRowNum() + 1;
			int rowEnd = sheet.getLastRowNum();
			//loop each row starting with rowStart and ending with rowEnd
			for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
				//extract the row from the worksheet
				Row r = sheet.getRow(rowNum);
				//get the last column so that we now how many columns should be looped
				int lastColumn = r.getLastCellNum();
				//create a operation for each row
				Operation op = new Operation();
				//fill the op object with the required data from the excel
				for (int cn = 0; cn < lastColumn; cn++) {
					Cell cell = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
					//Sakib Anamika - start
					if(cn == allowedColumnNumbers[3]) {
						System.out.println("allowedColumnNumbeeeee:" + allowedColumnNumbers[3]);
						if (cell != null) {
							if(names.contains(cell.getStringCellValue())){
							;	
							}
							else names.add(cell.getStringCellValue());
						} else {
							// TODO handle null case of OP1
							
						}
					} else if(cn == allowedColumnNumbers[4]) {
						if (cell != null) {
							if(names.contains(cell.getStringCellValue())){
								;	
								}
								else names.add(cell.getStringCellValue());
						} else {
							// TODO handle null case of OP1
							
						}
					} else if(cn == allowedColumnNumbers[5]) {
						if (cell != null) {
							if(names.contains(cell.getStringCellValue())){
								;	
								}
								else names.add(cell.getStringCellValue());
						} else {
							// TODO handle null case of OP1
							
						}
					}
					//Sakib Anamika - end
				}
				
			}
			// close the input stream.
			inputFile.close();
		} catch (FileNotFoundException e) {
			logger.debug(e.getLocalizedMessage());
			throw e;
		} catch (IOException e) {
			logger.debug(e.getLocalizedMessage());
			throw e;
		} catch (InvalidFormatException e) {
			logger.debug(e.getLocalizedMessage());
			throw e;
		}

		return names;
	}

}
