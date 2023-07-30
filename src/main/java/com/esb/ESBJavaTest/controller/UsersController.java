package com.esb.ESBJavaTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esb.ESBJavaTest.model.entity.Users;
import com.esb.ESBJavaTest.service.UsersService;


@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	// ==========================================================

	//顯示所有User與其對應的喜好紀錄
	@GetMapping("/users/allUsers")
	@ResponseBody
	public List<Users> showAllUsersJson() {
		List<Users> usersList = usersService.findAllUsers();

		return usersList;
	}
	
	
}
