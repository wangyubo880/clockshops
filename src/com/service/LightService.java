package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Cart;
import com.bean.Clocktype;
import com.bean.Light;
import com.bean.Order;
import com.bean.OrderDetail;
import com.bean.Orders;
import com.bean.User;
import com.dao.LightDao;

@Service
@Transactional
public class LightService {
	@Autowired
	private LightDao lightDao;
	public List<Light> findAll(){
		 List<Light> lightlist = lightDao.selectLight();
		 return lightlist;
	 }
	public List<Light> findByid(Integer id){
		List<Light> list=lightDao.selectByid(id);
		return list;
	}
	//������ѯ��Ʒ
	public List<Light> showProductBytype(String name){
		List<Light> list=lightDao.selectLightBytype(name);
		return list;
	}
	
	public boolean addCart(Integer id) {
		boolean flag=lightDao.selectCartByid(id);  //�����Ƿ������ͬid
		return lightDao.selectCartByid(id);
//		if(flag) {                                 //����
//			boolean result1=lightDao.updatenum(id);
//			System.out.println("������");
//			return result1;
//			
//		}else {                                    //��������ͬid����������
//			boolean result2=lightDao.addCart(cart);
//			System.out.println("���");
//			return result2;
//			
//		}
	}
	//���ﳵ������ͬid��������
	public boolean addQty(Integer id) {
		return lightDao.updatenum(id);
	}
	//���ﳵ��������ͬid
	
	public boolean addCarts(Cart cart) {
		return lightDao.addCart(cart);
	}
	public List<Cart> selectCart(Integer uid){
		List<Cart> list=lightDao.selectCart(uid);
		return list;
	}
	//ɾ��ĳ��ﳵ
	public boolean deleteCartByid(Integer id) {
		return lightDao.deleteCartByid(id);
	}
	//��չ��ﳵ
	public boolean deleteCart(Cart cart) {
		return lightDao.deleteCart(cart);
	}
	//���ﳵ��������
	public boolean addCartNum(Integer id) {
		return lightDao.updateCartnum(id);
	}
	//���ﳵ��������
	public boolean reduceCartNum(Integer id) {
		return lightDao.reduceCartnum(id);
	}
	//���ﳵ�ܼ۸�
	public double sumCart(Cart cart,Integer uid) {
		return lightDao.sumCart(cart,uid);
	}
	//���붩������
	public int insertOrderDetail(OrderDetail detail) {
		return lightDao.insertOrderDetail(detail);
	}
	//��ʾ������ϸ��Ϣ
	public List<OrderDetail> showOrder(Integer id){
		return lightDao.showOrder(id);
	}
	public List<OrderDetail> showOrders(Integer id){
		return lightDao.showOrders(id);
	}
	//order
	public List<Order> userShowOrder(Integer id){
		return lightDao.usershoworder(id);
	}
	//���붩����Ϣ
	public boolean insertOrderMsg(Integer uid,Integer detailid) {
		return lightDao.insertOrderMsg(uid,detailid);
	}
	//ɾ������
	public boolean cancelOrder(Integer id) {
		return lightDao.cancelOrder(id);
	}
}
