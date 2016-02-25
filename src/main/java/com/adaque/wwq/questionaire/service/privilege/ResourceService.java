package com.adaque.wwq.questionaire.service.privilege;

import java.util.List;

import com.adaque.wwq.questionaire.po.Resource;

public interface ResourceService {
	public Resource getResourceById(String id);

	public Resource getResourceByName(String name);

	public List<Resource> getAllResource();

	public void updateResourceById(String id);

	public void deleteResourceById(String id);

}
