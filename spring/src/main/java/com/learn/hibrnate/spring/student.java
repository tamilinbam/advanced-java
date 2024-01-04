package com.learn.hibrnate.spring;

public class student {
	int rollno;
	String name;
	int age;
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public student(int rollno, String name, int age) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "student [rollno=" + rollno + ", name=" + name + ", age=" + age + "]";
	}
	
}
