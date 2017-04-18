package org.visionet.wangys.check.domain;

public class Page {
	private Integer startRow=0;//开始位置
	private Integer endRow=5;//一页显示多少条
	private Integer pageNo=0;//第几页
	
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getEndRow() {
		return endRow;
	}
	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	
	
}
