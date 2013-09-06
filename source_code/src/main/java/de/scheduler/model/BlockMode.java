package de.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blockTimeMode")
public class BlockMode {
	
	@Id
	@Column(name = "ModeID")
	private Integer modeID;

	@Column(name = "OpBlockID")
	private String opBlockID;
	
	@Column(name = "AvailableModes")
	private String availableModes;

	public Integer getModeID() {
		return modeID;
	}
	
	public void setModeID(Integer modeID) {
		this.modeID = modeID;
	}
	
	public String getOpBlockID() {
		return opBlockID;
	}
	
	public void setOpBlockID(String opBlockID) {
		this.opBlockID = opBlockID;
	}
	
	public String getAvailableModes() {
		return availableModes;
	}
	
	public void setAvailableModes(String availableModes) {
		this.availableModes = availableModes;
	}
}
