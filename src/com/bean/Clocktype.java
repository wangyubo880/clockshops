package com.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="clocktype")
public class Clocktype {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="typeid")
	private Integer typeid;
	@Column(name="typename")
	private String typename;
	@OneToMany(mappedBy="clocktype",targetEntity=Light.class,cascade=CascadeType.ALL)
	private Set<Light> bookSet = new HashSet<Light>();
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public Set<Light> getBookSet() {
		return bookSet;
	}
	public void setBookSet(Set<Light> bookSet) {
		this.bookSet = bookSet;
	}
	
	
}
