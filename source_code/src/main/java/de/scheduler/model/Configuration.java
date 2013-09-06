package de.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configuration")
public class Configuration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ConfigID")
	private Integer configID;
	
	@Column(name = "Name")
	private String name;

	@Column(name = "Value")
	private String value;

	public Integer getConfigID() {
		return configID;
	}

	public void setConfigID(Integer configID) {
		this.configID = configID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
