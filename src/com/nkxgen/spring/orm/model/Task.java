package com.nkxgen.spring.orm.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "s4_Tasks")
public class Task {
	@Id
	@Column(name = "task_id")
	private int taskId;

	@Column(name = "task_name", length = 200)
	private String taskName;

	@Column(name = "task_cdatetime")
	private Timestamp taskCreationDateTime;

	@Column(name = "task_type", length = 4)
	private String taskType;

	@ManyToOne
	@JoinColumn(name = "task_ref_task_id")
	private Task referencedTask;

	@Column(name = "task_category", length = 50)
	private String taskCategory;

	@Column(name = "task_desc", columnDefinition = "text")
	private String taskDescription;

	@ManyToOne
	@JoinColumn(name = "task_creator")
	private User taskCreator;

	@Column(name = "task_noh_reqd")
	private BigDecimal numberOfHoursRequired;

	@Column(name = "task_exp_datetime")
	private Timestamp taskExpectedDateTime;

	@Column(name = "task_cmp_datetime")
	private Timestamp taskCompletedDateTime;

	@ManyToOne
	@JoinColumn(name = "task_supervisor")
	private User taskSupervisor;

	@Column(name = "task_remarks", length = 200)
	private String taskRemarks;

	@Column(name = "task_status", length = 4)
	private String taskStatus;

	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "modl_id")
	private Module module;

	// Constructors
	public Task() {
	}

	public Task(String taskName, Timestamp taskCreationDateTime, String taskType, Task referencedTask,
			String taskCategory, String taskDescription, User taskCreator, BigDecimal numberOfHoursRequired,
			Timestamp taskExpectedDateTime, Timestamp taskCompletedDateTime, User taskSupervisor, String taskRemarks,
			String taskStatus, Project project, Module module) {
		this.taskName = taskName;
		this.taskCreationDateTime = taskCreationDateTime;
		this.taskType = taskType;
		this.referencedTask = referencedTask;
		this.taskCategory = taskCategory;
		this.taskDescription = taskDescription;
		this.taskCreator = taskCreator;
		this.numberOfHoursRequired = numberOfHoursRequired;
		this.taskExpectedDateTime = taskExpectedDateTime;
		this.taskCompletedDateTime = taskCompletedDateTime;
		this.taskSupervisor = taskSupervisor;
		this.taskRemarks = taskRemarks;
		this.taskStatus = taskStatus;
		this.project = project;
		this.module = module;
	}

	// Getters and Setters
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Timestamp getTaskCreationDateTime() {
		return taskCreationDateTime;
	}

	public void setTaskCreationDateTime(Timestamp taskCreationDateTime) {
		this.taskCreationDateTime = taskCreationDateTime;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public Task getReferencedTask() {
		return referencedTask;
	}

	public void setReferencedTask(Task referencedTask) {
		this.referencedTask = referencedTask;
	}

	public String getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public User getTaskCreator() {
		return taskCreator;
	}

	public void setTaskCreator(User taskCreator) {
		this.taskCreator = taskCreator;
	}

	public BigDecimal getNumberOfHoursRequired() {
		return numberOfHoursRequired;
	}

	public void setNumberOfHoursRequired(BigDecimal numberOfHoursRequired) {
		this.numberOfHoursRequired = numberOfHoursRequired;
	}

	public Timestamp getTaskExpectedDateTime() {
		return taskExpectedDateTime;
	}

	public void setTaskExpectedDateTime(Timestamp taskExpectedDateTime) {
		this.taskExpectedDateTime = taskExpectedDateTime;
	}

	public Timestamp getTaskCompletedDateTime() {
		return taskCompletedDateTime;
	}

	public void setTaskCompletedDateTime(Timestamp taskCompletedDateTime) {
		this.taskCompletedDateTime = taskCompletedDateTime;
	}

	public User getTaskSupervisor() {
		return taskSupervisor;
	}

	public void setTaskSupervisor(User taskSupervisor) {
		this.taskSupervisor = taskSupervisor;
	}

	public String getTaskRemarks() {
		return taskRemarks;
	}

	public void setTaskRemarks(String taskRemarks) {
		this.taskRemarks = taskRemarks;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
}
