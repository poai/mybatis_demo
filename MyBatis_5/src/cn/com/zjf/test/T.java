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
		param.put("name", "鼠");
		
//		/Param param=new Param(100f, 2000f);
		List<Product> products=sqlSession.selectList(statement, param);
		System.out.println(products);
	}
	
	/*Session 级别的缓存
	 * 	1.范围为统一个会话
	 * 	2.clearCache()可以用来清除缓存
	 * 	3.所有的添加、修改、删除操作都会清除缓存
	 * 	4.如果session关闭则缓存失效了
	 * */
	@Test
	public void testSessionCache(){
		String statement="cn.com.zjf.model.ProductMapper.getProducts";
	
		Map<String,Integer> param=new HashMap<>();
		param.put("min", 100);
		param.put("max", 2000);
		
		List<Product> products=sqlSession.selectList(statement, param);
		//sqlSession = sqlsessionFactory.openSession();
		
		//该操作将清除缓存
		sqlSession.delete("cn.com.zjf.model.ProductMapper.delete",1);
		
		/*Session级别的缓存*/
		List<Product> products1=sqlSession.selectList(statement, param);
		
		System.out.println(products);
		System.out.println(products1);
	}
	/*
	 * 映射文件级别的缓存(二级缓存，默认没有开启)
	 * 	1.跨Session缓存
	 * 	2.被缓存的Java对象应该实现Serializable
	 * 	3.只有Session 执行了commit之后才会执行缓存操作 **
	 * 	4.可配置的属性
	 * 		.flushInterval 缓存刷新的时间
	 * 		.readOnly  是否只读
	 * 		.size 缓存的对象的个数(默认为1024)
	 * 	5.缓存策略使用的是LRU(最近最久未使用算法)算法
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

		/*Session级别的缓存*/
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
