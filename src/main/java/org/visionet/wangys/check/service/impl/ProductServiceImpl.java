package org.visionet.wangys.check.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.visionet.wangys.check.bean.PageBean;
import org.visionet.wangys.check.domain.Product;
import org.visionet.wangys.check.persistence.ProductMapper;
import org.visionet.wangys.check.persistence.TypeMapper;
import org.visionet.wangys.check.service.ProductService;
/**************************
 * 
 * @author 王永圣
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductMapper productMapper;
	@Resource
	private TypeMapper typeMapper;
	
	//查询全部产品
	@Override
	public List<Product> listProductAll() {
		// TODO Auto-generated method stub
		return productMapper.findProductAll();
	}
	
	//添加产品
	@Override
	public void addProduct(Product product) {
		
		productMapper.insertProduct(product);
	}

	//修改产品数据
	@Override
	public void modifyProduct(Product product) {
		productMapper.updateProduct(product);
	}
	//根据产品id删除产品信息
	@Override
	public void deleteProduct(Integer pid) {
		productMapper.deleteProductById(pid);
	}
	//根据Id查询对应产品信息
	@Override
	public Product listProductById(Integer pid) {
		return productMapper.findProductById(pid);
	}

	//查询总条数
	@Override
	public int getProductTotal() {
		return productMapper.getProductTotal();
	}
	//分页
	@Override
	public PageBean<Product> getAllProductsByPage(int pageNo) {
		Map<String, Object> params = new HashMap<String,Object>();
		
		PageBean<Product> page = new PageBean<Product>(pageNo, 5);
		params.put("page", page);
		
		// 查询总记录数
		long totalItems = productMapper.getProductTotal();
		// 设置到pageBean对象中
		page.setTotalItems(totalItems);
		
		// 查询对应记录
		List<Product>  list = this.productMapper.findAllByPage(params);
		page.setResult(list);
		return page;
	}




}
