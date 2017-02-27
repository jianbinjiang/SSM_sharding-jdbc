package com.demo.service;
/**
 * 
 * 创建日期 :2017年2月23日
 * @author jiangjianbin
 *
 */
import com.demo.model.User;

public interface UserService {

	public int insertOne(User user);
	
	public User selectByPk(int id); 

}
