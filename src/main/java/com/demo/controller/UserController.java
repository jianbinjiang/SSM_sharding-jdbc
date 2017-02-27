package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;
import com.demo.service.UserService;

/**
 * 
 * 创建时间:2017年2月23日
 * @author jiangjianbin
 *
 */
@Controller
public class UserController {
 
	@Autowired
	private UserService userService;
    @RequestMapping(value="index")
    public ModelAndView index(User user){
    	long timeStamp = System.currentTimeMillis();
    	int id =Integer.parseInt(String.valueOf(timeStamp).substring(4, String.valueOf(timeStamp).length()-1)); 
    	user.setId(id);
    	userService.insertOne(user);
    	User u = userService.selectByPk(id);
    	System.out.println(u);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("index");
        mav.addObject("user",user);
        return mav;
    }
     
}