package com.ToilSyC_BE.App.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ToilSyC_BE.App.Models.User;

public interface UserService {

	public Iterable<User> findAll();
	
	public Page<User> findAll(Pageable pageable);
	
	public Optional<User> findById(int id);
	
	public User save(User user);
	
	public void deleteById(int id);
	
}
