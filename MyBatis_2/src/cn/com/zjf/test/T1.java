package cn.com.zjf.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class T1 {

	
	/*目标方法之前执行*/
	@Before
	public  void init(){
		System.out.println("init");
		
	}
	
	/*junit单元测试*/
	@Test
	public void test(){
		System.out.println("Hello World!!");
	}
	/*目标方法之后执行*/
	@After
	public void destory(){
		System.out.println("destory");
	}
	
	
}
