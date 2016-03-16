package com.suddenlyjune.financialinvestment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suddenlyjune.financialinvestment.dao.User;
import com.suddenlyjune.financialinvestment.dao.UserDAO;

@Service("usersService")
public class UsersService {
	private UserDAO usersDao;
	
	@Autowired
	public void setUsersDao(UserDAO usersDao) {
		this.usersDao = usersDao;
	}


	public void create(User user) {
		usersDao.create(user);
		
	}

	/*//in order to try the error interface of the websites when giving a bad request(so far database doesn't have id number 999)
	public void throwTestException() {
		usersDao.getOffer(999);
		
	}*/
}
