package com.app.demo.model;

public class Laptop {

	private String brand;
	private String model;
		
	public Laptop(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", model=" + model + "]";
	}
	
	
}
