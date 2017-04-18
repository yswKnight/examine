package org.visionet.wangys.check.domain;
/***********************
 * 
 * @author 王永圣
 *产品类别表
 *类别编号	typeId
 *类别名称	typeName
 */
public class Type {

	//类别编号
	private Integer typeid;
	//类别名称	
	private String typename;
	
	
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	@Override
	public String toString() {
		return "ProductType [typeid=" + typeid + ", typename=" + typename + "]";
	}
	
	
	
}
