package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.UserFeedback;


@Repository
public interface UserDaoInterface extends JpaRepository<UserFeedback, Integer>{

	
}
