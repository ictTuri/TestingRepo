package com.example.demo.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Rezervation {
	private String username;
	private String startTime;
	private String endTime;
	private String services;
	
	public Rezervation(String username, String services, String startTime,int serviceTime) {
		super();
		this.username = username;
		this.services = services;
		this.startTime = startTime;
		this.endTime = convertion(startTime,serviceTime);
	}
	
	public String convertion(String time, int serviceTime) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime temp = LocalDateTime.parse(time);
		temp = temp.plus(Duration.ofMinutes(serviceTime));
		return dtf.format(temp);
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

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}
}
