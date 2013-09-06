package de.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pscodes")
public class PsCode {
	
	@Id	
	@Column(name = "PsCode")
	private String psCode;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "CatalogID")
	private String catalogueID;

	public String getPsCode() {
		return psCode;
	}

	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCatalogueID() {
		return catalogueID;
	}

	public void setCatalogueID(String catalogueID) {
		this.catalogueID = catalogueID;
	}	
}
