package com.adaque.wwq.po;

import java.io.Serializable;

public class Function implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1275209598774452388L;
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
