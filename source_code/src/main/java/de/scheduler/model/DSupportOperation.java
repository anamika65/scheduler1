package de.scheduler.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "dsupportoperations")
public class DSupportOperation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dSuppOpID")
	private Integer dSuppOpId;
	
	@Column(name = "OPSC01")
	private String opsc1;
	
	@Column(name = "OPSC02")
	private String opsc2;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "OpDate")
	private Date opDate;
	
	@Column(name = "OP1")
	private String op1;
	
	@Column(name = "OP2")
	private String op2;
	
	@Column(name = "Ass1")
	private String ass1;

	@Column(name = "EntryDate")
	private Date entryDate;
	
	@Column(name = "CatalogID")
	private Integer catalogID;
	
	@Column(name = "CatalogName")
	private String catalogName;

	public Integer getdSuppOpId() {
		return dSuppOpId;
	}

	public void setdSuppOpId(Integer dSuppOpId) {
		this.dSuppOpId = dSuppOpId;
	}

	public String getOpsc1() {
		return opsc1;
	}

	public void setOpsc1(String opsc1) {
		this.opsc1 = opsc1;
	}

	public String getOpsc2() {
		return opsc2;
	}

	public void setOpsc2(String opsc2) {
		this.opsc2 = opsc2;
	}

	public Date getOpDate() {
		return opDate;
	}

	public void setOpDate(Date opDate) {
		this.opDate = opDate;
	}
	
	public String getFormattedOpDate() {
		DateFormat pickerFormatter = new SimpleDateFormat("dd-MM-yyyy");
		return pickerFormatter.format(opDate);
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getAss1() {
		return ass1;
	}

	public void setAss1(String ass1) {
		this.ass1 = ass1;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public void setCatalogID(Integer catalogueID) {
		this.catalogID = catalogueID;
	}

	public Integer getCatalogID() {
		return catalogID;
	}

	public void setCatalogName(String catalogueName) {
		this.catalogName = catalogueName;
	}

	public String getCatalogName() {
		return catalogName;
	}
	
}
