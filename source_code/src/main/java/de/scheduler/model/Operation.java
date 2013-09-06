package de.scheduler.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "operations")
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OpID")
	private Integer opBlockId;
	
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

	public Integer getOpBlockId() {
		return opBlockId;
	}

	public void setOpBlockId(Integer opBlockId) {
		this.opBlockId = opBlockId;
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
}
