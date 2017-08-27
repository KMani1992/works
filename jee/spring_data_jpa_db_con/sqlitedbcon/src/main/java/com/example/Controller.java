package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topics")
public class Controller {
	
	@Autowired
	private Service service;
	
	@RequestMapping("/all")
	public List<TopicModel> getAllTopics(){
		return service.getAllTopics();
	}
	
	@RequestMapping("/add")
	public void save(){
		TopicModel topic=new TopicModel();
		topic.setId(1);
		topic.setName("Mani");
		service.save(topic);		
	}

}
