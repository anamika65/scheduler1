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
@Table(name = "schedules")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ScheduleID")
	private Integer scheduleID;
	
	@Column(name = "ProjectID")
	private Integer projectID;
	
	@Column(name = "OpBlockID")
	private Integer opBlockID;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ScheduleDate")
	private Date scheduleDate;

	public Integer getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(Integer scheduleID) {
		this.scheduleID = scheduleID;
	}

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
	public Integer getOpBlockID() {
		return opBlockID;
	}

	public void setOpBlockID(Integer opBlockID) {
		this.opBlockID = opBlockID;
	}
}
