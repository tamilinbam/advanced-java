package com.learn.hibrnate.hibernateproject2;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
@Entity
public class software {
	@Id
	int b_engine_no;
	String brand ; 
	int cost;
	@ManyToMany
	List<technology> p ;
	public software() {
		super();
		// TODO Auto-generated constructor stub
	}
	public software(int b_engine_no, String brand, int cost, List<technology> p) {
		super();
		this.b_engine_no = b_engine_no;
		this.brand = brand;
		this.cost = cost;
		this.p = p;
	}
	public int getB_engine_no() {
		return b_engine_no;
	}
	public void setB_engine_no(int b_engine_no) {
		this.b_engine_no = b_engine_no;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public List<technology> getP() {
		return p;
	}
	public void setP(List<technology> p) {
		this.p = p;
	}
	@Override
	public String toString() {
		return "bike [b_engine_no=" + b_engine_no + ", brand=" + brand + ", cost=" + cost + ", p=" + p + "]";
	}
	
	
}
