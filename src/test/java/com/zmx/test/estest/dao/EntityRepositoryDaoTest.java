package com.zmx.test.estest.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zmx.estest.ESApplication;
import com.zmx.estest.dao.EntityRepository;
import com.zmx.estest.domain.Entity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ESApplication.class) //@SpringApplicationConfiguration(classes=ESApplication.class)// 指定我们SpringBoot工程的Application启动类
//@WebAppConfiguration //由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。  
public class EntityRepositoryDaoTest {
	
	@Autowired
	private EntityRepository entityRepository;
	
    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }
    
    @Test
    public void testEntityRepository(){
    	System.out.println(entityRepository);
    }
    
    
    @Test
    public void testLoadEntity2ES(){
    	
    	Entity entity = new Entity();
    	entity.setId(6L);
    	entity.setName("中国人民");
    	entity.setShortName("国民");
    	entity.setFullName("中华人民共和国国民");
    	entity.setAbstractText("中华人民共和国国民，中国国民，国民，一个善良的中国国民");
    	entityRepository.save(entity);
    }
    
    
    @Test
    public void testfindEntity2ES(){
    	
 
//    	List<Entity> list = entityRepository.findByName("解放");
    	List<Entity> list = entityRepository.findByFullName("共和");
    	
    	for(Entity e:list ){
    		System.out.println(e);
    	}
    }
    
    
    

}
