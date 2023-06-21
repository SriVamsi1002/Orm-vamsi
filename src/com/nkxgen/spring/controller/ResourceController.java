package com.nkxgen.spring.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.nkxgen.spring.orm.model.ProjectDto;
import com.nkxgen.spring.orm.model.Role;
import com.nkxgen.spring.orm.model.Task;
import com.nkxgen.spring.orm.model.User;
import com.nkxgen.spring.orm.service.ProjectService;
import com.nkxgen.spring.orm.service.ResourceService;
import com.nkxgen.spring.orm.service.RoleService;
import com.nkxgen.spring.orm.service.TaskService;

@Controller
public class ResourceController {
	private final ResourceService resourceService;
	private final ProjectService projectService;
	private final RoleService roleService;
	private final TaskService taskService;

	@Autowired
	private User user;

	@Autowired
	private Role role;

	@Autowired
	public ResourceController(ResourceService resourceService, ProjectService projectService, RoleService roleService,
			TaskService taskService) {
		this.resourceService = resourceService;
		this.projectService = projectService;
		this.roleService = roleService;
		this.taskService = taskService;
	}

	@RequestMapping(value = "/resources", method = RequestMethod.GET)
	public String getAllResources(Model model) {
		List<User> resources = resourceService.getAllResources();

		// List<UserDto> resources = resourceService.getAllResources();
		List<ProjectDto> projects = projectService.getAllProjects(); // Retrieve all projects
		List<Role> roles = roleService.getAllRoles(); // Retrieve all roles
		System.out.println("resources List JSP Requested");
		model.addAttribute("resources", resources);
		model.addAttribute("projects", projects);
		model.addAttribute("roles", roles);

		return "ResourceHome";
	}

	// ...

	@RequestMapping(value = "/resources/filter", method = RequestMethod.GET)
	@ResponseBody
	public String filterResources(@RequestParam(name = "roleFilter", required = false) Short roleFilter,
			@RequestParam(name = "projectFilter", required = false) Short projectFilter) {
		List<User> filteredResources = resourceService.filterResources(roleFilter, projectFilter);
		Gson gson = new Gson();
		String json = gson.toJson(filteredResources);
		return json;
	}

	@RequestMapping(value = "/resources/details", method = RequestMethod.GET)
	public String getResourceDetails(@RequestParam(name = "displayName") String displayName, Model model) {

		System.out.println(displayName);
		User resource = resourceService.getResourceByDisplayName(displayName);
		model.addAttribute("resource", resource);

		System.out.println(resource.userEmployeeId);
		return "user_details";
	}

	@RequestMapping(value = "/resources/update", method = RequestMethod.GET)
	public String updateResource(@RequestParam("displayName") String displayName, Model model) {
		User resource = resourceService.getResourceByDisplayName(displayName);
		List<Role> roles = roleService.getAllRoles();

		model.addAttribute("resource", resource);
		model.addAttribute("roles", roles);

		return "update_resource";
	}

	@RequestMapping(value = "/resources/updateSuccess", method = RequestMethod.POST)
	public String updateResource(@RequestParam("originalDisplayName") String originalDisplayName,
			@RequestParam("userRole") String userRole, @RequestParam("userStatus") String userStatus) {
		// Retrieve the existing resource from the database using the original display name
		User existingResource = resourceService.getResourceByDisplayName(originalDisplayName);

		// Update the necessary fields
		existingResource.setUserStatus(existingResource.getUserStatus());
		existingResource.setUserRole(existingResource.getUserRole());
		existingResource.setUserCreationDate(existingResource.getUserCreationDate());

		existingResource.setUserLastUpdatedDate(java.sql.Date.valueOf(LocalDate.now()));

		existingResource.setUserStatus(userStatus);
		role.setRoleId(Short.parseShort(userRole.trim()));
		existingResource.setUserRole(role);
		// Save the updated resource
		resourceService.save(existingResource);

		// Redirect to the resources page or show a success message
		return "redirect:/resources";
	}

	@RequestMapping(value = "/resources/AddResource", method = RequestMethod.GET)
	public String addResource(Model model) {
		// Add necessary logic
		List<Role> roles = (List<Role>) roleService.getAllRoles();
		model.addAttribute("roles", roles);
		return "AddResource";
	}

	@RequestMapping(value = "/resources/addSuccess", method = RequestMethod.POST)
	public String addResource(@RequestParam("userId") String userId,
			@RequestParam("userDisplayName") String userDisplayName, @RequestParam("userPassword") String userPassword,
			@RequestParam("userEmployeeId") String userEmployeeId, @RequestParam("userStatus") String userStatus,
			@RequestParam("userRole") String userRole, Model model) {

		user.setUserCreationDate(new Date()); // Set current date as the creation date
		user.setUserLastUpdatedDate(new Date());
		user.setUserDisplayName(userDisplayName);
		user.setUserEmployeeId(userEmployeeId);
		user.setUserId(Integer.parseInt(userId.trim()));
		user.setUserPassword(userPassword);
		user.setUserStatus(userStatus);
		role.setRoleId(Short.parseShort(userRole.trim()));
		user.setUserRole(role);
		// Set last updated date as null
		// user.setUserRole(roleid);

		// System.out.println("role is " + roleid);
		System.out.println("role is " + user.getUserId());
		System.out.println("role is " + user.getUserRole());
		resourceService.addUser(user);
		return "redirect:/resources";
	}

	@RequestMapping(value = "/resources/tasks", method = RequestMethod.GET)
	public String viewTasksForUser(@RequestParam("userId") int userId, Model model) {
		// Assuming you have a method in your service layer to retrieve tasks by user ID

		model.addAttribute("userId", userId);
		List<Task> tasks = taskService.getTasksByUserId(userId);
		List<ProjectDto> projects = projectService.getAllProjects();
		model.addAttribute("projects", projects);
		System.out.println(tasks);
		model.addAttribute("tasks", tasks);

		model.addAttribute("tasks", tasks);
		return "TasksByName"; // Replace with the name of your JSP page to display tasks
	}

	@RequestMapping(value = "resources/tasks/filter", method = RequestMethod.GET)
	@ResponseBody
	public String filterTasks(@RequestParam(name = "projectFilter", required = false) Short projectFilter,
			@RequestParam(name = "statusFilter", required = false) String statusFilter,
			@RequestParam(name = "categoryFilter", required = false) String categoryFilter,
			@RequestParam(name = "userId") int userId) {
		System.out.println("/tasks/filter is called ");
		System.out.println(projectFilter + " " + statusFilter + " " + categoryFilter + " " + userId);
		List<Task> filteredTasks = taskService.filterTasks(projectFilter, statusFilter, categoryFilter, userId);
		Gson gson = new Gson();
		String json = gson.toJson(filteredTasks);
		return json;
	}

}
