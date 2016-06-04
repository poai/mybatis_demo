package cn.com.zjf.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {

	private static SqlSessionFactory sqlSessionFactory;
	public static SqlSession getSqlSession(){
		if(sqlSessionFactory==null){
			InputStream inputStream=null;
			try {
				inputStream = Resources.getResourceAsStream("config.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		}
		return sqlSessionFactory.openSession();
	}
	
}
