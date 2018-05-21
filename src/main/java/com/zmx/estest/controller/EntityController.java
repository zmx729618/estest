package com.zmx.estest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zmx.estest.domain.Entity;
import com.zmx.estest.service.EntityService;

@Controller
@RequestMapping(value = "/estest")
public class EntityController {
	
	@Autowired
	private EntityService entityService;
	
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "Hello World!";
	}
	
	

	@RequestMapping(value="/searchEntity",method=RequestMethod.POST)
	@ResponseBody
	public  List<Entity> searchEntity(String keyWord, Long offset, Long pageSize){
		
		List<Entity> list = entityService.searchEntity(keyWord, offset, pageSize);
		
		return list;
	}

}
