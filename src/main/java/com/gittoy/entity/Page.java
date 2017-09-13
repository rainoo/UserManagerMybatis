package com.gittoy.entity;

/**
 * ��ҳ��Ӧ��ʵ����
 * 
 * @author GaoYu
 */
public class Page {

	/**
	 * ������
	 */
	private int totalNumber;

	/**
	 * ��ǰ�ڼ�ҳ
	 */
	private int currentPage;

	/**
	 * ��ҳ��
	 */
	private int totalPage;

	/**
	 * ÿҳ��ʾ����
	 */
	private int pageNumber = 25;

	/**
	 * ���ݿ���limit�Ĳ������ӵڼ�����ʼȡ
	 */
	private int dbIndex;

	/**
	 * ���ݿ���limit�Ĳ�����һ��ȡ������
	 */
	private int dbNumber;

	/**
	 * ���ݵ�ǰ����������ֵ���㲢�����������ֵ
	 */
	public void count() {
		// ������ҳ��
		int totalPageTemp = this.totalNumber / this.pageNumber;
		int plus = (this.totalNumber % this.pageNumber) == 0 ? 0 : 1;
		totalPageTemp = totalPageTemp + plus;
		if (totalPageTemp <= 0) {
			totalPageTemp = 1;// ��ҳ����1ҳ���������ʾΪ1ҳ
		}
		this.totalPage = totalPageTemp;

		// ���õ�ǰҳ��
		// ��ҳ��С�ڵ�ǰҳ����Ӧ����ǰҳ������Ϊ��ҳ��
		if (this.totalPage < this.currentPage) {
			this.currentPage = this.totalPage;
		}
		// ��ǰҳ��С��1����Ϊ1
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}

		// ����limit�Ĳ���
		this.dbIndex = (this.currentPage - 1) * this.pageNumber;
		this.dbNumber = this.pageNumber;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		this.count();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
		this.count();
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
