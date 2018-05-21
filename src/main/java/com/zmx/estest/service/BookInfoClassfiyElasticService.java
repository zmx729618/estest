package com.zmx.estest.service;

import java.util.List;

import com.zmx.estest.dto.ClassBookDTO;



public interface BookInfoClassfiyElasticService {

	public void loadCommonClassifyBook2ES(List<ClassBookDTO> classifyBookList);
	
	public void loadCustomeClassifyBook2ES(List<ClassBookDTO> classifyBookList);
	
	public List<ClassBookDTO> searchCommonClassifyBook(String keyWord,String claId , Long offset, Long pageSize);
	
	public List<ClassBookDTO> searchCustomClassifyBook(String keyWord,String claId , Long offset, Long pageSize);
}
