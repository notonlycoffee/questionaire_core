package com.adaque.wwq.questionaire.model.easyuimodel;

import java.io.Serializable;

public class Attribute implements Serializable {
	private static final long serialVersionUID = 4912334881136747710L;
	private String url;
	private int c_id;
	private boolean really;//用来判断是否是用户实际拥有的资源
	

	public boolean isReally() {
		return really;
	}

	public void setReally(boolean really) {
		this.really = really;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
