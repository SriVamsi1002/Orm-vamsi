package com.nkxgen.spring.orm.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sample_s4_SprintTasks")
public class SprintTask {

	@Override
	public String toString() {
		return "SprintTask [id=" + id + ", user=" + user + "]";
	}

	public SprintTask() {
		// TODO Auto-generated constructor stub
	}

	@EmbeddedId
	private Sprinttaskid id;
	@ManyToOne

	@JoinColumn(name = "user_id")
	private User user;

	public Sprinttaskid getId() {
		return id;
	}

	public void setId(Sprinttaskid id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
