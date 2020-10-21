package com.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;     //��������
	@Column(name="uid")
	private Integer uid;    //�û����
	@Column(name="detailid")
	private Integer detailid;    //�������
	@Column(name="lid")
	private Integer lid;  //��Ʒ���
	@Column(name="name")
	private String name;  //��Ʒ����
	@Column(name="num")
	private Integer num;  //��Ʒ����
	@Column(name="price")
	private Double price;  //��Ʒ����
	@Column(name="img")
	private String img;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getDetailid() {
		return detailid;
	}
	public void setDetailid(Integer detailid) {
		this.detailid = detailid;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
//	public OrderDetail getOrdertail() {
//		return ordertail;
//	}
//	public void setOrdertail(OrderDetail ordertail) {
//		this.ordertail = ordertail;
//	}
	
}
