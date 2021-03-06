package de.scheduler.service;

import java.util.List;

import de.scheduler.model.OpCatalogue;
import de.scheduler.model.PsCode;

public interface OpsCodeMappingServiceInterface {
	
	public List<OpCatalogue> getAllOpCatalogue();
	
	public List<OpCatalogue> getFilteredOpCatalogue();
	
	public Integer getOpCatalogueIdForPsCode( String psCode );
	
	public Integer getOpCatalogueIdFor5DigitPsCode( String psCode );
	
	public Boolean updateOpCatalogueForPsCode( String psCode , String opCatalogueId );
	
	public Boolean insertOpCatalogueForPsCode( String psCode , String opCatalogueId , String description );
	
}