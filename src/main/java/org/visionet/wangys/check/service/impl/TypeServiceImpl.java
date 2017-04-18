package org.visionet.wangys.check.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.visionet.wangys.check.domain.Type;
import org.visionet.wangys.check.persistence.TypeMapper;
import org.visionet.wangys.check.service.TypeService;
@Service
public class TypeServiceImpl implements TypeService {

	@Resource
	private TypeMapper typeMapper;
	
	//�鿴��Ʒ���
	@Override
	public List<Type> listAllType() {
		return typeMapper.findAllType();
	}
	//��Ӳ�Ʒ���
	@Override
	public void addType(Type type) {
		typeMapper.insertType(type);
	}
	//�޸Ĳ�Ʒ���
	@Override
	public void modifyType(Type type) {
		typeMapper.updateType(type);
	}
	//ɾ��
	@Override
	public void deleteType(Integer tid) {

		typeMapper.deleteTypeById(tid);
	}

}
