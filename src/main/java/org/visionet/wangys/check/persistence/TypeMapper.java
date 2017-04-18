package org.visionet.wangys.check.persistence;
/*******************************
 * 
 * @author 王永圣
 *
 */

import java.util.List;

import org.visionet.wangys.check.domain.Product;
import org.visionet.wangys.check.domain.Type;

public interface TypeMapper {
	//查看产品类别
	public List<Type> findAllType();
	//添加产品类别
	public void  insertType(Type type);
	//修改产品类别
	public void updateType(Type type);
	//根据类别id删除产品类别
	public void deleteTypeById(Integer tid);
}
