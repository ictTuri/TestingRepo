package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.example.demo.AppManageException;
import com.example.demo.model.Rezervation;
import com.example.demo.model.Services;
import com.example.demo.model.User;
import com.example.demo.repository.AppRepositoryImpl;

class AppServiceTest {
	private static AppRepositoryImpl appRepository;
	private static AppServiceImpl appService;
	
	@BeforeAll
	public static void initializeBeforeAllTestMethods() {
		appRepository = new AppRepositoryImpl();
		appService = new AppServiceImpl(appRepository);
	}
	
	@Test
	void testAddUser() {
		User usr = appService.addUser(new User("Artur", "Molla", "mollaartur13@gmail.com"));
		String expected = "ArturMolla";
		assertEquals(expected, usr.getUsername());
	}

	@Test
	void testAddServices() {
		appRepository.getServices().add(new Services("Die Hair", 200, 35));
		assertThrows( AppManageException.class,testServiceMethod());
	}

	private Executable testServiceMethod() {
		return () -> appService.addServices(new Services("Die Hair", 200, 35));
	}

	@Test
	void testAddRezervation() {
		appRepository.getUsers().add(new User("Armonel","Molla","Armo93@gmail.com"));
		appRepository.getServices().add(new Services("Beard Trim",250,30));
		assertThrows(AppManageException.class, rezervationCheck());
	}

	private Executable rezervationCheck() {
		return () -> appService.addRezervation(new Rezervation("ArmonelMolla","Hair Cut","2021-03-12T15:00",appService.getServiceTime("Beard Trim")));
	}

	@Test
	void testShowRezervations() {
		appRepository.getRezervations().add(new Rezervation("ArmonelMolla","Hair Cut","2021-03-12T15:00",appService.getServiceTime("Hair Cut")));
		appRepository.getRezervations().add(new Rezervation("ArturMolla","Beard Trim","2021-03-12T16:00",appService.getServiceTime("Beard Trim")));
		appRepository.getRezervations().add(new Rezervation("Test","Beard Trim","2021-03-12T17:00",appService.getServiceTime("Beard Trim")));
		
		assertEquals(2, appService.showRezervations("Beard Trim").size());
	
		}

}
