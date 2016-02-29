package com.adaque.wwq.questionaire.service.privilege.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaque.wwq.questionaire.dao.privilege.PrivilegeMapper;
import com.adaque.wwq.questionaire.po.Privilege;
import com.adaque.wwq.questionaire.service.privilege.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilegeMapper privilegeMapper;
	
	public Privilege getPrivilegeById(int id) {
		Privilege privilege = privilegeMapper.getPrivilegeById(id);
		return privilege;
	}

	public List<Privilege> getAllPrivilege() {
		List<Privilege> privilegeList = privilegeMapper.getAllPrivilege();
		return privilegeList;
	}

	public void updatePrivilegeById(int id) {
		privilegeMapper.updatePrivilegeById(id);
	}

	public void deletePrivilegeById(int id) {
		privilegeMapper.deletePrivilegeById(id);
	}

	public void addPrivilege(Privilege privilege) {
		privilegeMapper.addPrivilege(privilege);
	}

}
