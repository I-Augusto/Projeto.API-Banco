package me.study.apiBanco.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.study.apiBanco.model.User;
import me.study.apiBanco.repository.UserRepository;
import me.study.apiBanco.service.UserService;

@Service
public class UserServiceImpl implements UserService {

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

		if (userRepository.existsByClientCpf(userToCreate.getClient().getCpf())) {
			throw new IllegalArgumentException("Esse CPF já está cadastrado");
		} else if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
			throw new IllegalArgumentException("Essa conta já está cadastrada");
		} else if (userRepository.existsByCardNumber(userToCreate.getCard().getNumber())) {
			throw new IllegalArgumentException("Esse Cartão já está cadastrado");
		}
		Optional.ofNullable(userToCreate.getClient().getCpf()).filter(n -> !n.trim().isEmpty())
				.orElseThrow(() -> new IllegalArgumentException("O CPF não pode estar vazio"));
		Optional.ofNullable(userToCreate.getAccount().getNumber()).filter(n -> !n.trim().isEmpty())
				.orElseThrow(() -> new IllegalArgumentException("O numero da conta não pode estar vazio"));
		Optional.ofNullable(userToCreate.getCard().getNumber()).filter(n -> !n.trim().isEmpty())
				.orElseThrow(() -> new IllegalArgumentException("O numero do cartão não pode estar vazio"));

		return userRepository.save(userToCreate);
	}

}
