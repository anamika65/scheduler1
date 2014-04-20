package de.scheduler.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import de.scheduler.importer.FileImportParser;
import de.scheduler.importer.UploadForm;
import de.scheduler.importer.UploadValidator;
import de.scheduler.model.DSupportOperation;
import de.scheduler.model.Operation;
import de.scheduler.service.DSupportOperationService;
import de.scheduler.service.OpBlockService;
import de.scheduler.service.OperationService;
import de.scheduler.service.PersonService;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

@Controller
public class ImportController {
	protected static Logger logger = Logger.getLogger("ImportController");
	
	@Resource(name = "operationService")
	private OperationService operationService;
	
	@Resource(name = "opBlockService")
	private OpBlockService opBlockService;
	
	@Resource(name = "personService")
	private PersonService personService;
	
    @Resource(name="dSupportOperationService")
    private DSupportOperationService dSupportOperationService;
    
	/**
	 * This method is invoked when a exception occurs in the processForm method.
	 * It handles the errors by redirecting the page to the /import page and dysplaying the apropriate message. 
	 * 
	 * @param request the request
	 * @param response the response
	 * @param exObj the exceptionObject
	 * @param exception the exception
	 * @return the model and view
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object exObj, Exception exception) {
		String error = "Unexpected error: the input file is invalid, if the problem persists please contact your administrator.";
		if (exception instanceof MaxUploadSizeExceededException) {
			error = "File size should be less then "
					+ FileUtils
							.byteCountToDisplaySize(((MaxUploadSizeExceededException) exception)
									.getMaxUploadSize()) + ".";
		}
		logger.debug(exception.getLocalizedMessage());
		RedirectView redirectView = new RedirectView("../import");
		return new ModelAndView(redirectView, "error.importer.exception", error);
	}
	
	//this init binder registers a UploadValidator instance when
	// a "uploadForm" object is send from the UI
	@InitBinder("uploadForm")
	void initBinder(WebDataBinder binder) {
		binder.setValidator(new UploadValidator());
	}

	/**
	 * Process the actual import of the excel file. 
	 * This method is called when the file is 100% uploaded on the server. 
	 * And instance to the actual bytes of the file can be get from the form parameter. 
	 * This method is called after the UploadValidator has validated the actual uploaded file, 
	 * if errors are present the errors are available in the BindingResult object. 
	 * 
	 * If no validation errors occur the excel file is parsed and inserted into the operation 
	 * table and after that the progress of the residents is updated.
	 * 
	 * Note if a exception occur, like for example the max upload size is exceeded the resolveException
	 * method will be invoked.
	 * 
	 * @param form the form with reference to the actual uploaded file
	 * @param result the result object that holds informations about the validation of the file
	 * @param model the model
	 * @return where the current page should be redirected
	 */
	@RequestMapping(value = "/administration/import/save", method = RequestMethod.POST)
	public String processForm(
			@Valid @ModelAttribute(value = "uploadForm") UploadForm form, BindingResult result, Model model, 
            @RequestParam(value="month", required=true) String mnth,
            @RequestParam(value="year", required=false) String yr) {
		
		// handle errors
		if (result.hasErrors()) {
			
			//if errors occured get all errors and redirect the page to the import page
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				logger.debug(error.getCode() + " - " + error.getDefaultMessage());
				model.addAttribute(error.getCode(), error.getDefaultMessage());
			}
			return "redirect:../import";
		}
		//System.out.println("Month "+mnth+" Year "+yr);
		
		String fileName = null;
		String resName = null;
		if (form != null) {
			//get the filename of the uploaded file
			fileName = form.getFile().getOriginalFilename();
			List<Operation> operations = null;
			try {
				//parse the uploaded file and return everything as a list of operations
				//Added by Anamika
				List<String> residentNames = FileImportParser.getXcelResidentNames(form.getFile().getInputStream());
				
				resName =personService.checkNickName(residentNames); 
				//all residents are in personnel table
				if( resName.equals("")){

					//Remove decision support operations and normal operations before import
					List <DSupportOperation> dSuppOpsToRemove= dSupportOperationService.getDSuppOperationsOfMonthYear(Integer.parseInt(mnth), Integer.parseInt(yr));
					if(dSuppOpsToRemove != null) {
						//System.out.println("dSuppOpsToRemove "+dSuppOpsToRemove +" "+ dSuppOpsToRemove.size());
						for(int opr=0; opr < dSuppOpsToRemove.size(); opr++) {
							if(dSuppOpsToRemove.get(opr) != null) {
								System.out.println("****Removable dsuppop ? "+ dSuppOpsToRemove.get(opr).getDeletable());
								if(dSuppOpsToRemove.get(opr).getDeletable() == 1) {
									System.out.println("dSuppOpsTORemove "+dSuppOpsToRemove.get(opr).getdSuppOpId());
									deleteDsupportOperation(dSuppOpsToRemove.get(opr).getdSuppOpId());
								}
							}
						}
					}
					//If still any operation is remaining in the operations table, delete those
					List <Operation> opsToRemove= operationService.getOperationsOfMonthYear(Integer.parseInt(mnth), Integer.parseInt(yr));
					if(opsToRemove != null) {
						System.out.println("OpsTORemove "+opsToRemove +" "+ opsToRemove.size());
						for(int opr=0; opr < opsToRemove.size(); opr++) {
							System.out.println("**** nullcheck " + opsToRemove.get(opr).getOpBlockId());
							if(opsToRemove.get(opr) != null) {
								System.out.println("**** nullcheck inside");
								System.out.println("****Removable op ? "+ isOperationReplacable(opsToRemove.get(opr).getOpBlockId()));
								if(isOperationReplacable(opsToRemove.get(opr).getOpBlockId())) {
									//System.out.println("Removable? "+ dSuppOpsToRemove.get(opr).getDeletable());
									System.out.println("OpsTORemove "+opsToRemove.get(opr).getOpBlockId());
									operationService.removeOperation(opsToRemove.get(opr).getOpBlockId());
								}
							}
						}
					}
					
					//Now do the actual import
					operations = FileImportParser.processExcelFile(form.getFile().getInputStream());
					System.out.println("**** operations to be imported " + operations.size());
					
				}
				else{
					model.addAttribute("resName",resName);
					System.out.println("Not Found: " + resName);

					return "redirect:../import";
				}
		        
				//operations = FileImportParser.processExcelFile(form
				//		.getFile().getInputStream());
			} catch (InvalidFormatException e) {
				throw new IllegalStateException(e.getLocalizedMessage());
			} catch (IOException e) {
				throw new IllegalStateException(e.getLocalizedMessage());
			}
			//if(!FileImportParser.isResident()){
			//	resName = FileImportParser.getNotFoundResident();
			//}
			//batch insert the parsed operations
			operationService.performBatchInsert(operations);

			//update opblocks with the imported operations
			if (operations.size() >= 2) {
				opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(operations.size()-1).getOpBlockId());
				//Sakib Anamika
				//opBlockService.deleteDSuppOperationsAfterImport(operations.get(0).getOpBlockId(), operations.get(operations.size()-1).getOpBlockId());
			} else {
				opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
				//Sakib Anamika
				//opBlockService.deleteDSuppOperationsAfterImport(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
			}
			
			logger.debug(("Uploaded successfully: " + fileName));
		}
		//if everything was a success redirect the page to import page 
		model.addAttribute("import.success", fileName);
		return "redirect:../import";
	}
	
	public void deleteDsupportOperation(Integer id) {
	    DSupportOperation dsop = dSupportOperationService.get(id);
	    if (dsop.getOperation1Op1() != null) {
	    	if (dsop.getOperation1Op1() > 0) operationService.removeOperation(dsop.getOperation1Op1());
	    }
	    if (dsop.getOperation2Op1() != null) {
	    	if (dsop.getOperation2Op1() > 0) operationService.removeOperation(dsop.getOperation2Op1());
	    }
	    if (dsop.getOperation1Op2() != null) {
	    	if (dsop.getOperation1Op2() > 0) operationService.removeOperation(dsop.getOperation1Op2());
	    }
	    if (dsop.getOperation2Op2() != null) {
	    	if (dsop.getOperation2Op2() > 0) operationService.removeOperation(dsop.getOperation2Op2());
	    }
	    if (dsop.getOperation1Ass1() != null) {
	    	if (dsop.getOperation1Ass1() > 0) operationService.removeOperation(dsop.getOperation1Ass1());
	    }
	    if (dsop.getOperation2Ass1() != null) {
	    	if (dsop.getOperation2Ass1() > 0) operationService.removeOperation(dsop.getOperation2Ass1());
	    }
	    
	    // Call DSupportOperationService to do the actual deleting
	    dSupportOperationService.delete(id);
	}

	
	public boolean isOperationReplacable(Integer id) {
	    Operation op = operationService.get(id);
	    if(op != null) {
	    	DSupportOperation dsuppop = dSupportOperationService.getDSuppOpForOp(op.getOpBlockId());
	    	if(dsuppop != null) {
	    		if(dsuppop.getDeletable() == 1) return true;
	    		else return false;
	    	}
	    }
	    
	    return true;
	}

}
