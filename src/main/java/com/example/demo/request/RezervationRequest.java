package com.example.demo.request;


public class RezervationRequest {
	private String username;
	private String services;
	private String startTime;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}
}
