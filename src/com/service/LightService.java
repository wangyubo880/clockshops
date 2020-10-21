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
	//按类别查询商品
	public List<Light> showProductBytype(String name){
		List<Light> list=lightDao.selectLightBytype(name);
		return list;
	}
	
	public boolean addCart(Integer id) {
		boolean flag=lightDao.selectCartByid(id);  //查找是否存在相同id
		return lightDao.selectCartByid(id);
//		if(flag) {                                 //存在
//			boolean result1=lightDao.updatenum(id);
//			System.out.println("改数量");
//			return result1;
//			
//		}else {                                    //不存在相同id，插入数据
//			boolean result2=lightDao.addCart(cart);
//			System.out.println("添加");
//			return result2;
//			
//		}
	}
	//购物车存在相同id增加数量
	public boolean addQty(Integer id) {
		return lightDao.updatenum(id);
	}
	//购物车不存在相同id
	
	public boolean addCarts(Cart cart) {
		return lightDao.addCart(cart);
	}
	public List<Cart> selectCart(Integer uid){
		List<Cart> list=lightDao.selectCart(uid);
		return list;
	}
	//删除某项购物车
	public boolean deleteCartByid(Integer id) {
		return lightDao.deleteCartByid(id);
	}
	//清空购物车
	public boolean deleteCart(Cart cart) {
		return lightDao.deleteCart(cart);
	}
	//购物车增加数量
	public boolean addCartNum(Integer id) {
		return lightDao.updateCartnum(id);
	}
	//购物车减少数量
	public boolean reduceCartNum(Integer id) {
		return lightDao.reduceCartnum(id);
	}
	//购物车总价格
	public double sumCart(Cart cart,Integer uid) {
		return lightDao.sumCart(cart,uid);
	}
	//插入订单详情
	public int insertOrderDetail(OrderDetail detail) {
		return lightDao.insertOrderDetail(detail);
	}
	//显示订单详细信息
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
	//插入订单信息
	public boolean insertOrderMsg(Integer uid,Integer detailid) {
		return lightDao.insertOrderMsg(uid,detailid);
	}
	//删除订单
	public boolean cancelOrder(Integer id) {
		return lightDao.cancelOrder(id);
	}
}
