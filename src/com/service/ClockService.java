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
	
	//��ʾ��Ʒ�б�
	public List<Light> findClock(){
		List<Light> list=clockDao.selectLightMessage();
		return list;
	}
	//ɾ��ĳ����Ʒ
	public boolean admindelete(Integer id) {
		return clockDao.deleteByid(id);
	}
	//ģ����ѯ
	public List<Light> fuzzyClock(String name){
		List<Light> list=clockDao.fuzzyLight(name);
		return list;
	}
	
	//�������id����Ʒ
	public List<Light> selectByTypename(String name){
		return clockDao.selectByname(name);
	}
	//������
	public boolean addClockType(Clocktype clocktype) {
		return clockDao.addClockType(clocktype);
	}
	//��ѯ����
	public List<OrderDetail> showOrder(){
		return clockDao.selectOrder();
	}
	//�����û�id�鶩��
	public List<OrderDetail> showOrderByid(Integer uid){
		return clockDao.selectOrderByid(uid);
	}
	//ȷ�϶���
	public boolean adminConfirmOrder(Integer id) {
		return clockDao.adminconfirmorder(id);
	}
	//��ѯ���
	public List<Clocktype> showType(){
		return clockDao.showType();
	}
	//�����Ʒ
	public boolean addClock(Light light) {
		return clockDao.addClock(light);
	}
	//����id������Ʒ��Ϣ
	public List<Light> showUpdateLight(Integer id){
		return clockDao.showUpdateLight(id);
	}
	//�޸���Ʒ��Ϣ
	public boolean adminUpdateClock(Light light,Integer id) {
		return clockDao.adminupdateclock(light, id);
	}
	//order
		public List<Orders> userShowOrder(Integer id){
			return clockDao.usershoworder(id);
		}
	//��ʾ�û���Ϣ
	public List<User> adminShowUser(){
		return clockDao.adminShowUser();
	}
	//�û�������
	public List<User> adminShowUserbyusername(String username){
		return clockDao.adminShowUserbyUsername(username);
	}
	//��������
	public List<User> adminShowUserbyname(String name){
		return clockDao.adminShowUserbyname(name);
	}
	//ɾ���û�
	public boolean adminDeleteUser(Integer id) {
		return clockDao.admindeleteuser(id);
	}
	//����ɾ���û�
	public boolean adminDeleteUserbatch(Integer[] ids) {
		return clockDao.admindeleteuserbatch(ids);
	}
		
}

	
