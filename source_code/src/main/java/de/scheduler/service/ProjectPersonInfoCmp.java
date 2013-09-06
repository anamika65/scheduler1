package de.scheduler.service;

import java.util.Comparator;

import de.scheduler.model.Person;
import de.scheduler.model.ProjectPersonInfo;

public class ProjectPersonInfoCmp implements Comparator<ProjectPersonInfo>  {
	public static ProjectPersonInfoCmp INSTANCE = new ProjectPersonInfoCmp();

	@Override
	public int compare(ProjectPersonInfo person1, ProjectPersonInfo person2) {
		Person firstPerson = person1.getPerson();
		Person secondPerson = person2.getPerson();
		
		String person1Name = firstPerson.getName();
		String person2Name = secondPerson.getName();
		//first compare the names of the two persons
		int nameComparison = person1Name.compareToIgnoreCase(person2Name);
		if(nameComparison != 0) { 
			return nameComparison;
		}
		
		String person1FirstName = firstPerson.getFirstName();
		String person2FirstName = secondPerson.getFirstName();
		//compare the firstName if the names are equal
		int firstNameComparison = person1FirstName.compareToIgnoreCase(person2FirstName);
		if(firstNameComparison != 0) { 
			return firstNameComparison;
		}
		//return 0 because the name + firstName is the same
		return 0;
	}

}
