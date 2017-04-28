package org.visionet.wangys.check.service;

import java.util.List;

import org.visionet.wangys.check.bean.PageBean;
import org.visionet.wangys.check.domain.Product;

/***********************
 * 
 * @author ����ʥ
 *
 */
public interface ProductService {

		//��Ӳ�Ʒ
		public void addProduct(Product product);
		//��ѯȫ����Ʒ
		public List<Product> listProductAll();
		//��ѯ������
		public int getProductTotal();
		//��ҳ
		public PageBean<Product>  getAllProductsByPage(int pageNo);
		//����Id��ѯ��Ӧ��Ʒ��Ϣ
		public Product listProductById(Integer pid);
		//�޸Ĳ�Ʒ����
		public void modifyProduct(Product product);
		//���ݲ�Ʒidɾ����Ʒ��Ϣ
		public void deleteProduct(Integer pid);
}
