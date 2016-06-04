package cn.com.zjf.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.com.zjf.model.User;

public class T2 {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	@Before
	public void init() {
		InputStream inputStream = T2.class.getClassLoader().getResourceAsStream("mybatis_config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}
	/*5.删除操作*/
	@Test
	public void testDelete(){
		session.delete("cn.com.zjf.model.UserMapper.delete",1);
	}
	
	/*4.更新操作*/
	@Test
	public void testUpdate(){
		User user=new User(1, "奋斗的小青年", "男");
		session.update("cn.com.zjf.model.UserMapper.update",user);
	}
	
	
	/*3.添加操作*/
	@Test
	public void testSave(){
		User user=new User("张化龙", "男");
		session.insert("cn.com.zjf.model.UserMapper.save",user);
		
	}
	/*2.查询一个对象*/
	@Test
	public void testQueryAll(){
		List<User> list= session.selectList("cn.com.zjf.model.UserMapper.getAll");
		System.out.println(list);
	}
	
	
	/*1.查询一个对象*/
	@Test
	public void testQueryOne() {
		User user = session.selectOne("cn.com.zjf.model.UserMapper.get", 1);
		System.out.println(user);
	}
	@After
	public void destory() {
		session.commit();
		session.close();
	}

}
