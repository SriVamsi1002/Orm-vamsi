package com.nkxgen.spring.orm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkxgen.spring.orm.dao.ProjectDAO;
import com.nkxgen.spring.orm.model.Project;
import com.nkxgen.spring.orm.model.ProjectDto;

@Service
@Transactional
public class ProjectService {

	private final ProjectDAO projectDAO;

	@Autowired
	public ProjectService(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public List<ProjectDto> getAllProjects() {
		return projectDAO.getAllProjects();
	}

	public ProjectDto getProjectById(Integer projId) {
		return projectDAO.getProjectById(projId);
	}

	public void setNewProject(Project project) {
		projectDAO.setNewProject(project);
	}

	// Add methods for creating, updating, and deleting projects if needed
}
