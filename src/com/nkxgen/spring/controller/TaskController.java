package com.nkxgen.spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nkxgen.spring.orm.model.Task;
import com.nkxgen.spring.orm.service.TaskService;

@Controller
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public String viewTasksForUser(Model model) {
		// Use the userId to fetch the tasks
		Integer userId = 1;
		List<Task> tasks = taskService.getTasksByUserId(userId);

		// Add the tasks to the model
		model.addAttribute("tasks", tasks);

		// Return the view name
		return "Taskslist";
	}

}
