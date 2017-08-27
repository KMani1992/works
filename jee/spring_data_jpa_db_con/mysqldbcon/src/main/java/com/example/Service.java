package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private CURDInterface crudInterface;
	
	public List<TopicModel> getAllTopics(){
		List<TopicModel> list=new ArrayList<TopicModel>();
		crudInterface.findAll().forEach(list::add);
		return list;
	}
	
	
	public void save(TopicModel topic){
		crudInterface.save(topic);		
	}
	
}
