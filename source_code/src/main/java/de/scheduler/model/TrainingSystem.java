package de.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "training_systems")
public class TrainingSystem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "train_system_id")
	private Integer train_system_id;
	
	@Column(name = "train_system_name")
	private String train_system_name;

	public Integer getTrain_system_id() {
		return train_system_id;
	}

	public void setTrain_system_id(Integer train_system_id) {
		this.train_system_id = train_system_id;
	}

	public String getTrain_system_name() {
		return train_system_name;
	}

	public void setTrain_system_name(String train_system_name) {
		this.train_system_name = train_system_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((train_system_id == null) ? 0 : train_system_id.hashCode());
		result = prime
				* result
				+ ((train_system_name == null) ? 0 : train_system_name
						.hashCode());
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
		TrainingSystem other = (TrainingSystem) obj;
		if (train_system_id == null) {
			if (other.train_system_id != null)
				return false;
		} else if (!train_system_id.equals(other.train_system_id))
			return false;
		if (train_system_name == null) {
			if (other.train_system_name != null)
				return false;
		} else if (!train_system_name.equals(other.train_system_name))
			return false;
		return true;
	}
	
	
}
