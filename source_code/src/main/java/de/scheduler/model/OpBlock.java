package de.scheduler.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.scheduler.util.ResourceType;

@Entity
@Table(name = "opblocks")
public class OpBlock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OpBlockID")
	private Integer opBlockId;

	@Column(name = "ProjID")
	private Integer projectID;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "blockpredecessors", joinColumns = @JoinColumn(name = "OpBlockID"), inverseJoinColumns = @JoinColumn(name = "PredecessorID"))
	private Set<OpBlock> predecessors;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ProjID", referencedColumnName = "ProjID", insertable = false, updatable = false)
	private Project project;

	@Column(name = "DifficultyLevel")
	private String difficultyLevel;

	@Column(name = "Type")
	private String type;

	@Column(name = "CatalogID")
	private Integer catalogID;

	@Column(name = "DefaultSize")
	private Integer defaultSize;

	@Column(name = "ActualSize")
	private Integer actualSize;

	@Temporal(TemporalType.DATE)
	@Column(name = "EarliestStartDate")
	private Date earliestStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "LatestStartDate")
	private Date latestStartDate;

	public Set<OpBlock> getPredecessors() {
		return predecessors;
	}

	public void setPredecessors(Set<OpBlock> predecessors) {
		this.predecessors = predecessors;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOpBlockId() {
		return opBlockId;
	}

	public void setOpBlockId(Integer opBlockId) {
		this.opBlockId = opBlockId;
	}

	public Integer getCatalogID() {
		return catalogID;
	}

	public void setCatalogID(Integer catalogID) {
		this.catalogID = catalogID;
	}

	public Integer getDefaultSize() {
		return defaultSize;
	}

	public void setDefaultSize(Integer defaultSize) {
		this.defaultSize = defaultSize;
	}

	public Integer getActualSize() {
		return actualSize;
	}

	public void setActualSize(Integer actualSize) {
		this.actualSize = actualSize;
	}

	public Date getEarliestStartDate() {
		return earliestStartDate;
	}

	public void setEarliestStartDate(Date earliestStartDate) {
		this.earliestStartDate = earliestStartDate;
	}

	public Date getLatestStartDate() {
		return latestStartDate;
	}

	public void setLatestStartDate(Date latestStartDate) {
		this.latestStartDate = latestStartDate;
	}

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public boolean arePredecessorsFulfiled() {
		if (predecessors == null)
			return true;
		// to do, be aware that dummy blocks can have only normal blocks as
		// predecessors.
		for (OpBlock o : predecessors) {
			// in the case of dummy operations the default size is 0 and the
			// actual size is -1, this are set equal only when the dummy
			// operation is
			// scheduled
			if (!o.isFinished())
				return false;
		}
		return true;
	}

	public String getConstraintLabel() {
		return ResourceType.OPERATION_CAPACITY.toString() + catalogID + difficultyLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((opBlockId == null) ? 0 : opBlockId.hashCode());
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
		OpBlock other = (OpBlock) obj;
		if (opBlockId == null) {
			if (other.opBlockId != null)
				return false;
		} else if (!opBlockId.equals(other.opBlockId))
			return false;
		return true;
	}

	public String toString() {
		return "catalogID:" + catalogID + "projectID:" + projectID;
	}

	public boolean isFinished() {
		return (actualSize == defaultSize);
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
