package de.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "opcatalogues")
public class OpCatalogue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CatalogID")
	private Integer catalogueID;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "SpecialTrunk")
	private boolean specialTrunk;
	
	@Column(name = "Level1OpNo")
	private Integer leve1OpNo;
	
	@Column(name = "Level2OpNo")
	private Integer leve2OpNo;
	
	@Column(name = "Level3OpNo")
	private Integer leve3OpNo;
	
	@Column(name = "BlockSize")
	private Integer blockSize;
	
	@Column(name = "MonthlyCapacity")
	private Integer monthlyCapacity;
	
	@Column(name = "SpecialtyID")
	private Integer specialtyID;
	
	@Transient
	private boolean allowDelete;

	public Integer getMonthlyCapacity() {
		return monthlyCapacity;
	}

	public void setMonthlyCapacity(Integer monthlyCapacity) {
		this.monthlyCapacity = monthlyCapacity;
	}

	public Integer getCatalogueID() {
		return catalogueID;
	}

	public void setCatalogueID(Integer catalogueID) {
		this.catalogueID = catalogueID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSpecialTrunk(boolean specialTrunk) {
		this.specialTrunk = specialTrunk;
	}

	public boolean getSpecialTrunk() {
		return specialTrunk;
	}

	public Integer getLeve1OpNo() {
		return leve1OpNo;
	}

	public void setLeve1OpNo(Integer leve1OpNo) {
		this.leve1OpNo = leve1OpNo;
	}

	public Integer getLeve2OpNo() {
		return leve2OpNo;
	}

	public void setLeve2OpNo(Integer leve2OpNo) {
		this.leve2OpNo = leve2OpNo;
	}

	public Integer getLeve3OpNo() {
		return leve3OpNo;
	}

	public void setLeve3OpNo(Integer leve3OpNo) {
		this.leve3OpNo = leve3OpNo;
	}

	public void setBlockSize(Integer blockSize) {
		this.blockSize = blockSize;
	}

	public Integer getBlockSize() {
		return blockSize;
	}

	public void setSpecialtyID(Integer specialtyID) {
		this.specialtyID = specialtyID;
	}

	public Integer getSpecialtyID() {
		return specialtyID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((catalogueID == null) ? 0 : catalogueID.hashCode());
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
		OpCatalogue other = (OpCatalogue) obj;
		if (catalogueID == null) {
			if (other.catalogueID != null)
				return false;
		} else if (!catalogueID.equals(other.catalogueID))
			return false;
		return true;
	}

	public void setAllowDelete(boolean allowDelete) {
		this.allowDelete = allowDelete;
	}

	public boolean isAllowDelete() {
		return allowDelete;
	}
}
