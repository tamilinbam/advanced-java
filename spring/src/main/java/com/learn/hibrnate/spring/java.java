package com.learn.hibrnate.spring;

public class java {
	int id;
	String name;
	public java() {
		super();
		// TODO Auto-generated constructor stub
	}
	public java(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "java [id=" + id + ", name=" + name + "]";
	}
	
}
