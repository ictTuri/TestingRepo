package com.example.demo.model;

public class Services {
	private String name;
	private double price;
	private int minutes;

	public Services(String name, double price, int minutes) {
		super();
		this.name = name;
		this.price = price;
		this.minutes = minutes;
	}

	public Services(String name) {
		super();
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
