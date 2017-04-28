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
 * @author ����ʥ
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductMapper productMapper;
	@Resource
	private TypeMapper typeMapper;
	
	//��ѯȫ����Ʒ
	@Override
	public List<Product> listProductAll() {
		// TODO Auto-generated method stub
		return productMapper.findProductAll();
	}
	
	//��Ӳ�Ʒ
	@Override
	public void addProduct(Product product) {
		
		productMapper.insertProduct(product);
	}

	//�޸Ĳ�Ʒ����
	@Override
	public void modifyProduct(Product product) {
		productMapper.updateProduct(product);
	}
	//���ݲ�Ʒidɾ����Ʒ��Ϣ
	@Override
	public void deleteProduct(Integer pid) {
		productMapper.deleteProductById(pid);
	}
	//����Id��ѯ��Ӧ��Ʒ��Ϣ
	@Override
	public Product listProductById(Integer pid) {
		return productMapper.findProductById(pid);
	}

	//��ѯ������
	@Override
	public int getProductTotal() {
		return productMapper.getProductTotal();
	}
	//��ҳ
	@Override
	public PageBean<Product> getAllProductsByPage(int pageNo) {
		Map<String, Object> params = new HashMap<String,Object>();
		
		PageBean<Product> page = new PageBean<Product>(pageNo, 5);
		params.put("page", page);
		
		// ��ѯ�ܼ�¼��
		long totalItems = productMapper.getProductTotal();
		// ���õ�pageBean������
		page.setTotalItems(totalItems);
		
		// ��ѯ��Ӧ��¼
		List<Product>  list = this.productMapper.findAllByPage(params);
		page.setResult(list);
		return page;
	}




}
