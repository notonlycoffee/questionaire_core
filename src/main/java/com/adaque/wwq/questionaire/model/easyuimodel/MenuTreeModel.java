package com.adaque.wwq.questionaire.model.easyuimodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuTreeModel implements Serializable {
	
	private static final long serialVersionUID = -2103632512016631274L;
	private int id;
	private int c_id;
	private String text;
	private String iconCls="icon-table";
	private Attribute attributes;
	private String state="open";
	private String url;
	private boolean checked=false;
	private List<MenuTreeModel> children = new ArrayList();
	
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Attribute getAttributes() {
		return attributes;
	}
	public void setAttributes(Attribute attributes) {
		this.attributes = attributes;
	}
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<MenuTreeModel> getChildren() {
		return children;
	}
	public void setChildren(List<MenuTreeModel> children) {
		this.children = children;
	}
	
	
	
}
