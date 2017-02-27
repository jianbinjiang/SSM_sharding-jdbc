package com.demo.dao;
/**
 * 
 * 创建日期 :2017年2月23日
 * @author jiangjianbin
 *
 */

import com.demo.model.User;

public interface UserDAO {
	public int insertOne(User user);  
	  
    User selectByPk(int id); 
}
