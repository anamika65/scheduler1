package de.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blockpredecessors")
public class BlockPredecessor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "BlockPredID")
	private Integer blockpredID;
	

	@Column(name = "OpBlockID")
	private Integer opBlockID;
	
	@Column(name = "PredecessorID")
	private Integer predID;

	public Integer getBlockpredID() {
		return blockpredID;
	}
	
	public void setBlockpredID(Integer blockpredID) {
		this.blockpredID = blockpredID;
	}
	
	public Integer getOpBlockID() {
		return opBlockID;
	}
	
	public void setOpBlockID(Integer opBlockID) {
		this.opBlockID = opBlockID;
	}
	
	public Integer getPredID() {
		return predID;
	}
	
	public void setPredID(Integer predID) {
		this.predID = predID;
	}
}
