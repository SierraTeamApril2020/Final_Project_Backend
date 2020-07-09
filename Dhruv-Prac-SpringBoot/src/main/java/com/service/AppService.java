package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.FeedbackData;
import com.bean.User;
import com.bean.UserFeedback;
import com.exception.ResourceNotFoundException;
import com.repository.UserDaoInterface;
import com.repository.UserRepository;


@Service
public class AppService implements AppServiceInterface{
	
	@Autowired
	private UserDaoInterface userDao;
	
	@Autowired
	private UserRepository repo;;
	
	@Transactional
	public void addUser(UserFeedback uf) {
		userDao.save(uf);
		
	}

	@Transactional
	public List<User> getAllUser() {
		return repo.findAll();
	}

	@Transactional
	public UserFeedback update(int id, FeedbackData fbdata) {
		UserFeedback ufb = userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserFeedback", "id", id));
		UserFeedback updatedufb = null;		
		
		String weekname = fbdata.getWeekname();
		
		if(weekname.equals("w1")) {
			ufb.setWeek1(fbdata.getFeedback());
			updatedufb = userDao.save(ufb);
		}
		else if(weekname.equals("w2")) {
			if(ufb.getWeek1().equals("null")) {
				throw new NullPointerException("Please Provide Previous Week's Feedback first");
			}else {
				ufb.setWeek2(fbdata.getFeedback());
				updatedufb = userDao.save(ufb);
			}
		}
		else if(weekname.equals("w3")) {
			if(ufb.getWeek1().equals("null") || ufb.getWeek2().equals("null")) {
				throw new NullPointerException("Please Provide Previous Week's Feedback first");
			}else {
				ufb.setWeek3(fbdata.getFeedback());
				updatedufb = userDao.save(ufb);
			}
		}
		else {
			if(ufb.getWeek1().equals("null") || ufb.getWeek2().equals("null") || ufb.getWeek3().equals("null")) {
				throw new NullPointerException("Please Provide Previous Week's Feedback first");
			}else {
				ufb.setWeek4(fbdata.getFeedback());
				updatedufb = userDao.save(ufb);
			}
		}
		
		return updatedufb;
	}

	@Override
	@Transactional
	public String getAllFeedback(int id) {
		
		UserFeedback ufb1 = userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserFeedback", "id", id));
		return ufb1.toString();
	}
}
