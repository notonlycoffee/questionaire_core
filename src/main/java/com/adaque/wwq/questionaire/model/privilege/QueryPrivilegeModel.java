package com.adaque.wwq.questionaire.model.privilege;

import java.io.Serializable;

public class QueryPrivilegeModel implements Serializable {
	
	private static final long serialVersionUID = -1511269936040043615L;
	private int resource_id;
	private int privilege_id;
	private String resource_name;
	private String privilege_name;
	private String resource_path;
	public int getResource_id() {
		return resource_id;
	}
	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}
	public int getPrivilege_id() {
		return privilege_id;
	}
	public void setPrivilege_id(int privilege_id) {
		this.privilege_id = privilege_id;
	}
	public String getResource_name() {
		return resource_name;
	}
	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}
	public String getPrivilege_name() {
		return privilege_name;
	}
	public void setPrivilege_name(String privilege_name) {
		this.privilege_name = privilege_name;
	}
	public String getResource_path() {
		return resource_path;
	}
	public void setResource_path(String resource_path) {
		this.resource_path = resource_path;
	}
	
	
	
	
	
	
	
}
