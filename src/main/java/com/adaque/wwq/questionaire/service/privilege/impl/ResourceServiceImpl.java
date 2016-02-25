package com.adaque.wwq.questionaire.service.privilege.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaque.wwq.questionaire.dao.privilege.ResourceMapper;
import com.adaque.wwq.questionaire.po.Resource;
import com.adaque.wwq.questionaire.service.privilege.ResourceService;

public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	public Resource getResourceById(String id) {
		Resource resource = resourceMapper.getResourceById(id);
		return resource;
	}

	public Resource getResourceByName(String name) {
		Resource resource = resourceMapper.getResourceByName(name);
		return resource;
	}

	public List<Resource> getAllResource() {
		List<Resource> resorceList = resourceMapper.getAllResource();
		return resorceList;
	}

	public void updateResourceById(String id) {
		resourceMapper.updateResourceById(id);

	}

	public void deleteResourceById(String id) {
		resourceMapper.deleteResourceById(id);
	}

	public void addResource(Resource resource) {
		resourceMapper.addResource(resource);
	}

}
