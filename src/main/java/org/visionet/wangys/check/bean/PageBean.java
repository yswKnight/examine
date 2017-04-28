package org.visionet.wangys.check.bean;

import java.util.List;

public class PageBean<T> {

	public final static int DEFAULT_PAGENO = 1;
	public final static int DEFAULT_PAGESIZE =6;

	// 当前页
	private int pageNo;
	// 每页显示数据条数
	private int pageSize;
	// 总记录条数
	private long totalItems;
	// 总页数
	private int totalPageNum;

	// 记录
	private List<T> result;

	// 使用limit分页关键字
	private int dbIndex;
	private int dbNumber;

	public PageBean() {

		this.pageNo = DEFAULT_PAGENO;
		this.pageSize = DEFAULT_PAGESIZE;
	}

	public PageBean(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	// 计算相关的参数
	public void count() {

		// 根据总记录条数计算机总页数
		if (this.totalItems % this.pageSize == 0) {
			this.totalPageNum = (int) (this.totalItems / this.pageSize);
		} else {
			this.totalPageNum = (int) (this.totalItems / this.pageSize) + 1;
		}

		if (this.pageNo < 1) {
			this.pageNo = 1;
		}

		if (this.pageNo > this.totalPageNum) {
			this.pageNo = this.totalPageNum;
		}

		this.dbIndex = (this.pageNo - 1) * this.pageSize;

		this.dbNumber = this.pageSize;

	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
		// 计算参数
		this.count();
		// System.out.println(dbIndex);
		// System.out.println(dbNumber);
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

	public int getDbNumber() {
		return dbNumber;
	}

	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}

}
