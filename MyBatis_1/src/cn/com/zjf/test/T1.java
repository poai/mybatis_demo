package cn.com.zjf.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.com.zjf.model.User;

public class T1 {

	public static void main(String[] args) {

		/*1.加载配置文件*/
		InputStream inputStream= T1.class.getClassLoader().getResourceAsStream("mybatis_config.xml");
		/*2.创建SQLSessionFactory*/
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		/*3.获取SqlSesison 会话对象*/
		SqlSession session=sqlSessionFactory.openSession();
		
		/*4.定义statement对象*/
		String statement="cn.com.zjf.model.UserMapper.get";
		/*5.查询一个User对象(id为1)*/
		User user=session.selectOne(statement, 1);
		System.out.println(user);
		/*6.提交事务*/
		session.commit();
		/*7.关闭SqlSesison*/
		session.close();
		
	}
}
