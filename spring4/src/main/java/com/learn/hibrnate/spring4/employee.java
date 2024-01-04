package com.learn.hibrnate.spring4;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class employee {
	List<String> technolgy;
	Set<String> project;
	Map<String ,String>companies;
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public employee(List<String> technolgy, Set<String> project, Map<String, String> companies) {
		super();
		this.technolgy = technolgy;
		this.project = project;
		this.companies = companies;
	}
	public List<String> getTechnolgy() {
		return technolgy;
	}
	public void setTechnolgy(List<String> technolgy) {
		this.technolgy = technolgy;
	}
	public Set<String> getProject() {
		return project;
	}
	public void setProject(Set<String> project) {
		this.project = project;
	}
	public Map<String, String> getCompanies() {
		return companies;
	}
	public void setCompanies(Map<String, String> companies) {
		this.companies = companies;
	}
	@Override
	public String toString() {
		return "employee [technolgy=" + technolgy + ", project=" + project + ", companies=" + companies + "]";
	}
	
	
}
