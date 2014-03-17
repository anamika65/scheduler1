package de.scheduler.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ProjectCatalogStatus {

	private Integer projectID;
	
	private String nickname;
	
	private Integer catalogueID;

	private String catalogueName;

	private Integer completedOpNumber;
	
	private Integer totalOpNumber;
	
	private Integer elapsedMonths;
	
	private Integer duration;
	
	private Double progressPercentIs;
	
	private Double progressPercentShouldBe;
	
	private boolean overdue;
	

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public Integer getCatalogueID() {
		return catalogueID;
	}

	public void setCatalogueID(Integer catalogueID) {
		this.catalogueID = catalogueID;
	}

	public String getCatalogueName() {
		return catalogueName;
	}

	public void setCatalogueName(String catalogueName) {
		this.catalogueName = catalogueName;
	}

	public Integer getCompletedOpNumber() {
		return completedOpNumber;
	}

	public void setCompletedOpNumber(Integer completedOpNumber) {
		this.completedOpNumber = completedOpNumber;
	}

	public Integer getTotalOpNumber() {
		return totalOpNumber;
	}

	public void setTotalOpNumber(Integer totalOpNumber) {
		this.totalOpNumber = totalOpNumber;
	}

	public void setElapsedMonths(Integer elapsedMonths) {
		this.elapsedMonths = elapsedMonths;
	}

	public Integer getElapsedMonths() {
		return elapsedMonths;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setProgressPercentIs() {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
		DecimalFormat formatter = (DecimalFormat)nf;
		formatter.applyPattern("#0.0");
		
		this.progressPercentIs = Double.parseDouble(formatter.format((double)this.completedOpNumber * 100 / this.totalOpNumber));
	}

	public Double getProgressPercentIs() {
		return progressPercentIs;
	}

	public void setProgressPercentShouldBe() {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
		DecimalFormat formatter = (DecimalFormat)nf;
		formatter.applyPattern("#0.0");
		
		this.progressPercentShouldBe = Double.parseDouble(formatter.format((double)this.elapsedMonths * 100 / this.duration));
	}

	public Double getProgressPercentShouldBe() {
		return progressPercentShouldBe;
	}
	
	/**
	 * Checks if is overdue.
	 *
	 * @return true if the project has exceeded its duration, false otherwise
	 */
	public boolean getOverdue() { 
		return this.overdue;
	}

	public void setOverdue() {
		this.overdue = this.elapsedMonths > this.duration;
	}


}
