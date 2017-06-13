package com.taylor.spb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taylor.spb.entity.UserEntity;
import com.taylor.spb.mapper.UserMapper;
import com.taylor.spb.service.UserService;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.ServletContextPropertyUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserEntity queryUser(UserEntity entity) {
		return userMapper.selectOne(entity);
	}

}
