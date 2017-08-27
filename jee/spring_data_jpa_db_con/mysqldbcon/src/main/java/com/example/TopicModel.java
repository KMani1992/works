package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TopicModel {

	@Id
	public int id;
	public String name;
	
	public TopicModel(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	   
	
}
