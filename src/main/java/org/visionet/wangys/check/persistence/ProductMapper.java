package org.visionet.wangys.check.persistence;

import java.util.List;
import java.util.Map;

import org.visionet.wangys.check.domain.Product;
/***********************
 * 
 * @author ����ʥ
 *
 */
public interface ProductMapper {
	
	//��Ӳ�Ʒ
	public void insertProduct(Product product);
	//��ѯȫ����Ʒ
	public List<Product> findProductAll();
	//��ѯ������
	public int getProductTotal();
	//��ҳ��ѯ��Ʒ
	public List<Product> findAllByPage(Map<String, Object> params);
	//����Id��ѯ��Ӧ��Ʒ��Ϣ
	public Product findProductById(Integer pid);
	//�޸Ĳ�Ʒ����
	public void updateProduct(Product product);
	//���ݲ�Ʒidɾ����Ʒ��Ϣ
	public void deleteProductById(Integer pid);
}
