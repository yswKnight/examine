package org.visionet.wangys.check.persistence;

import java.util.List;
import java.util.Map;

import org.visionet.wangys.check.domain.Page;
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
	public List<Product> findProductAll(Page page);
	//��ѯ������
	public int getProductTotal();
	//��ҳ��ѯ��Ʒ
	//public List<Product> queryPageList(Map<String, Object> map);
	//����Id��ѯ��Ӧ��Ʒ��Ϣ
	public Product findProductById(Integer pid);
	//�޸Ĳ�Ʒ����
	public void updateProduct(Product product);
	//���ݲ�Ʒidɾ����Ʒ��Ϣ
	public void deleteProductById(Integer pid);
}
