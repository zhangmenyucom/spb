package com.taylor.spb.controller;

import com.taylor.spb.entity.UserEntity;
import com.taylor.spb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/find")
	public Object getUser(HttpServletRequest request, UserEntity userEnitty) {
		return userService.queryUser(userEnitty);
	}

}
