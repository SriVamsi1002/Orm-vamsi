package com.nkxgen.spring.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.dao.ResourceDAO;
import com.nkxgen.spring.orm.model.User;

@Component
@Transactional
public class ResourceService {

	private final ResourceDAO resourceDAO;

	@Autowired
	public ResourceService(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}

	public List<User> getAllResources() {
		return resourceDAO.getAllResources();
	}

	public List<User> filterResources(Short roleFilter, Short projectFilter) {
		return resourceDAO.filterResources(roleFilter, projectFilter);
	}

	public User getResourceByDisplayName(String displayName) {
		return resourceDAO.getResourceByDisplayName(displayName);
	}

	public void addUser(User user) {
		resourceDAO.addUser(user);
	}

	public void save(User existingResource) {
		resourceDAO.saveUser(existingResource);

	}
}
