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
	public List<Product> listProductAll(Page page) {
		// TODO Auto-generated method stub
		return productMapper.findProductAll(page);
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
	//��ҳ
/*	@Override
	public PageInfo<Product> queryPageList(Map<String, Object> map) {
		PageHelper.startPage((Integer) map.get("pageNum"), WebConstant.PAGESIZE);
		List<Product> list = productMapper.findProductAll();
		// ��PageInfo�Խ�����а�װ
		PageInfo<Product> pageInfo = new PageInfo<Product>(list);
		return pageInfo;
	}*/
	//��ѯ������
	@Override
	public int getProductTotal() {
		return productMapper.getProductTotal();
	}




}
