package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Cart;
import com.bean.Clocktype;
import com.bean.Light;
import com.bean.Order;
import com.bean.OrderDetail;
import com.bean.Orders;
import com.bean.User;

@Repository
public final class LightDao {
	@Autowired
	private SessionFactory sessionFactory;
	public List<Light> selectLight(){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Light");
		List<Light> lightlist=query.list();
		return lightlist;
	}
	//������ѯ
	public List<Light> selectLightBytype(String name){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Light l where l.clocktype.typename like ?");
		List<Light> lightlist=query.setParameter(0, "%"+name+"%").list();
		return lightlist;
	}
	public List<Light> selectByid(Integer id){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Light where id=?");
		List<Light>lists = query.setInteger(0, id).list();
		return lists;
	}
	
	//��ʾ���ﳵ
	public List<Cart> selectCart(Integer uid) {
		//Integer id=Integer.parseInt(uid);
		//System.out.println(id);
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Cart c where uid=?");
		List<Cart> list=query.setParameter(0, uid).list();
		return list;
	}
	//���ﳵ���Ƿ������ͬid
	public boolean selectCartByid(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Cart c where c.lightid=?");
		List<Cart>list=query.setParameter(0, id).list();
		if(list.size()>0) {
			return true;
		}else {
			return false;
		}
	}
	//���ﳵ�д�����ͬid
	public boolean updatenum(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Cart set num=num+1,count=count+price where lightid=?");
		int result=query.setParameter(0, id).executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//��������ͬid
	public boolean addCart(Cart cart) {
		Session session=sessionFactory.getCurrentSession();
		session.save(cart);
		return true;
		
	}
	//��չ��ﳵ
	public boolean deleteCart(Cart cart) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Cart");
		int result=query.executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//ɾ��ĳ����Ʒ
	public boolean deleteCartByid(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Cart where id=?");
		int result=query.setParameter(0, id).executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//���ӹ��ﳵ��Ʒ����
	public boolean updateCartnum(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Cart c set c.num=c.num+1,c.count=c.price+c.count where c.id=? ");
		int result=query.setParameter(0, id).executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//���ٹ��ﳵ��Ʒ����
	public boolean reduceCartnum(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Cart c set c.num=c.num-1,c.count=c.count-c.price where c.id=? ");
		int result=query.setParameter(0, id).executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//���ﳵ�ܼ�
	public double sumCart(Cart cart,Integer uid) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select sum(c.count) from Cart c where uid=?");
		query.setParameter(0, uid);
		Object counts=query.uniqueResult();
		Double count=Double.parseDouble(counts.toString());
		return count;
	}
	//���붩������
	public int insertOrderDetail(OrderDetail detail) {
		Session session=sessionFactory.getCurrentSession();
		session.save(detail);
		int b=detail.getId();
		//System.out.println(b);
		return b;
	}
	//��ʾ������ϸ��Ϣ
	public List<OrderDetail> showOrder(Integer id){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from OrderDetail order where uid=?");
		List<OrderDetail> list=query.setParameter(0, id).list();
		return list;
	}
	public List<OrderDetail> showOrders(Integer id){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from OrderDetail order where id=?");
		List<OrderDetail> list=query.setParameter(0, id).list();
		return list;
	}
	//ǰ̨��ʾ��������
	public List<Order> usershoworder(Integer detailid){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Order o where o.detailid=?");
		List<Order> list=query.setParameter(0, detailid).list();
		return list;
	}
	//���붩����Ϣ
	public boolean insertOrderMsg(Integer uid,Integer detailid) {
		Session session=sessionFactory.getCurrentSession();
		List<Cart> cart=selectCart(uid);
		System.out.println(cart.size());
		for(int i=0;i<cart.size();i++) {
			
			Cart c=cart.get(i);
			String name=c.getName();
			Double price=c.getPrice();
			Integer num=c.getNum();
			Integer lid=c.getLightid();
			String img=c.getImg();
			Orders orders=new Orders();
			orders.setDetailid(detailid);
			orders.setUid(uid);
			orders.setLid(lid);
			orders.setName(name);
			orders.setNum(num);
			orders.setPrice(price);
			orders.setImg(img);
			//session.delete(c);
			session.save(orders);
		}
		return true;
	}
	//ɾ������
	public boolean cancelOrder(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from OrderDetail o where o.id=?");
		int result=query.setParameter(0, id).executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	
}
