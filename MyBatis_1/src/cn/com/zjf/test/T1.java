package cn.com.zjf.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.com.zjf.model.User;

public class T1 {

	public static void main(String[] args) {

		/*1.���������ļ�*/
		InputStream inputStream= T1.class.getClassLoader().getResourceAsStream("mybatis_config.xml");
		/*2.����SQLSessionFactory*/
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		/*3.��ȡSqlSesison �Ự����*/
		SqlSession session=sqlSessionFactory.openSession();
		
		/*4.����statement����*/
		String statement="cn.com.zjf.model.UserMapper.get";
		/*5.��ѯһ��User����(idΪ1)*/
		User user=session.selectOne(statement, 1);
		System.out.println(user);
		/*6.�ύ����*/
		session.commit();
		/*7.�ر�SqlSesison*/
		session.close();
		
	}
}
