package com.ToilSyC_BE.App.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ToilSyC_BE.App.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
