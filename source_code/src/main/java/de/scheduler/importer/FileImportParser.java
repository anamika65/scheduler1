package de.scheduler.importer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import de.scheduler.model.Operation;

public class FileImportParser {
	protected static Logger logger = Logger.getLogger("ImportParser");

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
					switch (cn) {
					case 0:
						// setting the OP1
						if (cell != null) {
							op.setOpsc1(cell.getStringCellValue());
						} else {
							// TODO handle null case of OP1
						}
						break;
					case 1:
						// setting OP2
						if (cell != null) {
							op.setOpsc2(cell.getStringCellValue());
						}
						break;
					case 2:
						// setting opDatum
						if (cell != null
								&& HSSFDateUtil.isCellDateFormatted(cell)) {
							op.setOpDate(cell.getDateCellValue());
						}
						break;
					case 3:
						// setting Op1
						if (cell != null) {
							op.setOp1(cell.getStringCellValue());
						}
						break;
					case 4:
						// setting Op2
						if (cell != null) {
							op.setOp2(cell.getStringCellValue());
						}
						break;
					case 5:
						// setting Ass1
						if (cell != null) {
							op.setAss1(cell.getStringCellValue());
						}
						break;
					}
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

}
