package com.nkxgen.spring.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.dao.TaskDao;
import com.nkxgen.spring.orm.model.Task;

@Component
@Transactional
@Service
public class TaskServiceImpl implements TaskService {
	private final TaskDao taskDao;

	@Autowired
	public TaskServiceImpl(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Override
	public List<Task> getTasksByUserId(int userId) {
		return taskDao.getTasksByUserId(userId);
	}

	@Override
	public List<Task> filterTasks(short projectFilter, String statusFilter, String categoryFilter, int userId) {
		return taskDao.filterTasks(projectFilter, statusFilter, categoryFilter, userId);
	}

	// Implement other methods of the TaskService interface...
}