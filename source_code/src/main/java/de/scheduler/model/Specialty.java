package de.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specialties")
public class Specialty {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "SpecialtyID")
	private Integer specialtyID;
	
	@Column(name = "Name")
	private String name;

	public Integer getSpecialtyID() {
		return specialtyID;
	}

	public void setSpecialtyID(Integer specialtyID) {
		this.specialtyID = specialtyID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
