package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Clocktype;
import com.bean.Light;
import com.bean.Order;
import com.bean.OrderDetail;
import com.bean.Orders;
import com.bean.User;

@Repository
public class ClockDao {
	@Autowired
	private SessionFactory sessionFactory;
	public List<Light> selectLight(){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Light");
		List<Light> lightlist=query.list();
		return lightlist;
	}
	//显示商品信息列表
	public List<Light> selectLightMessage(){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Light");
		List<Light> list=query.list();
		return list;
	}
	//删除某项物品
	public boolean deleteByid(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Light where id=?");
		int result=query.setParameter(0, id).executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//模糊查询
	public List<Light> fuzzyLight(String name){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Light l where l.name like ?");
		query.setParameter(0, "%"+name+"%");
		List<Light> list=query.list();
		return list;
	}
	
	//根据类别查商品
	public List<Light> selectByname(String name){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Light l where l.clocktype.typename like ?");
		query.setParameter(0, "%"+name+"%");
		List<Light> list=query.list();
		return list;
	}
	//添加类别
		public boolean addClockType(Clocktype clockType) {
			Session session = sessionFactory.getCurrentSession();
			try {
				session.save(clockType);
				return true;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	//查询订单
	public List<OrderDetail> selectOrder(){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from OrderDetail");
		List<OrderDetail> order=query.list();
		return order;
	}
	//根据用户id查订单
	public List<OrderDetail> selectOrderByid(Integer uid){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from OrderDetail o where uid=?");
		List<OrderDetail> order=query.setParameter(0, uid).list();
		return order;
	}
	//确认订单
	public boolean adminconfirmorder(Integer id) {
		String ad="已确认";
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("update OrderDetail o set o.status=? where id=?");
		query.setParameter(0, ad);
		query.setParameter(1, id);
		int result=query.executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//查询类别
	public List<Clocktype> showType(){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Clocktype");
		List<Clocktype> clocktype=query.list();
		return clocktype;
	}
	//添加商品
	public boolean addClock(Light light) {
		Session session = sessionFactory.getCurrentSession();
		session.save(light);
		return true;
	}
	//根据id查找商品信息
	public List<Light> showUpdateLight(Integer id){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Light where id=?");
		query.setParameter(0, id);
		List<Light> list=query.list();
		return list;
	}
	//修改商品信息
	public boolean adminupdateclock(Light light,Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Light l set l.name=?,l.price=?,l.img=?,l.clocktype=? where id=?");
		query.setParameter(0, light.getName());
		query.setParameter(1, light.getPrice());
		query.setParameter(2, light.getImg());
		query.setParameter(3, light.getClocktype());
		query.setParameter(4, id);
		int result=query.executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//显示订单详情
	public List<Orders> usershoworder(Integer detailid){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Orders o where o.detailid=?");
		List<Orders> list=query.setParameter(0, detailid).list();
		return list;
	}
	//显示用户信息
	public List<User> adminShowUser(){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User");
		List<User> list=query.list();
		return list;
	}
	//用户名搜索
	public List<User> adminShowUserbyUsername(String usernamae){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where username=?");
		List<User> list=query.setParameter(0, usernamae).list();
		return list;
	}
	//姓名搜索
	public List<User> adminShowUserbyname(String name){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where name=?");
		List<User> list=query.setParameter(0, name).list();
		return list;
	}
	//删除用户
	public boolean admindeleteuser(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from User where id=?");
		int result=query.setParameter(0, id).executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//批量删除用户
	public boolean admindeleteuserbatch(Integer[] ids) {
		Session session=sessionFactory.getCurrentSession();
		for(int i=0;i<ids.length;i++) {
			Query query=session.createQuery("delete from User u where u.id=?");
			int result=query.setParameter(0, ids[i]).executeUpdate();
			System.out.println(ids[i]);
		}
		return true;
	}
}
