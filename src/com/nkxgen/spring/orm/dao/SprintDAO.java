package com.nkxgen.spring.orm.dao;

import java.util.List;

import com.nkxgen.spring.orm.model.Sprint;
import com.nkxgen.spring.orm.model.SprintDto;
import com.nkxgen.spring.orm.model.SprintTaskDto;

public interface SprintDAO {
	Sprint getSprintById(int sprintId);

	List<Sprint> getAllSprints();

	void createSprint(Sprint sprint);

	void updateSprint(Sprint sprint);

	void deleteSprint(int sprintId);

	List<SprintDto> getSprintbyprojectId(Integer projectId);

	List<SprintTaskDto> getSprintDetails(int sprintId);
}
