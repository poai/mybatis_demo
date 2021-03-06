package cn.com.zjf.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.com.zjf.model2.User;

public class T2 {
	private SqlSessionFactory sqlsessionFactory;
	private SqlSession sqlSession;

	@Before
	public void init() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("config.xml");
		sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlsessionFactory.openSession();
	}

	@Test
	public void testGet() {
		String statement="cn.com.zjf.model2.UserMapper.get";
		User user=sqlSession.selectOne(statement,2);
		System.out.println(user);

	}
	@Test
	public void testAll() {
		String statement="cn.com.zjf.model2.UserMapper.getAll";
		List<User> list=sqlSession.selectList(statement);
		System.out.println(list);
	}

	@After
	public void destory() {
		sqlSession.commit();
		sqlSession.close();

	}

}
