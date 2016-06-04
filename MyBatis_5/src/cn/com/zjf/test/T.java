package cn.com.zjf.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.com.zjf.model.Product;

public class T {

	
	private SqlSessionFactory sqlsessionFactory;
	private SqlSession sqlSession;

	@Before
	public void init() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("config.xml");
		sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlsessionFactory.openSession();
	}
	
	@Test
	public void testQueryOne(){
		String statement="cn.com.zjf.model.ProductMapper.getProducts";
	
		Map<String,Integer> param=new HashMap<>();
		param.put("min", 100);
		param.put("max", 2000);
		
//		/Param param=new Param(100f, 2000f);
		List<Product> products=sqlSession.selectList(statement, param);
		
		System.out.println(products);
	}
	@Test
	public void testQueryOneLike(){
		String statement="cn.com.zjf.model.ProductMapper.getProductsLike";
	
		Map<String,String> param=new HashMap<>();
		param.put("name", "��");
		
//		/Param param=new Param(100f, 2000f);
		List<Product> products=sqlSession.selectList(statement, param);
		System.out.println(products);
	}
	
	/*Session ����Ļ���
	 * 	1.��ΧΪͳһ���Ự
	 * 	2.clearCache()���������������
	 * 	3.���е���ӡ��޸ġ�ɾ�����������������
	 * 	4.���session�ر��򻺴�ʧЧ��
	 * */
	@Test
	public void testSessionCache(){
		String statement="cn.com.zjf.model.ProductMapper.getProducts";
	
		Map<String,Integer> param=new HashMap<>();
		param.put("min", 100);
		param.put("max", 2000);
		
		List<Product> products=sqlSession.selectList(statement, param);
		//sqlSession = sqlsessionFactory.openSession();
		
		//�ò������������
		sqlSession.delete("cn.com.zjf.model.ProductMapper.delete",1);
		
		/*Session����Ļ���*/
		List<Product> products1=sqlSession.selectList(statement, param);
		
		System.out.println(products);
		System.out.println(products1);
	}
	/*
	 * ӳ���ļ�����Ļ���(�������棬Ĭ��û�п���)
	 * 	1.��Session����
	 * 	2.�������Java����Ӧ��ʵ��Serializable
	 * 	3.ֻ��Session ִ����commit֮��Ż�ִ�л������ **
	 * 	4.�����õ�����
	 * 		.flushInterval ����ˢ�µ�ʱ��
	 * 		.readOnly  �Ƿ�ֻ��
	 * 		.size ����Ķ���ĸ���(Ĭ��Ϊ1024)
	 * 	5.�������ʹ�õ���LRU(������δʹ���㷨)�㷨
	 * */
	@Test
	public void testSessionSecondCache(){
		String statement="cn.com.zjf.model.ProductMapper.getProducts";
	
		Map<String,Integer> param=new HashMap<>();
		param.put("min", 100);
		param.put("max", 2000);
		
		List<Product> products=sqlSession.selectList(statement, param);
		sqlSession.commit();
		sqlSession = sqlsessionFactory.openSession();

		/*Session����Ļ���*/
		List<Product> products1=sqlSession.selectList(statement, param);
		
		System.out.println(products);
		System.out.println(products1);
	}
	
	
	
	
	
	@After
	public void destory() {
		sqlSession.commit();
		sqlSession.close();

	}
}
