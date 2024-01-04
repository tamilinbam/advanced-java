package com.learn.hibrnate.hibernateproject2;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
@Entity
public class technology {
	@Id
 int p_id;
 String name;
 int age ;
 @ManyToMany
 List<software> b;
public technology() {
	super();
	// TODO Auto-generated constructor stub
}

public technology(int p_id, String name, int age, List<software> b) {
	super();
	this.p_id = p_id;
	this.name = name;
	this.age = age;
	this.b = b;
}

public int getP_id() {
	return p_id;
}
public void setP_id(int p_id) {
	this.p_id = p_id;
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
public List<software> getB() {
	return b;
}
public void setB(List<software> b) {
	this.b = b;
}

@Override
public String toString() {
	return "peron [p_id=" + p_id + ", name=" + name + ", age=" + age + ", b=" + b + "]";
}


 

 

  
}
