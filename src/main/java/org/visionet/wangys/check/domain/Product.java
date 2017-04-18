package org.visionet.wangys.check.domain;
/***********************
 * 
 * @author 王永圣
 *	产品信息表
产品编号	proId
产品名称	proName
产品类别	proType
产品描述	proRemark
 */
public class Product {
	//产品编号
	private Integer proid;
	//产品名称
	private String proname;
	//产品类别
	private Type protype;
	//产品描述
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
