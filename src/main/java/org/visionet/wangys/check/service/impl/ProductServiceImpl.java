package org.visionet.wangys.check.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.visionet.wangys.check.domain.Page;
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
	public List<Product> listProductAll(Page page) {
		// TODO Auto-generated method stub
		return productMapper.findProductAll(page);
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
	//分页
/*	@Override
	public PageInfo<Product> queryPageList(Map<String, Object> map) {
		PageHelper.startPage((Integer) map.get("pageNum"), WebConstant.PAGESIZE);
		List<Product> list = productMapper.findProductAll();
		// 用PageInfo对结果进行包装
		PageInfo<Product> pageInfo = new PageInfo<Product>(list);
		return pageInfo;
	}*/
	//查询总条数
	@Override
	public int getProductTotal() {
		return productMapper.getProductTotal();
	}




}
