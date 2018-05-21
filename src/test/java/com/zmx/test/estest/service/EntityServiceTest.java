package com.zmx.test.estest.service;

import java.util.List;

import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import com.zmx.estest.ESApplication;
import com.zmx.estest.domain.Entity;
import com.zmx.estest.service.EntityService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ESApplication.class)
public class EntityServiceTest {
	
	
	
	@Autowired
	private EntityService entityService;
	
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    
    
    
	
    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }
    
    @Test
    public void testLoadEntity2ES(){
    	System.out.println(entityService);
    	
    	Entity entity = new Entity();
    	entity.setId(5L);
    	entity.setName("中国人民");
    	entityService.loadEntity2ES(entity);
    }
    
    
    @Test
    public void testfindEntity2ES(){
    	
 
    	List<Entity> list = entityService.searchEntity("zhangsan111", 0L, 10L);
    	
    	for(Entity e:list ){
    		System.out.println(e);
    	}
    }
    
    
    
    
    @Test
    public void testElasticsearchTemplateSearch(){
    	System.out.println(elasticsearchTemplate);
		Pageable pageable = new PageRequest(Long.valueOf(0).intValue(), Long.valueOf(10).intValue());
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
        		.withQuery(QueryBuilders.boolQuery().must(QueryBuilders.multiMatchQuery("民", "name^2","shortName","abstractText^3")
						.type(MultiMatchQueryBuilder.Type.BEST_FIELDS)))
		.withIndices("index_entity").withTypes("type_entity").withSort(SortBuilders.scoreSort()).withPageable(pageable)
		.build();
        AggregatedPage<Entity> sampleEntities = elasticsearchTemplate.queryForPage(searchQuery,Entity.class);
        List<Entity> list =sampleEntities.getContent();
    	for(Entity e:list ){
    		System.out.println(e);
    	}

    }
	
    
    
    @Test
    public void testGetTransportClient(){
    	
    	Client transportClient = elasticsearchTemplate.getClient();
    	
    	
        

    }

}
