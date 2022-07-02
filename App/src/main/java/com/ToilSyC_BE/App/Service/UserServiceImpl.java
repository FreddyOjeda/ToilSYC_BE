package com.ToilSyC_BE.App.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ToilSyC_BE.App.Models.User;
import com.ToilSyC_BE.App.Repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<User> findAll(Pageable pageable) {
		
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<User> findById(int id) {
		
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public User save(User user) {
		
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

}
