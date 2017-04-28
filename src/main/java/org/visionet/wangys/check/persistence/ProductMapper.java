package org.visionet.wangys.check.persistence;

import java.util.List;
import java.util.Map;

import org.visionet.wangys.check.domain.Product;
/***********************
 * 
 * @author 王永圣
 *
 */
public interface ProductMapper {
	
	//添加产品
	public void insertProduct(Product product);
	//查询全部产品
	public List<Product> findProductAll();
	//查询总条数
	public int getProductTotal();
	//分页查询产品
	public List<Product> findAllByPage(Map<String, Object> params);
	//根据Id查询对应产品信息
	public Product findProductById(Integer pid);
	//修改产品数据
	public void updateProduct(Product product);
	//根据产品id删除产品信息
	public void deleteProductById(Integer pid);
}
