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
	
	//查看产品类别
	@Override
	public List<Type> listAllType() {
		return typeMapper.findAllType();
	}
	//添加产品类别
	@Override
	public void addType(Type type) {
		typeMapper.insertType(type);
	}
	//修改产品类别
	@Override
	public void modifyType(Type type) {
		typeMapper.updateType(type);
	}
	//删除
	@Override
	public void deleteType(Integer tid) {

		typeMapper.deleteTypeById(tid);
	}

}
