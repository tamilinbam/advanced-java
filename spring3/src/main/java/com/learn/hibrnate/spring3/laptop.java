package com.learn.hibrnate.spring3;

public class laptop {
	int srno;
	String brand;
	int cost;
	public laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public laptop(int srno, String brand, int cost) {
		super();
		this.srno = srno;
		this.brand = brand;
		this.cost = cost;
	}
	public int getSrno() {
		return srno;
	}
	public void setSrno(int srno) {
		this.srno = srno;
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
	@Override
	public String toString() {
		return "laptop [srno=" + srno + ", brand=" + brand + ", cost=" + cost + "]";
	}
	
}
