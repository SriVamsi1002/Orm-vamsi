package com.nkxgen.spring.orm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.model.Sprint;
import com.nkxgen.spring.orm.model.SprintDto;
import com.nkxgen.spring.orm.model.SprintTask;
import com.nkxgen.spring.orm.model.SprintTaskDto;

@Component
public class SprintDAOImpl implements SprintDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Sprint getSprintById(int sprintId) {
		return entityManager.find(Sprint.class, sprintId);
	}

	@Override
	public List<Sprint> getAllSprints() {
		String jpql = "SELECT s FROM Sprint s";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void createSprint(Sprint sprint) {
		entityManager.persist(sprint);
	}

	@Override
	@Transactional
	public void updateSprint(Sprint sprint) {
		entityManager.merge(sprint);
	}

	@Override
	@Transactional
	public void deleteSprint(int sprintId) {
		Sprint sprint = entityManager.find(Sprint.class, sprintId);
		if (sprint != null) {
			entityManager.remove(sprint);
		}
	}

	@Override
	public List<SprintDto> getSprintbyprojectId(Integer projectId) {
		short getProjectId = projectId.shortValue();
		TypedQuery<Sprint> query = entityManager
				.createQuery("SELECT s FROM Sprint s WHERE s.project.projectId = :proj_id", Sprint.class);
		query.setParameter("proj_id", getProjectId);
		List<Sprint> sprints = query.getResultList();

		List<SprintDto> sprintDTOList = new ArrayList<>();

		for (Sprint sprint : sprints) {
			SprintDto Sprintdto = SprintDto.fromEntity(sprint);
			sprintDTOList.add(Sprintdto);
		}

		return sprintDTOList;
	}

	@Override
	public List<SprintTaskDto> getSprintDetails(int sprintId) {
		System.out.println("in here is " + sprintId);
		TypedQuery<SprintTask> query = entityManager
				.createQuery("select f from SprintTask f where f.id.sprint.sprintId = :sprintId", SprintTask.class);
		query.setParameter("sprintId", sprintId);
		List<SprintTask> sprinttasks = query.getResultList();
		List<SprintTaskDto> sprinttasklist = new ArrayList<>();
		for (SprintTask sprintTask : sprinttasks) {
			System.out.println(sprintTask);
			SprintTaskDto sprinttaskdto = SprintTaskDto.fromEntity(sprintTask);
			sprinttasklist.add(sprinttaskdto);
		}
		System.out.println(sprinttasklist);
		return sprinttasklist;
	}

}
