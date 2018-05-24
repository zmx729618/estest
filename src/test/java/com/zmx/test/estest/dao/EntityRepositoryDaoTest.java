package com.zmx.test.estest.dao;

import java.util.List;

import org.elasticsearch.index.query.MatchQueryBuilder.Operator;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder.Type;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zmx.estest.ESApplication;
import com.zmx.estest.dao.EntityRepository;
import com.zmx.estest.domain.Entity;
import com.zmx.estest.utils.PinyinUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ESApplication.class) //@SpringApplicationConfiguration(classes=ESApplication.class)// 指定我们SpringBoot工程的Application启动类
//@WebAppConfiguration //由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。  
public class EntityRepositoryDaoTest {
	
	@Autowired
	private EntityRepository entityRepository;
	
	
	
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
    public void testEntityRepository(){
    	System.out.println(entityRepository);
    }
    
    
    @Test
    public void testLoadEntity2ES(){
    	
    	Entity entity = new Entity();
    	entity.setId(3L);
    	entity.setName("人类简史");
    	entity.setJianpin("人类简史");
    	entity.setPinyin("人类简史");
    	entity.setShortName("国民");
    	entity.setFullName("共和国国民人类简史");
    	entity.setAbstractText("人类简史 中华人民共和国国民，中国国民，国民，一个善良的中国国民");
    	entityRepository.save(entity);
    }
    
    
    @Test
    public void testfindEntity2ES(){
    	
    	List<Entity> list1 = entityRepository.findByName("人类简史");
    	
    	List<Entity> list2 = entityRepository.findByName("renlei");
    	List<Entity> list3 = entityRepository.findByName("ren");
    	List<Entity> list4 = entityRepository.findByName("人lei");
    	List<Entity> list5 = entityRepository.findByName("人");
    	List<Entity> list6 = entityRepository.findByName("rljs");
    	List<Entity> list7 = entityRepository.findByName("rlj");
    	List<Entity> list8 = entityRepository.findByName("renleijianshi");
    	
    	List<Entity> list9 = entityRepository.findByName("简史");
    
    	
    	System.out.println("---------------1------------------------------");
    	
    	for(Entity e:list1 ){
    		System.out.println(e);
    	}
    	
    	System.out.println("-----------------2----------------------------");
    	for(Entity e:list2 ){
    		System.out.println(e);
    	}
    	
    	System.out.println("-----------------3----------------------------");
    	for(Entity e:list3 ){
    		System.out.println(e);
    	}
    	System.out.println("-------------------4--------------------------");
    	
    	for(Entity e:list4 ){
    		System.out.println(e);
    	}
    	System.out.println("-------------------5--------------------------");
    	
    	for(Entity e:list5 ){
    		System.out.println(e);
    	}
    	
    	System.out.println("--------------------6-------------------------");
    	
    	for(Entity e:list6 ){
    		System.out.println(e);
    	}
    	
    	System.out.println("--------------------7-------------------------");
    	
    	for(Entity e:list7 ){
    		System.out.println(e);
    	}
    	
    	System.out.println("--------------------8-------------------------");
    	
    	for(Entity e:list8 ){
    		System.out.println(e);
    	}
    	
    	
    	System.out.println("--------------------9-------------------------");
    	for(Entity e:list9 ){
    		System.out.println(e);
    	}
    }
    
    /**
     * 测试下拉匹配
     */
    @Test
    public void testElasticsearchAutoComplete(){
    	
    	List<Entity> list1 = searchAutoComplete("人类简史");    	
    	List<Entity> list2 = searchAutoComplete("renleij");
    	List<Entity> list3 = searchAutoComplete("renl");
    	List<Entity> list4 = searchAutoComplete("人leij");
    	List<Entity> list5 = searchAutoComplete("人");
    	List<Entity> list6 = searchAutoComplete("rljs");
    	List<Entity> list7 = searchAutoComplete("rlj");
    	List<Entity> list8 = searchAutoComplete("renleijianshi");
    	List<Entity> list9 = searchAutoComplete("简史");
   

      	
      	System.out.println("---------------1------------------------------");
      	
      	for(Entity e:list1 ){
      		System.out.println(e);
      	}
      	
      	System.out.println("-----------------2----------------------------");
      	for(Entity e:list2 ){
      		System.out.println(e);
      	}
      	
      	System.out.println("-----------------3----------------------------");
      	for(Entity e:list3 ){
      		System.out.println(e);
      	}
      	System.out.println("-------------------4--------------------------");
      	
      	for(Entity e:list4 ){
      		System.out.println(e);
      	}
      	System.out.println("-------------------5--------------------------");
      	
      	for(Entity e:list5 ){
      		System.out.println(e);
      	}
      	
      	System.out.println("--------------------6-------------------------");
      	
      	for(Entity e:list6 ){
      		System.out.println(e);
      	}
      	
      	System.out.println("--------------------7-------------------------");
      	
      	for(Entity e:list7 ){
      		System.out.println(e);
      	}
      	
      	System.out.println("--------------------8-------------------------");
      	
      	for(Entity e:list8 ){
      		System.out.println(e);
      	}
      	
      	
      	System.out.println("--------------------9-------------------------");
      	for(Entity e:list9 ){
      		System.out.println(e);
      	}
 

    }
    
    
    
    public List<Entity> searchAutoComplete(String keyWords){
        
    	Pageable pageable = new PageRequest(Long.valueOf(0).intValue(), Long.valueOf(10).intValue());
    	SearchQuery searchQuery = new NativeSearchQueryBuilder()
		        .withQuery(QueryBuilders.boolQuery()
				.should(QueryBuilders.termQuery("name", keyWords))
				.should(QueryBuilders.termQuery("pinyin", PinyinUtils.getQuanPin(keyWords)))
			    .should(QueryBuilders.termQuery("jianpin", keyWords)))
		        .withIndices("i_entity")
		        .withTypes("t_entity")
		        .withSort(SortBuilders.scoreSort())
		        .withPageable(pageable)
		        .build();
		Page<Entity> page = entityRepository.search(searchQuery);
		if (null != page) {
			List<Entity> retList = page.getContent();
		    return retList;
		}
		return null;

    }
    
    
    
    @Test
    public void testESearch(){
    	

    	Pageable pageable = new PageRequest(Long.valueOf(0).intValue(), Long.valueOf(10).intValue());
    	SearchQuery searchQuery = new NativeSearchQueryBuilder()
		        .withQuery(QueryBuilders.boolQuery().should(QueryBuilders.termQuery("name", "人类简"))
		        		                            .should(QueryBuilders.existsQuery("shortName"))
		        		                            .should(QueryBuilders.matchQuery("", "").operator(Operator.OR)))
		        .withIndices("i_entity")
		        .withTypes("t_entity")
		        .withSort(SortBuilders.scoreSort())
		        .withPageable(pageable)
		        .build();
		Page<Entity> page = entityRepository.search(searchQuery);
		if (null != page) {
			List<Entity> retList = page.getContent();
	      	for(Entity e:retList ){
	      		System.out.println(e);
	      	}
		}


    }
    
    
    /**
     * 单字符串模糊查询，默认排序。将从所有字段中查找包含传来的word分词后字符串的数据集
     */
    @Test
    public void testESStringQuery(){
    	String word ="中国人民";
    	Pageable pageable = new PageRequest(Long.valueOf(0).intValue(), Long.valueOf(10).intValue());
    	//使用queryStringQuery完成单字符串查询  
    	SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.queryStringQuery(word)).withPageable(pageable).build();
    	Page<Entity> page = entityRepository.search(searchQuery);
		if (null != page) {
			List<Entity> retList = page.getContent();
	      	for(Entity e:retList ){
	      		System.out.println(e);
	      	}
		}
    }
    
    
 
    /**
     * 前缀匹配
     */
    
    @Test
    public void testESPrefixQuery(){
    	
    	String word ="中华人民";
    	Pageable pageable = new PageRequest(Long.valueOf(0).intValue(), Long.valueOf(10).intValue());
    	
    	//使用queryStringQuery完成单字符串查询  
    	SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.prefixQuery("fullName",word)).withPageable(pageable).withSort(SortBuilders.scoreSort()).build();
    	Page<Entity> page = entityRepository.search(searchQuery);
		if (null != page) {
			List<Entity> retList = page.getContent();
	      	for(Entity e:retList ){
	      		System.out.println(e);
	      	}
		}
    }
    
    
    /**
     * 查询某个字段中模糊包含目标字符串，使用matchQuery
     */
    @Test
    public void testESMatchQuery(){
    	String word ="共和";
    	Pageable pageable = new PageRequest(Long.valueOf(0).intValue(), Long.valueOf(10).intValue());
    	
    	//使用queryStringQuery完成单字符串查询  
    	SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("fullName",word)).withPageable(pageable).withSort(SortBuilders.scoreSort()).build();
    	Page<Entity> page = entityRepository.search(searchQuery);
		if (null != page) {
			List<Entity> retList = page.getContent();
	      	for(Entity e:retList ){
	      		System.out.println(e);
	      	}
		}
    }
    
    
    /**
     * 短语匹配
     * 单字段对某短语进行匹配查询，短语分词的顺序会影响结果
     */
    @Test
    public void testESPhraseMatch(){
    	
    	
    	String word ="人民共和国";
    	Pageable pageable = new PageRequest(Long.valueOf(0).intValue(), Long.valueOf(10).intValue());
    	
    	//使用queryStringQuery完成单字符串查询  
    	SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchPhraseQuery("fullName",word)).withPageable(pageable).withSort(SortBuilders.scoreSort()).build();
    	Page<Entity> page = entityRepository.search(searchQuery);
		if (null != page) {
			List<Entity> retList = page.getContent();
	      	for(Entity e:retList ){
	      		System.out.println(e);
	      	}
		}
    	
    }
    
    
    /**
     * 短语匹配
     * 单字段对某短语进行匹配查询，短语分词的顺序会影响结果
     * 
     * 无论是matchQuery，multiMatchQuery，queryStringQuery等，都可以设置operator。默认为Or，设置为And后，就会把符合包含所有输入的才查出来。
     * 如果是and的话，譬如用户输入了5个词，但包含了4个，也是显示不出来的。我们可以通过设置精度来控制。
     *
     *  best_fields  完全匹配文档评分最高
     *  most_fields  越多字段匹配的文档评分越高
     *  cross_fields 分词词汇是分配到不同字段评分越高
     *  
     */
    @Test
    public void testESMultiMatch(){
    	
    	
    	String word ="人民共和国";
    	Pageable pageable = new PageRequest(Long.valueOf(0).intValue(), Long.valueOf(10).intValue());
    	
    	// 
    	SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(word,"fullName","shortName","abstractText").type(Type.BEST_FIELDS).operator(Operator.AND).minimumShouldMatch("75%")).withPageable(pageable).withSort(SortBuilders.scoreSort()).build();
    	Page<Entity> page = entityRepository.search(searchQuery);
		if (null != page) {
			List<Entity> retList = page.getContent();
	      	for(Entity e:retList ){
	      		System.out.println(e);
	      	}
		}
    	
    }
    
    
    
    /**
     * Term匹配
     * 最严格的匹配，属于低级查询，不进行分词的
     */
    @Test
    public void testESTermQuery(){
    	String word ="rljs";
    	Pageable pageable = new PageRequest(Long.valueOf(0).intValue(), Long.valueOf(10).intValue());
    	
    	//使用queryStringQuery完成单字符串查询  
    	SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.termQuery("jianpin",word)).withPageable(pageable).withSort(SortBuilders.scoreSort()).build();
    	Page<Entity> page = entityRepository.search(searchQuery);
		if (null != page) {
			List<Entity> retList = page.getContent();
	      	for(Entity e:retList ){
	      		System.out.println(e);
	      	}
		}
    	
    }
    
    
    /**
     * 合并查询
     * 即boolQuery，可以设置多个条件的查询方式。它的作用是用来组合多个Query，有四种方式来组合，must，mustnot，filter，should。
     * must代表返回的文档必须满足must子句的条件，会参与计算分值;
     * filter代表返回的文档必须满足filter子句的条件，但不会参与计算分值;
     * should代表返回的文档可能满足should子句的条件，也可能不满足，有多个should时满足任何一个就可以，通过minimum_should_match设置至少满足几个。
     * mustnot代表必须不满足子句的条件。
     * 
     */
    @Test
    public void testESBoolQuery(){
    	String word ="中华";
    	Pageable pageable = new PageRequest(Long.valueOf(0).intValue(), Long.valueOf(10).intValue());
    	    	
    	SearchQuery searchQuery = new NativeSearchQueryBuilder()
    			.withQuery(QueryBuilders.boolQuery()
    			.must(QueryBuilders.termQuery("id",1L))
    			.should(QueryBuilders.rangeQuery("id").lt(12L))
    			.must(QueryBuilders.matchQuery("fullName",word)))
    			.withPageable(pageable)
    			.build();
    	Page<Entity> page = entityRepository.search(searchQuery);
		if (null != page) {
			List<Entity> retList = page.getContent();
	      	for(Entity e:retList ){
	      		System.out.println(e);
	      	}
		}
    	
    }
    

}
