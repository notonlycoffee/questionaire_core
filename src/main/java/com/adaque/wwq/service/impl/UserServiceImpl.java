package com.adaque.wwq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaque.wwq.mapper.UserMapper;
import com.adaque.wwq.po.User;
import com.adaque.wwq.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(int id) {
		return userMapper.getUserById(id);
	}

}
