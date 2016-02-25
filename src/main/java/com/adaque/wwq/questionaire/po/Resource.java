package com.adaque.wwq.questionaire.po;

import java.io.Serializable;

public class Resource implements Serializable {
	private static final long serialVersionUID = 438229412324213150L;

	private String id;
	private String name;
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	private Privilege privilege;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Privilege getFunction() {
		return privilege;
	}

	public void setFunction(Privilege privilege) {
		this.privilege = privilege;
	}

}
