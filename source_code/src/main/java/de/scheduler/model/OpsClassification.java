package de.scheduler.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "opsclassification")
public class OpsClassification {
	
	@Id
	@Column(name = "OPSCode")
	private String opsCode;
	
	@Column(name = "PSCode")
	private String psCode;
	
	@Column(name = "Description")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ClassifDate")
	private Date classifDate;

	public String getOpsCode() {
		return opsCode;
	}

	public void setOpsCode(String opsCode) {
		this.opsCode = opsCode;
	}

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

	public Date getClassifDate() {
		return classifDate;
	}

	public void setClassifDate(Date classifDate) {
		this.classifDate = classifDate;
	}
}
