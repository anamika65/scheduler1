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
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ProjID")
	private Integer projectID;

	@Column(name = "PersID")
	private Integer persID;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "StartDate")
	private Date startDate;
	
	@Column(name = "Duration")
	private Integer duration;
	
	@Column(name = "Capacity")
	private Integer capacity;
	
	@Column(name = "Active")
	private boolean active;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DeactivatedUntil")
	private Date deactivatedUntil;
	
	@Column(name = "Nickname")
	private String nickname;

	@Column(name = "SpecialtyID")
	private Integer specialtyID;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public Integer getPersID() {
		return persID;
	}

	public void setPersID(Integer persID) {
		this.persID = persID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Date getDeactivatedUntil() {
		return deactivatedUntil;
	}
	
	public void setDeactivatedUntil(Date deactivatedUntil) {
		this.deactivatedUntil = deactivatedUntil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((projectID == null) ? 0 : projectID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (projectID == null) {
			if (other.projectID != null)
				return false;
		} else if (!projectID.equals(other.projectID))
			return false;
		return true;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setSpecialtyID(Integer specialtyID) {
		this.specialtyID = specialtyID;
	}

	public Integer getSpecialtyID() {
		return specialtyID;
	}

}
