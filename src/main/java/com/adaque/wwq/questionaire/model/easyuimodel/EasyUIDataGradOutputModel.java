package com.adaque.wwq.questionaire.model.easyuimodel;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EasyUIDataGradOutputModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5832385064013646726L;
	/**
	 * 总条数
	 */
	private int total;
	/**
	 * 输出实体模型列表
	 */
	private List<?> rows = new ArrayList();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
