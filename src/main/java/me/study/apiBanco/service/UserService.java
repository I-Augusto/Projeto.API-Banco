package me.study.apiBanco.service;

import me.study.apiBanco.model.User;

public interface UserService {

	User findById(Long id);
	
	User create(User userToCreate);
}
