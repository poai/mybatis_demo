package cn.com.zjf.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class T1 {

	
	/*Ŀ�귽��֮ǰִ��*/
	@Before
	public  void init(){
		System.out.println("init");
		
	}
	
	/*junit��Ԫ����*/
	@Test
	public void test(){
		System.out.println("Hello World!!");
	}
	/*Ŀ�귽��֮��ִ��*/
	@After
	public void destory(){
		System.out.println("destory");
	}
	
	
}
