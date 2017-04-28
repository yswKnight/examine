package org.visionet.wangys.check.service;

import java.util.List;

import org.visionet.wangys.check.bean.PageBean;
import org.visionet.wangys.check.domain.Product;

/***********************
 * 
 * @author 王永圣
 *
 */
public interface ProductService {

		//添加产品
		public void addProduct(Product product);
		//查询全部产品
		public List<Product> listProductAll();
		//查询总条数
		public int getProductTotal();
		//分页
		public PageBean<Product>  getAllProductsByPage(int pageNo);
		//根据Id查询对应产品信息
		public Product listProductById(Integer pid);
		//修改产品数据
		public void modifyProduct(Product product);
		//根据产品id删除产品信息
		public void deleteProduct(Integer pid);
}
