package de.scheduler.importer;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

 
public class  UploadValidator implements Validator {
    private static transient Logger logger = Logger.getLogger(UploadValidator.class);
    // Content types the user can upload
    private static final String[] ACCEPTED_CONTENT_TYPES = new String[] {"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
    	"application/vnd.ms-excel"
    };
     
    private static final String[] ACCEPTED_EXTENSIONS = new String[] {
        "xls",
        "xlsx"
    };
     
    @Override
    public boolean supports(Class<?> clazz) {
        return UploadForm.class.equals(clazz);
    }
 
    /**
     * Validate our uploaded bean
     */
    @Override
    public void validate(Object obj, Errors errors) {
    	UploadForm uploadItem = (UploadForm) obj;
        MultipartFile file = uploadItem.getFile();
        try {
            if(file == null || file.getBytes().length == 0){
                errors.reject("error.upload.null", "Please select a file to upload!");
                return;
            }
        } catch (IOException e) {
            logger.error(e.getMessage());           
        }       
         
        // Check content type
        boolean acceptableContentType = false;
        String incomingContentType = file.getContentType();
        logger.info("FileName = "+file.getName());      
        logger.info("incomingContentType = "+incomingContentType);
        // This related to bug  when on Vista and using Firefox/IE bug content type is 'application/octet-stream'        
        // Instead  of one of the allowed ones
        if("application/octet-stream".equalsIgnoreCase(incomingContentType)){
            int index = file.getOriginalFilename().lastIndexOf('.');
            String incomingExtension = file.getOriginalFilename().substring(index + 1);
            for(String extendsion : ACCEPTED_EXTENSIONS){
                if(extendsion.equalsIgnoreCase(incomingExtension)){
                    acceptableContentType = true;
                    break;
                }           
            }
        }else{
            for(String contentType : ACCEPTED_CONTENT_TYPES){
                logger.debug("Comparing " + incomingContentType +" to "+ contentType);
                if(contentType.equalsIgnoreCase(incomingContentType)){
                    acceptableContentType = true;
                    break;
                }           
            }
        }
        if(!acceptableContentType){
            errors.reject("error.upload.contenttype", "Please upload a file with one of the following file types; .xls, .xslx.");
        }
    }
}
