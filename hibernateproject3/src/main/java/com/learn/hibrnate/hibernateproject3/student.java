package com.learn.hibrnate.hibernateproject3;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class student {
	@Id
	int s_rollno;
	String s_name;
	
	@OneToMany
	List<laptop> lp ;

	public student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public student(int s_rollno, String s_name, List<laptop> lp) {
		super();
		this.s_rollno = s_rollno;
		this.s_name = s_name;
		this.lp = lp;
	}

	public int getS_rollno() {
		return s_rollno;
	}

	public void setS_rollno(int s_rollno) {
		this.s_rollno = s_rollno;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public List<laptop> getLp() {
		return lp;
	}

	public void setLp(List<laptop> lp) {
		this.lp = lp;
	}

	@Override
	public String toString() {
		return "student [s_rollno=" + s_rollno + ", s_name=" + s_name + ", lp=" + lp + "]";
	} 
	
	
	
	
	
	
}
