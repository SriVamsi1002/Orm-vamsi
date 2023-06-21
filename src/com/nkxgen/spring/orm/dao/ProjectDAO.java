package com.nkxgen.spring.orm.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.nkxgen.spring.orm.model.Project;
import com.nkxgen.spring.orm.model.ProjectDto;

@Component
public class ProjectDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<ProjectDto> getAllProjects() {

		TypedQuery<Project> query = entityManager.createQuery("SELECT pt FROM Project pt", Project.class);
		List<Project> projects = query.getResultList();

		List<ProjectDto> convertedTasks = projects.stream().map(ProjectDto::fromEntity).collect(Collectors.toList());
		return convertedTasks;
	}

	public ProjectDto getProjectById(Integer proj_id) {
		short getProjectId = proj_id.shortValue();
		TypedQuery<Project> query = entityManager.createQuery("SELECT pt FROM Project pt WHERE pt.projectId = :proj_id",
				Project.class);
		query.setParameter("proj_id", getProjectId);

		List<Project> projects = query.getResultList();

		if (!projects.isEmpty()) {
			Project project = projects.get(0);
			return ProjectDto.fromEntity(project);
		} else {

			return null;
		}
	}

	public Project findById(short id) {
		return entityManager.find(Project.class, id);
	}

	public void setNewProject(Project project) {
		// TODO Auto-generated method stub

	}

}
