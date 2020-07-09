package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
