package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Admin;
import com.bean.User;
import com.dao.AdminDao;

@Service
@Transactional
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	public List<User> findUser(){
		 List<User> list = adminDao.select();
		 return list;
	 }
	public boolean deleteUser(Integer id) {
		return adminDao.deleteByid(id);
	}
	
}
