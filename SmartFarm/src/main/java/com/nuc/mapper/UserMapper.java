package com.nuc.mapper;

import java.util.List;

import com.nuc.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByUsernameandPassword(User user);
    
    User selectByUsername(String username);
    
    List<User> list();
}