package cn.com.zjf.model;

import java.util.List;

/*
 * 1.倒入Jar包
 * 2.创建MyBatis的配置文件
 * 		.配置数据源
 * 		.注册映射文件
 * 3.创建Model对象
 * 4.创建映射文件
 * 		.定义查询语句
 * 
 * 
 * 
 * 
 * */



public class User {
	private Integer id;
	private String name;
	private String sex;
	
	private List<Order> orders;
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", orders=" + orders + "]";
	}
	public User(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}
	
	
}
