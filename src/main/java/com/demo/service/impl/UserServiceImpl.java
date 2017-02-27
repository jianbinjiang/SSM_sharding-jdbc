package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.UserDAO;
import com.demo.model.User;
import com.demo.service.UserService;
 
 /**
  * 
  * 创建时间:2017年2月23日
  * @author jiangjianbin
  *
  */
@Transactional(propagation=Propagation.REQUIRED,readOnly=false,isolation=Isolation.DEFAULT) 
@Service
public class UserServiceImpl implements UserService{
 
    @Autowired
    @Qualifier("userDAO")
    private UserDAO userDAO;
     
    public int insertOne(User user) {
        return userDAO.insertOne(user);
    }

	public User selectByPk(int id) {
		return userDAO.selectByPk(id);
	}
 
}