package com.adaque.wwq.questionaire.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Privilege implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1275209598774452388L;
	private int id;
	private String name;
	private List<Resource> resourceList = new ArrayList();
	private List<Privilege> ownPrivilege = new ArrayList();
	
	
	public List<Privilege> getOwnPrivilege() {
		return ownPrivilege;
	}
	public void setOwnPrivilege(List<Privilege> ownPrivilege) {
		this.ownPrivilege = ownPrivilege;
	}
	public List<Resource> getResourceList() {
		return resourceList;
	}
	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}
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
