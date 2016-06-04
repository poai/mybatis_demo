package cn.com.zjf.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.com.zjf.model.User;
import cn.com.zjf.model1.UserMapper;

public class T3 {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;

	@Before
	public void init() {
		InputStream inputStream = T2.class.getClassLoader().getResourceAsStream("mybatis_config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}
	@Test
	public void testAdd(){
		/*��ȡ�ӿڱ���*/
		UserMapper userMapper=session.getMapper(UserMapper.class);
		/*ִ�б������*/
		User user=new User("�Ž��", "��");
		userMapper.save(user);
	}
	@After
	public void destory() {
		session.commit();
		session.close();
	}

}
