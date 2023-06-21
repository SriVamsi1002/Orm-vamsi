package com.nkxgen.spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.nkxgen.spring.orm.model.Project;
import com.nkxgen.spring.orm.model.Role;
import com.nkxgen.spring.orm.model.User;

@Component
public class ResourceDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<User> getAllResources() {
		String jpql = "SELECT r FROM User r";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	public List<User> filterResources(Short roleFilter, Short projectFilter) {
		String jpql = "SELECT DISTINCT u FROM User u WHERE 1=1  AND ( u.userRole.id = :roleFilter AND  u.id IN (SELECT t.taskSupervisor.id FROM Task t WHERE t.project.id = :projectFilter))";
		String projqry = "SELECT DISTINCT u FROM User u WHERE 1=1  AND  u.userRole.id = :roleFilter";
		String roleqry = "SELECT DISTINCT u FROM User u WHERE 1=1  AND u.id IN (SELECT t.taskSupervisor.id FROM Task t WHERE t.project.id = :projectFilter)";
		String allqry = "SELECT DISTINCT u FROM User u";

		if (roleFilter == null) {
			jpql = roleqry;
			if (projectFilter == null) {
				jpql = allqry;
			}

		} else if (projectFilter == null) {
			jpql = projqry;
		}

		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);

		System.out.println("in2");
		if (roleFilter != null) {
			System.out.println("in2");
			Role role = findById(roleFilter);

			query.setParameter("roleFilter", role.getRoleId());
		}

		System.out.println("in3");
		if (projectFilter != null) {
			Project project = findProjectById(projectFilter);
			query.setParameter("projectFilter", project.getProjectId());
		}

		System.out.println("in4");
		return query.getResultList();
	}

	public Role findById(Short id) {
		return entityManager.find(Role.class, id);
	}

	public Project findProjectById(Short projectId) {
		System.out.println("in findprojbyid");
		return entityManager.find(Project.class, projectId);
	}

	public User getResourceByDisplayName(String displayName) {
		String jpql = "SELECT r FROM User r WHERE r.userDisplayName = :displayName";
		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		query.setParameter("displayName", displayName);

		System.out.println(displayName);
		List<User> resultList = query.getResultList();
		if (!resultList.isEmpty()) {
			return resultList.get(0);
		}

		System.out.println("fan   ");
		return null;
	}

	private User findByName(String displayName) {
		// TODO Auto-generated method stub
		return entityManager.find(User.class, displayName);
	}

	public void addUser(User user) {
		entityManager.persist(user);
	}

	public void saveUser(User existingResource) {
		entityManager.merge(existingResource);
	}

	public User findById(short id) {
		return entityManager.find(User.class, id);
	}

	public Role findById(int id) {
		return entityManager.find(Role.class, id);
	}
}
