package org.visionet.wangys.check.persistence;
/*******************************
 * 
 * @author ����ʥ
 *
 */

import java.util.List;

import org.visionet.wangys.check.domain.Product;
import org.visionet.wangys.check.domain.Type;

public interface TypeMapper {
	//�鿴��Ʒ���
	public List<Type> findAllType();
	//��Ӳ�Ʒ���
	public void  insertType(Type type);
	//�޸Ĳ�Ʒ���
	public void updateType(Type type);
	//�������idɾ����Ʒ���
	public void deleteTypeById(Integer tid);
}
