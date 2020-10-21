package com.bean;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="orderdetail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;    //�������
	@Column(name="name")
	private String name;   //�û�����
	@Column(name="uid")
	private Integer uid;  //�û����
	@Column(name="sum")
	private Double sum;   //�ܼ�
	@Column(name="post")
	private String post;    //�ʱ�
	@Column(name="phone")
	private String phone;   //�绰
	@Column(name="address")
	private String address;  //��ַ
	@Column(name="date")
	private String date;     //�µ�����
	@Column(name="status")
	private String status;  //����״̬
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public Order getOrder() {
//		return order;
//	}
//	public void setOrder(Order order) {
//		this.order = order;
//	}
	
	
	
	
	
	
	
}
