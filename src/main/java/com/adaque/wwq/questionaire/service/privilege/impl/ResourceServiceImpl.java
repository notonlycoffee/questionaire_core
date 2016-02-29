package com.adaque.wwq.questionaire.service.privilege.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaque.wwq.questionaire.dao.privilege.ResourceMapper;
import com.adaque.wwq.questionaire.po.Resource;
import com.adaque.wwq.questionaire.service.privilege.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	public Resource getResourceById(int id) {
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

	public void updateResourceById(int id) {
		resourceMapper.updateResourceById(id);

	}

	public void deleteResourceById(int id) {
		resourceMapper.deleteResourceById(id);
	}

	public void addResource(Resource resource) {
		resourceMapper.addResource(resource);
	}

	public Resource getResourceById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateResourceById(String id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteResourceById(String id) {
		// TODO Auto-generated method stub
		
	}

}
