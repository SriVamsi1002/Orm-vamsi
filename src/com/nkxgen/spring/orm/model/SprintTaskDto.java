package com.nkxgen.spring.orm.model;

public class SprintTaskDto {

	private int sprn_id;
	private int task_id;
	private int user_id;

	public int getSprn_id() {
		return sprn_id;
	}

	public void setSprn_id(int sprn_id) {
		this.sprn_id = sprn_id;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public static SprintTaskDto fromEntity(SprintTask sprintTask) {
		SprintTaskDto SprintTaskdto = new SprintTaskDto();
		SprintTaskdto.setSprn_id(sprintTask.getId().getSprint().getSprintId());
		SprintTaskdto.setTask_id(sprintTask.getId().getTask().getTaskId());
		SprintTaskdto.setUser_id(sprintTask.getUser().getUserId());

		return SprintTaskdto;
	}

}
