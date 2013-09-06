package de.scheduler.service;

import java.util.Comparator;

import de.scheduler.model.ProjectCatalogStatus;

public class ProjectStatusInfoRule implements Comparator<ProjectCatalogStatus> {
    public static ProjectStatusInfoRule INSTANCE = new ProjectStatusInfoRule();
    
	@Override
	public int compare(ProjectCatalogStatus p1, ProjectCatalogStatus p2) {
		Double statusP1, statusP2 = new Double(0); 
		
		statusP1 = (double)p1.getProgressPercentShouldBe() - p1.getProgressPercentIs();
		statusP2 = (double)p2.getProgressPercentShouldBe() - p2.getProgressPercentIs();
		
		return statusP2.compareTo(statusP1);
	}
}
