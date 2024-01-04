package com.learn.hibrnate.hibernateproject3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class laptop {
	@Id
	int l_seno;
	String name ;
	@ManyToOne
	student st ;

	public laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public laptop(int l_seno, String name, student st) {
		super();
		this.l_seno = l_seno;
		this.name = name;
		this.st = st;
	}

	public int getL_seno() {
		return l_seno;
	}

	public void setL_seno(int l_seno) {
		this.l_seno = l_seno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public student getSt() {
		return st;
	}

	public void setSt(student st) {
		this.st = st;
	}

	@Override
	public String toString() {
		return "laptop [l_seno=" + l_seno + ", name=" + name + ", st=" + st + "]";
	} 
	
	
}
