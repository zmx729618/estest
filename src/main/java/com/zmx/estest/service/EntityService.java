package com.zmx.estest.service;

import java.util.List;

import com.zmx.estest.domain.Entity;



public interface EntityService {
	
	public void loadEntity2ES(List<Entity> classifyBookList);
	
	public List<Entity> searchEntity(String keyWord,  String claId , Long offset, Long pageSize);

	
	public void loadEntity2ES(Entity entity);
	
	
	public void delEntity2ES(Long id);
	
	public List<Entity> searchEntity(String keyWord, Long offset, Long pageSize);
	
	
}
