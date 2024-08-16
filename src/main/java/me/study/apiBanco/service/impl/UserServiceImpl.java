package me.study.apiBanco.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.study.apiBanco.model.User;
import me.study.apiBanco.repository.UserRepository;
import me.study.apiBanco.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		if(userToCreate != null && userRepository.existsByClientCpf(userToCreate.getClient().getCpf())) {
			throw new IllegalArgumentException("Esse CPF já está cadastrado");
		}		
		return userRepository.save(userToCreate);
	}

}
