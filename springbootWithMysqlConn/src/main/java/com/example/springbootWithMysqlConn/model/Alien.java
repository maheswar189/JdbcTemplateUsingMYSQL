package com.example.springbootWithMysqlConn.model;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Lazy
public class Alien {

	public Alien() {
		super();
		System.out.println("Alien object is created.....");
	}
	private String id;
	private String name;
	private String technology;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", technology=" + technology + "]";
	}
	
	
}
