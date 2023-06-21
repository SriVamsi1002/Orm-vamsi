package com.nkxgen.spring.orm.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Sprinttaskid implements Serializable {
	@ManyToOne
	@JoinColumn(name = "sprn_id")
	private Sprint sprint;

	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
