package com.learn.hibrnate.hibrnateProject1;

import javax.persistence.Id;

@Entity
public class student {
	@Id
	int rollno;
	String name;
	int mark;
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public student(int rollno, String name, int mark) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.mark = mark;
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
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "student [rollno=" + rollno + ", name=" + name + ", mark=" + mark + "]";
	}
	
}
