package org.visionet.wangys.check.service;

import java.util.List;

import org.visionet.wangys.check.domain.Type;

public interface TypeService {
	
		//查看产品类别
		public List<Type> listAllType();
		//添加产品类别
		public void  addType(Type type);
		//修改产品类别
		public void modifyType(Type type);
		//根据类别id删除产品类别
		public void deleteType(Integer tid);
}
