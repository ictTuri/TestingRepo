package com.example.demo.service;


import java.util.List;

import com.example.demo.model.Rezervation;
import com.example.demo.model.Services;
import com.example.demo.model.User;

public interface AppService {
	
	User addUser(User user);
	
	Services addServices(Services request);
	
	Rezervation addRezervation(Rezervation request);
	
	List<Rezervation> showRezervations(String request);
	
	int getServiceTime(String name);
}
