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

	@Column(name = "OPSC01Difficulty")
	private Integer oPSC01Difficulty;

	@Column(name = "OPSC02Difficulty")
	private Integer oPSC02Difficulty;

	@Column(name = "OP1Credit")
	private String oP1Credit;

	@Column(name = "OP2Credit")
	private String oP2Credit;
	
	@Column(name = "Ass1Credit")
	private String ass1Credit;

	@Column(name = "OP1ChosenDifficult")
	private String oP1ChosenDifficult;

	@Column(name = "OP2ChosenDifficult")
	private String oP2ChosenDifficult;

	@Column(name = "Ass1ChosenDifficult")
	private String ass1ChosenDifficult;

	@Column(name = "Operation1Op1")
	private Integer operation1Op1;

	@Column(name = "Operation2Op1")
	private Integer operation2Op1;

	@Column(name = "Operation1Op2")
	private Integer operation1Op2;

	@Column(name = "Operation2Op2")
	private Integer operation2Op2;

	@Column(name = "Operation1Ass1")
	private Integer operation1Ass1;

	@Column(name = "Operation2Ass1")
	private Integer operation2Ass1;

	@Column(name = "Deletable")
	private Integer deletable;

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

	public Integer getOPSC01Difficulty() {
		return oPSC01Difficulty;
	}

	public void setOPSC01Difficulty(Integer oPSC01Difficulty) {
		this.oPSC01Difficulty = oPSC01Difficulty;
	}

	public Integer getOPSC02Difficulty() {
		return oPSC02Difficulty;
	}

	public void setOPSC02Difficulty(Integer oPSC02Difficulty) {
		this.oPSC02Difficulty = oPSC02Difficulty;
	}

	public String getOP1Credit() {
		return oP1Credit;
	}

	public void setOP1Credit(String oP1Credit) {
		this.oP1Credit = oP1Credit;
	}

	public String getOP2Credit() {
		return oP2Credit;
	}

	public void setOP2Credit(String oP2Credit) {
		this.oP2Credit = oP2Credit;
	}

	public String getAss1Credit() {
		return ass1Credit;
	}

	public void setAss1Credit(String ass1Credit) {
		this.ass1Credit = ass1Credit;
	}

	public String getOP1ChosenDifficult() {
		return oP1ChosenDifficult;
	}

	public void setOP1ChosenDifficult(String oP1ChosenDifficult) {
		this.oP1ChosenDifficult = oP1ChosenDifficult;
	}

	public String getOP2ChosenDifficult() {
		return oP2ChosenDifficult;
	}

	public void setOP2ChosenDifficult(String oP2ChosenDifficult) {
		this.oP2ChosenDifficult = oP2ChosenDifficult;
	}

	public String getAss1ChosenDifficult() {
		return ass1ChosenDifficult;
	}

	public void setAss1ChosenDifficult(String ass1ChosenDifficult) {
		this.ass1ChosenDifficult = ass1ChosenDifficult;
	}

	public Integer getOperation1Op1() {
		return operation1Op1;
	}

	public void setOperation1Op1(Integer operation1Op1) {
		this.operation1Op1 = operation1Op1;
	}
	
	public Integer getOperation2Op1() {
		return operation2Op1;
	}

	public void setOperation2Op1(Integer operation2Op1) {
		this.operation2Op1 = operation2Op1;
	}


	public Integer getOperation1Op2() {
		return operation1Op2;
	}

	public void setOperation1Op2(Integer operation1Op2) {
		this.operation1Op2 = operation1Op2;
	}
	
	public Integer getOperation2Op2() {
		return operation2Op2;
	}

	public void setOperation2Op2(Integer operation2Op2) {
		this.operation2Op2 = operation2Op2;
	}


	public Integer getOperation1Ass1() {
		return operation1Ass1;
	}

	public void setOperation1Ass1(Integer operation1Ass1) {
		this.operation1Ass1 = operation1Ass1;
	}
	
	public Integer getOperation2Ass1() {
		return operation2Ass1;
	}

	public void setOperation2Ass1(Integer operation2Ass1) {
		this.operation2Ass1 = operation2Ass1;
	}

	public Integer getDeletable() {
		return deletable;
	}

	public void setDeletable(Integer deletable) {
		this.deletable = deletable;
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
