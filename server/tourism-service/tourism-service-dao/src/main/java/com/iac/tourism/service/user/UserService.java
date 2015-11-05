package com.iac.tourism.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.iac.tourism.entity.user.User;
import com.iac.tourism.repository.BasicRepository;
import com.iac.tourism.repository.user.UserDao;
import com.iac.tourism.service.BasicService;


@Component
@Transactional
public class UserService extends BasicService<User,java.lang.Long> {

	@Autowired
	private UserDao userDao;
	
	@Override
	public BasicRepository<User,java.lang.Long> getRepository() {
		return userDao;
	}
}
