package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Admin;
import com.bean.Light;
import com.bean.Receive;
import com.bean.User;

@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	public List<User> select(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		return list;
	}
	//获取用户名
//	public boolean insert(User user,String imgurl) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		user.setImg(imgurl);
//		session.save(user);
//		return true;
//	}
	public boolean insert(User user,String imgURL) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		user.setImg(imgURL);
		session.save(user);
		return true;
	}
	//根据用户名查找id
	public int selectidByname(String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select u.id from User u where u.username=? ");
		List list=query.setString(0, username).list();
		int id=(int)list.get(0);
		return id;
	}
	public boolean login(String username,String password) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User u where u.username=? and u.password=?");
	    List<User>lists = query.setString(0, username).setString(1, password).list();
		//query.setParameter(0, username);
		//query.setParameter(1, password);
		//User user = (User)query.uniqueResult();
		if(lists.size()>0) {
			return true;
		}else {
			return false;
		}
			}
	public List<User> selectById(Integer id){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where id=?");
		query.setParameter(0, id);
		List<User> lists=query.list();
		return lists;
	}
	//修改用户信息
//	public boolean updateUser(Integer id,String name,String username,String email,String address,String phone,String password,String imgurl) {
//		Session session=sessionFactory.getCurrentSession();
//		Query query=session.createQuery("update User u set u.name=?,u.username=?,u.email=?,u.address=?,u.phone=?,u.password=?,u.img=? where u.id=?");
//		int result=query.setParameter(0, name).setParameter(1, username).setParameter(2, email).setParameter(3, address).setParameter(4, phone).setParameter(5, password).setParameter(6, imgurl).setParameter(7,id).executeUpdate();
//		if(result>0) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	public boolean updateUser(User user,Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update User u set u.name=?,u.username=?,u.email=?,u.address=?,u.phone=?,u.password=?,u.img=? where u.id=?");
		query.setParameter(0, user.getName());
		query.setParameter(1, user.getUsername());
		query.setParameter(2, user.getEmail());
		query.setParameter(3, user.getAddress());
		query.setParameter(4, user.getPhone());
		query.setParameter(5, user.getPassword());
		query.setParameter(6, user.getImg());
		query.setParameter(7, id);
		int result=query.executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//查找用户信息
	public List<User> selectUserById(Integer id){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User u where id=?");
		query.setParameter(0, id);
		List<User> list=query.list();
		return list;
	}
	//查找收货信息
	public List<Receive> selectReceiveMessage(Integer id){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Receive r where uid=?");
		query.setParameter(0, id);
		List<Receive> list=query.list();
		return list;
	}
	public boolean adminlogin(String adminame,String password) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Admin a where a.adminame=? and a.password=?");
	    List<Admin>lists = query.setString(0, adminame).setString(1, password).list();
		if(lists.size()>0) {
			return true;
		}else {
			return false;
		}
			}
	//管理员添加
		public boolean insertAdmin(Admin admin) {
			Session session=sessionFactory.getCurrentSession();
			session.save(admin);
			return true;
		}
}
