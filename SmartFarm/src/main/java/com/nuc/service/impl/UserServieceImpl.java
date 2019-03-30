package com.nuc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nuc.mapper.UserMapper;
import com.nuc.pojo.User;
import com.nuc.service.UserService;

@Service
public class UserServieceImpl implements UserService{

	
	@Autowired
	UserMapper userMapper ;

	@Override
	public List<User> list() {
	
		return userMapper.list();
	}

	@Override
	public User selectByUsernameandPassword(User user){
		return userMapper.selectByUsernameandPassword(user);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.selectByUsername(username);
	}

	@Override
	public User selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

}
