package de.scheduler.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import de.scheduler.model.Person;
import de.scheduler.model.Project;
import de.scheduler.model.ProjectPersonInfo;

@Service("projectPersonInfoService")
public class ProjectPersonInfoService {

	@Resource(name = "projectService")
	private ProjectService projectService;

	@Resource(name = "personService")
	private PersonService personService;

	Map<Integer, ProjectPersonInfo> getProjectPersonInfos(Integer specialtyID) {
		Map<Integer, ProjectPersonInfo> infos = new HashMap<Integer, ProjectPersonInfo>();
		List<Project> projects = projectService.getAllForSpecialty(specialtyID);
		for (Project project : projects) {
			Person person = personService.get(project.getPersID());
			ProjectPersonInfo projPersonInfo = new ProjectPersonInfo();

			projPersonInfo.setPerson(person);
			projPersonInfo.setProject(project);
			infos.put(project.getProjectID(), projPersonInfo);
		}
		return infos;
	}
}
