package com.ysfaltn.service;

import java.util.List;

import com.ysfaltn.entity.TaskEntity;

public interface TaskService 
{
	public TaskEntity getTask(int id);
	public boolean delete(int id);
	public List<TaskEntity> getAllTasks();
	public boolean addTask(TaskEntity entity);
}
