package org.visionet.wangys.check.service;

import java.util.List;

import org.visionet.wangys.check.domain.Type;

public interface TypeService {
	
		//�鿴��Ʒ���
		public List<Type> listAllType();
		//��Ӳ�Ʒ���
		public void  addType(Type type);
		//�޸Ĳ�Ʒ���
		public void modifyType(Type type);
		//�������idɾ����Ʒ���
		public void deleteType(Integer tid);
}
