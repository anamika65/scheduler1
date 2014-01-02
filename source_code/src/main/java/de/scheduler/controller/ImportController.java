package de.scheduler.controller;
import java.io.IOException;
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
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import de.scheduler.importer.FileImportParser;
import de.scheduler.importer.UploadForm;
import de.scheduler.importer.UploadValidator;
import de.scheduler.model.Operation;
import de.scheduler.service.OpBlockService;
import de.scheduler.service.OperationService;

@Controller
public class ImportController {
	protected static Logger logger = Logger.getLogger("ImportController");
	
	@Resource(name = "operationService")
	private OperationService operationService;
	
	@Resource(name = "opBlockService")
	private OpBlockService opBlockService;
	
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
			@Valid @ModelAttribute(value = "uploadForm") UploadForm form,
			BindingResult result, Model model) {
		
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
		
		String fileName = null;
		if (form != null) {
			//get the filename of the uploaded file
			fileName = form.getFile().getOriginalFilename();
			List<Operation> operations = null;
			try {
				//parse the uploaded file and return everything as a list of operations
				operations = FileImportParser.processExcelFile(form
						.getFile().getInputStream());
			} catch (InvalidFormatException e) {
				throw new IllegalStateException(e.getLocalizedMessage());
			} catch (IOException e) {
				throw new IllegalStateException(e.getLocalizedMessage());
			}
			
			//batch insert the parsed operations
			operationService.performBatchInsert(operations);

			//update opblocks with the imported operations
			if (operations.size() >= 2) {
				opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(operations.size()-1).getOpBlockId());
				opBlockService.deleteDSuppOperationsAfterImport(operations.get(0).getOpBlockId(), operations.get(operations.size()-1).getOpBlockId());
			} else {
				opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
				opBlockService.deleteDSuppOperationsAfterImport(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
			}
			
			logger.debug(("Uploaded successfully: " + fileName));
		}
		//if everything was a success redirect the page to import page 
		//but with the message success
		model.addAttribute("import.success", fileName);
		return "redirect:../import";
	}

}
