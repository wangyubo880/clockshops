package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Admin;
import com.bean.User;

@Repository
public class AdminDao {
	@Autowired
	private SessionFactory sessionFactory;
	//查看用户列表
	public List<User> select(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		return list;
	}
	//删除某个用户
	public boolean deleteByid(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from User where id=?");
		int result=query.setParameter(0, id).executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	
}
