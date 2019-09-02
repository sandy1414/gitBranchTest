package com.marketplace.usermanager.UserManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.usermanager.UserManager.Repo.UserRepository;
import com.marketplace.usermanager.UserManager.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User addUser(User usr) {
		User usr1 = null;
		if(usr.getId() != 0) {
			usr1 = userRepo.save(usr);
		}
		return usr1;
	}
}
