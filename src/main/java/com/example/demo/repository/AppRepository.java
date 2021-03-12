package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Rezervation;
import com.example.demo.model.Services;
import com.example.demo.model.User;

public interface AppRepository {
	boolean existUser(String email);
	
	boolean existUserWithUsername(String username);
	
	boolean existService(String name);

	User saveUser(User request);
	
	Services saveServices(Services request);
	
	Rezervation saveRezervation(Rezervation request);

	List<Rezervation> displayRezervations(String request);
	
	int returnServiceTime(String name);

}
