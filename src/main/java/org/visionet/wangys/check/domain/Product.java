package org.visionet.wangys.check.domain;
/***********************
 * 
 * @author ����ʥ
 *	��Ʒ��Ϣ��
��Ʒ���	proId
��Ʒ����	proName
��Ʒ���	proType
��Ʒ����	proRemark
 */
public class Product {
	//��Ʒ���
	private Integer proid;
	//��Ʒ����
	private String proname;
	//��Ʒ���
	private Type protype;
	//��Ʒ����
	private String  proremark;
	
	
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public Type getProtype() {
		return protype;
	}
	public void setProtype(Type protype) {
		this.protype = protype;
	}
	public String getProremark() {
		return proremark;
	}
	public void setProremark(String proremark) {
		this.proremark = proremark;
	}
	
	@Override
	public String toString() {
		return "ProductInfo [proid=" + proid + ", proname=" + proname + ", protype=" + protype + ", proremark="
				+ proremark + "]";
	}
	
	
	
	
}
