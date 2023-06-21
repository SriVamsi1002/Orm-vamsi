package com.nkxgen.spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nkxgen.spring.orm.model.Task;
import com.nkxgen.spring.orm.model.User;

@Repository
@Component
public class TaskDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Task> getTasksByUserId(int userId) {
		User user = findById(userId);
		String jpql = "SELECT t FROM Task t WHERE t.taskSupervisor = :user";
		TypedQuery<Task> taskQuery = entityManager.createQuery(jpql, Task.class);
		taskQuery.setParameter("user", user);
		return taskQuery.getResultList();
	}

	public List<Task> viewTasksForUser(int userId) {
		return getTasksByUserId(userId);
	}

	public List<Task> filterTasks(Short projectFilter, String statusFilter, String categoryFilter, int userId) {
		String jpql = null;

		String allqry = "SELECT t FROM Task t WHERE 1 = 1 AND t.taskCreator.id = :userId";

		String lpql = "SELECT t FROM Task t WHERE 1 = 1 AND t.taskCreator.id = :userId AND t.taskStatus = :status";

		String zpql = "SELECT t FROM Task t WHERE 1 = 1 AND t.taskCreator.id = :userId AND t.taskSupervisor.id = :userId";
		String zpql2 = "SELECT t FROM Task t WHERE 1 = 1 AND t.taskCreator.id = :userId AND t.taskStatus = :status AND t.taskCategory = :category";

		String jpql3 = "SELECT t FROM Task t WHERE 1 = 1 AND t.taskCreator.id = :userId AND t.taskStatus = :status";

		String jpql4 = "SELECT t FROM Task t WHERE 1 = 1 AND t.taskCreator.id = :userId  AND t.taskCategory = :category";
		String jpql5 = "SELECT t FROM Task t WHERE 1 = 1 AND t.taskCreator.id = :userId  AND t.taskCategory = :category AND t.taskStatus = :status";
		if (projectFilter == null) {
			jpql = zpql2;
			if (statusFilter.isEmpty()) {
				if (categoryFilter.isEmpty()) {
					jpql = allqry;
				} else {
					jpql = jpql4;
				}
			} else if (categoryFilter.isEmpty()) {
				jpql = jpql3;
			} else {
				jpql = jpql5;
			}

		}

		TypedQuery<Task> query = entityManager.createQuery(jpql, Task.class);

		if (projectFilter != null && projectFilter != 0) {
			query.setParameter("projectId", projectFilter);
		}
		if (statusFilter != null && !statusFilter.isEmpty()) {
			query.setParameter("status", statusFilter);
		}
		if (categoryFilter != null && !categoryFilter.isEmpty()) {
			query.setParameter("category", categoryFilter);
		}
		query.setParameter("userId", userId); // Set the user ID parameter

		return query.getResultList();
	}

	private User findById(int userId) {
		return entityManager.find(User.class, userId);
	}

	// Implement other methods of the TaskDao interface...
}