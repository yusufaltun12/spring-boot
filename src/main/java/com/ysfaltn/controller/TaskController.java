package com.ysfaltn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysfaltn.entity.TaskEntity;
import com.ysfaltn.service.TaskServiceImp;

@Controller
@RequestMapping(value = "/task")
public class TaskController 
{
	@Autowired
	private TaskServiceImp taskService;
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST )
	public String addTask(@RequestParam("title") String title)
	{
		TaskEntity entity = new TaskEntity();
		entity.setTitle(title);
		entity.setStatus("ACTIVE");
		
		taskService.addTask(entity);
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping(value = "/get/all", method = RequestMethod.GET )
	public List<TaskEntity> getAll()
	{
		return taskService.getAllTasks();
	}
	
	@ResponseBody
	@RequestMapping(value = "/set/status", method = RequestMethod.POST )
	public String setStatus(@RequestParam("status") String status, @RequestParam("id") int id)
	{
		taskService.setStatus(status, id);
		return "200";
	}
}
