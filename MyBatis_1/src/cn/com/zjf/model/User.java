package cn.com.zjf.model;


/*
 * 1.����Jar��
 * 2.����MyBatis�������ļ�
 * 		.��������Դ
 * 		.ע��ӳ���ļ�
 * 3.����Model����
 * 4.����ӳ���ļ�
 * 		.�����ѯ���
 * 
 * 
 * 
 * 
 * */



public class User {
	private Integer id;
	private String name;
	private String sex;
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
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}
	
}
