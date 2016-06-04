package com.ysfaltn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.ysfaltn.service.TaskService;
import com.ysfaltn.service.TaskServiceImp;

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@ComponentScan("com.ysfaltn")
public class Application
{
	@Autowired 
	TaskServiceImp taskService;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}