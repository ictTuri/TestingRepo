package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Rezervation;
import com.example.demo.model.Services;
import com.example.demo.model.User;
import com.example.demo.request.RezervationRequest;
import com.example.demo.request.UserRequest;
import com.example.demo.service.AppService;

@RestController
@RequestMapping
public class AppController {
	private AppService appService;

	@Autowired
	public AppController(AppService appService) {
		super();
		this.appService = appService;
	}

	@PostMapping("/register")
	public User addUser(@RequestBody UserRequest request) {
		return appService.addUser(new User(request.getFirstName(), request.getLastName(), request.getEmail()));
	}

	@PostMapping("/register/services")
	public Services addService(@RequestBody Services request) {
		return appService.addServices(request);
	}

	@PostMapping("/rezervation")
	public Rezervation addRezervation(@RequestBody RezervationRequest request) {
		return appService.addRezervation(initializeClassRezervation(request));
	}

	private Rezervation initializeClassRezervation(RezervationRequest request) {
		return new Rezervation(request.getUsername(), request.getServices(), request.getStartTime(),
				appService.getServiceTime(request.getServices()));
	}

	@GetMapping("/showall/{service}")
	public List<Rezervation> showAll(@PathVariable("service") String serviceName) {
		return appService.showRezervations(serviceName);
	}
}
