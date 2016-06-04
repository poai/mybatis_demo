package cn.com.zjf.service;

import org.apache.ibatis.session.SqlSession;

import cn.com.zjf.model.Product;
import cn.com.zjf.util.MyBatisUtils;

public class ProductService {
	private SqlSession selSesion = MyBatisUtils.getSqlSession();

	public void add(Product product) {
		/* ��Ӳ��� */
		try {
			selSesion.insert("cn.com.zjf.model.ProductMapper.save", product);
			selSesion.commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			selSesion.close();
		}
	}
}
