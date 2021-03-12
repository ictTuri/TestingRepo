package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Rezervation;
import com.example.demo.model.Services;
import com.example.demo.model.User;

@Service
public class AppRepositoryImpl implements AppRepository {
	List<User> users = new ArrayList<>();
	List<Services> services = new ArrayList<>();
	List<Rezervation> rezervations = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Rezervation> getRezervations() {
		return rezervations;
	}

	public void setRezervations(List<Rezervation> rezervations) {
		this.rezervations = rezervations;
	}

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	@Override
	public User saveUser(User user) {
		users.add(user);
		return user;
	}

	@Override
	public Services saveServices(Services request) {
		services.add(request);
		return request;
	}

	@Override
	public boolean existUser(String email) {
		for (User user : users)
			if (user.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		return false;
	}

	@Override
	public boolean existUserWithUsername(String username) {
		for (User user : users)
			if (user.getUsername().equalsIgnoreCase(username)) {
				return true;
			}
		return false;
	}

	@Override
	public Rezervation saveRezervation(Rezervation request) {
		rezervations.add(request);
		return request;
	}

	@Override
	public boolean existService(String name) {
		for (Services service : services)
			if (service.getName().equalsIgnoreCase(name)) {
				return true;
			}
		return false;
	}

	@Override
	public List<Rezervation> displayRezervations(String request) {
		List<Rezervation> queryList = new ArrayList<>();
		for (Rezervation temp : rezervations)
			if (temp.getServices().contentEquals(request)) {
				queryList.add(temp);
			}
		return queryList;
	}

	@Override
	public int returnServiceTime(String name) {
		for (Services s : services)
			if (s.getName().equalsIgnoreCase(name)) {
				return s.getMinutes();
			}
		return -1;
	}
}
