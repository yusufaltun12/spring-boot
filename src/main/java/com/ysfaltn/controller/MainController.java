package com.ysfaltn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ysfaltn.service.TaskServiceImp;

@Controller
@ComponentScan
public class MainController 
{
	@Autowired
	public TaskServiceImp service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET )
	public ModelAndView gotoMain()
	{
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("tasks", service.getAllTasks());
		return modelAndView;
	}
}
