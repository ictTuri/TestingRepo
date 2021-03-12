package com.example.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.AppManageException;
import com.example.demo.model.Rezervation;
import com.example.demo.model.Services;
import com.example.demo.model.User;
import com.example.demo.repository.AppRepository;

@Service
public class AppServiceImpl implements AppService {

	AppRepository appRepository;

	public AppServiceImpl(AppRepository appRepository) {
		super();
		this.appRepository = appRepository;
	}

	@Override
	public User addUser(User user) {
		if(appRepository.existUser(user.getEmail())) {
			throw new AppManageException("User with this email already exists !");
		}else {
			return appRepository.saveUser(user);
		}
	}

	@Override
	public Services addServices(Services request) {
		if(appRepository.existService(request.getName())){
			throw new AppManageException("This Service already exists !");
		}else {
			return appRepository.saveServices(request);
		}
	}

	@Override
	public Rezervation addRezervation(Rezervation request) {
		if(appRepository.existUserWithUsername(request.getUsername())) {
			if(appRepository.existService(request.getServices())) {
				appRepository.saveRezervation(request);
				return request;
			}else {
				throw new AppManageException("This Service does not exists !");
			}
		}else {
			throw new AppManageException("This Username does not exists !");
		}
	}

	@Override
	public List<Rezervation> showRezervations(String request) {
		return appRepository.displayRezervations(request);
	}

	@Override
	public int getServiceTime(String name) {
		return appRepository.returnServiceTime(name);
	}
	
}
