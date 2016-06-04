package com.ysfaltn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysfaltn.entity.TaskEntity;
import com.ysfaltn.repository.TaskRepository;

@Service 
public class TaskServiceImp implements TaskService
{
	
	@Autowired
	private TaskRepository taskRepo;
	
	public TaskEntity getTask(int id)
	{
		return taskRepo.findOne(id);
	}

	public boolean delete(int id)
	{
		TaskEntity entity = taskRepo.findOne(id);
		if(entity != null)
		{
			entity.setStatus("DELETED");
			taskRepo.save(entity);
			return true;
		}
		return false;
	}

	public List<TaskEntity> getAllTasks() 
	{
		List<TaskEntity> tasks = new ArrayList<TaskEntity>();
		for (TaskEntity taskEntity : taskRepo.getAll())
		{
			tasks.add(taskEntity);
		}
		
		return tasks;
	}

	public boolean addTask(TaskEntity entity) 
	{
		if(entity != null && entity.getStatus() != null && entity.getTitle() != null )
		{
			taskRepo.save(entity);
			return true;
		}
		
		return false;
	}
	
	public boolean setStatus(String status, int id)
	{
		TaskEntity entity = getTask(id);
		if(entity != null)
		{
			entity.setStatus("DONE");
			taskRepo.save(entity);
			
			return true;
		}
		
		return false;
	}
}
