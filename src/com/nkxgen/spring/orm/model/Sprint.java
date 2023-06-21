package com.nkxgen.spring.orm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "s4_sprints")
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "sprn_id")
	private int sprintId;
	@ManyToOne
	@JoinColumn(name = "sprn_modl_id")
	private Module module;

	@ManyToOne
	@JoinColumn(name = "sprn_master")
	private User user;

	@Column(name = "sprn_stdate")
	private Date startDate;

	@Column(name = "sprn_enddate")
	private Date endDate;

	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project project;

	@Column(name = "sprint_name")
	private String sprintName;

	public Sprint() {

	}

	public Sprint(int sprintId, Module module, User user, Date startDate, Date endDate, Project project,
			String sprintName) {
		super();
		this.sprintId = sprintId;
		this.module = module;
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
		this.project = project;
		this.sprintName = sprintName;
	}

	public int getSprintId() {
		return sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public Project getproj_id() {
		return project;
	}

	public Module getsprn_modl_id() {
		return module;
	}

	public User getsprn_master() {
		return user;
	}

	@Override
	public String toString() {
		return "Sprint [sprintId=" + sprintId + ", module=" + module + ", user=" + user + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", project=" + project + ", sprintName=" + sprintName + "]";
	}

	// Constructors, getters, and setters
	//
	// public int getSprintId() {
	// return sprintId;
	// }
	//
	// public void setSprintId(int sprintId) {
	// this.sprintId = sprintId;
	// }
	//
	// public int getModuleId() {
	// return moduleId;
	// }
	//
	// public void setModuleId(Module module) {
	// this.moduleId = moduleId;
	// }
	//
	// public int getMasterId() {
	// return masterId;
	// }
	//
	// public void setMasterId(int masterId) {
	// this.masterId = masterId;
	// }
	//
	// public Timestamp getStartDate() {
	// return startDate;
	// }
	//
	// public void setStartDate(Timestamp startDate) {
	// this.startDate = startDate;
	// }
	//
	// public Timestamp getEndDate() {
	// return endDate;
	// }
	//
	// public void setEndDate(Timestamp endDate) {
	// this.endDate = endDate;
	// }
	//
	// public int getProjectId() {
	// return projectId;
	// }
	//
	// public void setProjectId(int projectId) {
	// this.projectId = projectId;
	// }
	//
	// public String getSprintName() {
	// return sprintName;
	// }
	//
	// public void setSprintName(String sprintName) {
	// this.sprintName = sprintName;
	// }
}
