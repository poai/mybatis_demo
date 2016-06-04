package cn.com.zjf.test1;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.com.zjf.model.Order;
import cn.com.zjf.model.User;

public class T1 {

	private SqlSessionFactory sqlsessionFactory;
	private SqlSession sqlSession;

	@Before
	public void init() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("config.xml");
		sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlsessionFactory.openSession();
	}
	
	@Test
	public void testQueryOne1(){
		Order order=sqlSession.selectOne("cn.com.zjf.model.OrderMapper.get",1);
		System.out.println(order);
		
	}
	@Test
	public void testQueryOne2(){
		Order order=sqlSession.selectOne("cn.com.zjf.model.OrderMapper.getOrder",1);
		System.out.println(order);
		
	}
	
	@Test
	public void testQueryOne3(){
		User user=sqlSession.selectOne("cn.com.zjf.model.OrderMapper.getUser1",2);
		System.out.println(user);
		
	}
	@Test
	public void testQueryOne4(){
		User user=sqlSession.selectOne("cn.com.zjf.model.OrderMapper.getUser2",2);
		System.out.println(user);
		
	}
	
	@After
	public void destory() {
		sqlSession.commit();
		sqlSession.close();

	}
}
