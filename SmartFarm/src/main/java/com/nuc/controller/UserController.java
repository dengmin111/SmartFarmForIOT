package com.nuc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import com.nuc.pojo.User;
import com.nuc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("listUser")
	@ResponseBody
	public List<User> listUser(){
		List<User> listUser = userService.list();
	
		return listUser;
	}
	
     
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public   User login(@RequestBody User user ){
		User user2 =userService.selectByUsernameandPassword(user);
		return user2;
	}
    
	@RequestMapping(value="regist",method=RequestMethod.POST)
	@ResponseBody
	public   int regist(@RequestBody User user ){
		int a=0;
		if(userService.selectByUsername(user.getUsername())==null){
		 a =userService.insertSelective(user);}
		else {
			return 0;
		}
		return a;
	}
}
