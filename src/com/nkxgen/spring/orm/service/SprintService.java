package com.nkxgen.spring.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.dao.SprintDAO;
import com.nkxgen.spring.orm.model.Sprint;
import com.nkxgen.spring.orm.model.SprintDto;
import com.nkxgen.spring.orm.model.SprintTaskDto;

@Component
@Transactional
public class SprintService {

	@Autowired
	private SprintDAO sprintDAO;

	public Sprint getSprintById(int sprintId) {
		return sprintDAO.getSprintById(sprintId);
	}

	public List<Sprint> getAllSprints() {
		return sprintDAO.getAllSprints();
	}

	public void createSprint(Sprint sprint) {
		sprintDAO.createSprint(sprint);
	}

	public void updateSprint(Sprint sprint) {
		sprintDAO.updateSprint(sprint);
	}

	public void deleteSprint(int sprintId) {
		sprintDAO.deleteSprint(sprintId);
	}

	public List<SprintDto> getSprintbyprojectId(Integer projectId) {
		return sprintDAO.getSprintbyprojectId(projectId);
	}

	public List<SprintTaskDto> getSprintDetails(int sprintId) {
		return sprintDAO.getSprintDetails(sprintId);
	}

}
