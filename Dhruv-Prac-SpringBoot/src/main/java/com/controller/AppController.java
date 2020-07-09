package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.FeedbackData;
import com.bean.User;
import com.bean.UserFeedback;
import com.bean.UserWrapper;
import com.exception.ResourceNotFoundException;
import com.repository.UserDaoInterface;
import com.repository.UserRepository;
import com.service.AppService;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private AppService as;
	
	//@Autowired
	//private UserDaoInterface userDao;
	
	@Autowired
	private UserRepository repo;;
	
	@PostMapping(path="/create" , consumes="application/json", produces="application/json")
	@ResponseBody
	public List<String> createUser(@RequestBody UserWrapper userlist) {
		List<String> response = new ArrayList<String>();
		
		for(User u: userlist.getUsers()) {
			
			repo.save(u);
			
			UserFeedback uf = new UserFeedback();
			uf.setId(u.getId());
			uf.setWeek1("null");
			uf.setWeek2("null");
			uf.setWeek3("null");
			uf.setWeek4("null");
			
			as.addUser(uf); 
			response.add("Saved Users: "+u.toString());
		}
		return response;
	}
	
	@GetMapping(path="/userlist", produces="application/json")
	public List<User> getAllUsers() {
		return as.getAllUser();
	}
	
	@PutMapping(path="update/{id}")
	public UserFeedback updateFeedback(@PathVariable(value="id") int id,  @Valid @RequestBody FeedbackData fbdata) {
		return as.update(id, fbdata);			
		
		/*UserFeedback ufb = userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserFeedback", "id", id));
		UserFeedback updatedufb = null;		
		
		String weekname = fbdata.getWeekname();
		
		if(weekname.equals("w1")) {
			ufb.setWeek1(fbdata.getFeedback());
			updatedufb = userDao.save(ufb);
		}
		else if(weekname.equals("w2")) {
			if(ufb.getWeek1() == null) {
				throw new NullPointerException("Please Provide Previous Week's Feedback first");
			}else {
				ufb.setWeek2(fbdata.getFeedback());
				updatedufb = userDao.save(ufb);
			}
		}
		else if(weekname.equals("w3")) {
			if(ufb.getWeek1() == null || ufb.getWeek2() == null) {
				throw new NullPointerException("Please Provide Previous Week's Feedback first");
			}else {
				ufb.setWeek3(fbdata.getFeedback());
				updatedufb = userDao.save(ufb);
			}
		}
		else {
			if(ufb.getWeek1() == null || ufb.getWeek2() == null || ufb.getWeek3() == null) {
				throw new NullPointerException("Please Provide Previous Week's Feedback first");
			}else {
				ufb.setWeek4(fbdata.getFeedback());
				updatedufb = userDao.save(ufb);
			}
		}
		
		return updatedufb;*/
		
	}
	
	@GetMapping(path="/viewfeedback/{id}", produces="application/json")
	public String getFeedback(@PathVariable(value="id") int id) {
		return as.getAllFeedback(id);
	}

}
