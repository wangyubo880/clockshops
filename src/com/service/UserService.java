package com.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Admin;
import com.bean.Receive;
import com.bean.User;
import com.dao.UserDao;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	 public List<User> findAll(){
		 List<User> list = userDao.select();
		 return list;
	 }
	public boolean register(User user,String imgurl) {
		// TODO Auto-generated method stub
		
		return userDao.insert(user, imgurl);
	}
//	public boolean register(User user) {
//		// TODO Auto-generated method stub
//		return userDao.insert(user);
//	}
	public boolean login(String username,String password) {
		return userDao.login(username, password);
	}
	public int selectid(String username) {
		return userDao.selectidByname(username);
	}
	public List<User> findUserById(Integer id){
		return userDao.selectUserById(id);
	}
//	public boolean updateUser(Integer id,String name,String username,String email,String address,String phone,String password) {
//		return userDao.updateUser(id, name, username, email, address, phone, password);
//	}
	public boolean updateUser(Integer id,User user) {
		return userDao.updateUser(user, id);
	}
	public List<Receive> selectReceiveMesage(Integer id){
		return userDao.selectReceiveMessage(id);
	}
	public boolean adminlogin(String adminame,String password) {
		return userDao.adminlogin(adminame, password);
	}
	//管理员添加
		public boolean addAdmin(Admin admin) {
			return userDao.insertAdmin(admin);
		}
}
