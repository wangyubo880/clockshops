package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Clocktype;
import com.bean.Light;
import com.bean.Order;
import com.bean.OrderDetail;
import com.bean.Orders;
import com.bean.User;
import com.dao.ClockDao;

@Service
@Transactional
public class ClockService {
	@Autowired
	private ClockDao clockDao;
	
	//显示商品列表
	public List<Light> findClock(){
		List<Light> list=clockDao.selectLightMessage();
		return list;
	}
	//删除某项商品
	public boolean admindelete(Integer id) {
		return clockDao.deleteByid(id);
	}
	//模糊查询
	public List<Light> fuzzyClock(String name){
		List<Light> list=clockDao.fuzzyLight(name);
		return list;
	}
	
	//根据类别id查商品
	public List<Light> selectByTypename(String name){
		return clockDao.selectByname(name);
	}
	//添加类别
	public boolean addClockType(Clocktype clocktype) {
		return clockDao.addClockType(clocktype);
	}
	//查询订单
	public List<OrderDetail> showOrder(){
		return clockDao.selectOrder();
	}
	//根据用户id查订单
	public List<OrderDetail> showOrderByid(Integer uid){
		return clockDao.selectOrderByid(uid);
	}
	//确认订单
	public boolean adminConfirmOrder(Integer id) {
		return clockDao.adminconfirmorder(id);
	}
	//查询类别
	public List<Clocktype> showType(){
		return clockDao.showType();
	}
	//添加商品
	public boolean addClock(Light light) {
		return clockDao.addClock(light);
	}
	//根据id查找商品信息
	public List<Light> showUpdateLight(Integer id){
		return clockDao.showUpdateLight(id);
	}
	//修改商品信息
	public boolean adminUpdateClock(Light light,Integer id) {
		return clockDao.adminupdateclock(light, id);
	}
	//order
		public List<Orders> userShowOrder(Integer id){
			return clockDao.usershoworder(id);
		}
	//显示用户信息
	public List<User> adminShowUser(){
		return clockDao.adminShowUser();
	}
	//用户名搜索
	public List<User> adminShowUserbyusername(String username){
		return clockDao.adminShowUserbyUsername(username);
	}
	//姓名搜索
	public List<User> adminShowUserbyname(String name){
		return clockDao.adminShowUserbyname(name);
	}
	//删除用户
	public boolean adminDeleteUser(Integer id) {
		return clockDao.admindeleteuser(id);
	}
	//批量删除用户
	public boolean adminDeleteUserbatch(Integer[] ids) {
		return clockDao.admindeleteuserbatch(ids);
	}
		
}

	
