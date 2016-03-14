package com.adaque.wwq.questionaire.service.privilege;

import java.util.List;

import com.adaque.wwq.questionaire.model.easyuimodel.MenuTreeModel;
import com.adaque.wwq.questionaire.model.easyuimodel.UserRole;
import com.adaque.wwq.questionaire.po.Resource;

public interface ResourceService {
	public Resource getResourceById(int id);

	public Resource getResourceByName(String name);

	public List<Resource> getAllResource();

	public void updateResourceById(int id);

	public void deleteResourceById(int id);
	
	public MenuTreeModel getPrivilegeByResourceId(UserRole userRole);

	public void addResource(Resource resource);
	
	public int getMaxid();
}
