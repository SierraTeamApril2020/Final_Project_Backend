package com.service;

import java.util.List;

import com.bean.FeedbackData;
import com.bean.User;
import com.bean.UserFeedback;

public interface AppServiceInterface {
	public void addUser(UserFeedback uf);
	public List<User> getAllUser();
	public UserFeedback update(int id, FeedbackData fbdata);
	public String getAllFeedback(int id);
}
