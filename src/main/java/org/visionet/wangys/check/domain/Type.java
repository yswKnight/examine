package org.visionet.wangys.check.domain;
/***********************
 * 
 * @author ����ʥ
 *��Ʒ����
 *�����	typeId
 *�������	typeName
 */
public class Type {

	//�����
	private Integer typeid;
	//�������	
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
