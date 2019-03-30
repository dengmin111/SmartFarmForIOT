package com.nuc.service;

import java.util.List;

import com.nuc.pojo.User;

public interface UserService {
List<User> list();
User selectByUsernameandPassword(User user);
int insertSelective(User  record);
User selectByUsername(String username);
User selectByPrimaryKey(int id);
}
