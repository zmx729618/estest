package com.zmx.estest.service.impl;

import java.util.List;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.zmx.estest.dao.EntityRepository;
import com.zmx.estest.domain.Entity;
import com.zmx.estest.service.EntityService;

@Service
public class EntityServiceImpl extends BaseService implements EntityService{
	
	@Autowired
	private EntityRepository entityRepository;

	@Override
	public void loadEntity2ES(List<Entity> entityList) {
		
		if (null != entityList && entityList.size() > 0) {
			for (Entity e : entityList) {
				this.loadEntity2ES(e);
			}
		}
	}

	
	public void loadEntity2ES(Entity entity) {
		try {	
			entityRepository.save(entity);
		} catch (Exception e) {
			log.error("保存常规分类书籍信息进es出错", e);
		}
	}
	
	
	public void delEntity2ES(Long id) {
		entityRepository.delete(id);
	}
	
	
	@Override
	public List<Entity> searchEntity(String keyWord, String id, Long offset, Long pageSize) {
		
		Pageable pageable = new PageRequest(Long.valueOf(offset).intValue(), Long.valueOf(pageSize).intValue());
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				        .withQuery(QueryBuilders.boolQuery()
						.must(QueryBuilders.termQuery("id", id))
						.must(QueryBuilders.multiMatchQuery(keyWord, "name^2")
					    .type(MultiMatchQueryBuilder.Type.BEST_FIELDS)))
				        .withIndices("index_entity")
				        .withTypes("type_entity")
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
	
	
	public List<Entity> searchEntity(String keyWord, Long offset, Long pageSize) {
		
		Pageable pageable = new PageRequest(Long.valueOf(offset).intValue(), Long.valueOf(pageSize).intValue());
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.boolQuery().must(QueryBuilders.multiMatchQuery(keyWord, "name^2")
								.type(MultiMatchQueryBuilder.Type.BEST_FIELDS)))
				.withIndices("i_entity").withTypes("t_entity").withSort(SortBuilders.scoreSort()).withPageable(pageable)
				.build();
		Page<Entity> page = entityRepository.search(searchQuery);
		if (null != page) {
			List<Entity> retList = page.getContent();
			return retList;
		}
		return null;
	}
	
	
	
	public List<Entity> searchEntity2(String keyWord, Long offset, Long pageSize) {
		
		Pageable pageable = new PageRequest(Long.valueOf(offset).intValue(), Long.valueOf(pageSize).intValue());
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.boolQuery().must(QueryBuilders.multiMatchQuery(keyWord, "name^2")
								.type(MultiMatchQueryBuilder.Type.BEST_FIELDS)))
				.withIndices("index_entity").withTypes("type_entity").withSort(SortBuilders.scoreSort()).withPageable(pageable)
				.build();
		Page<Entity> page = entityRepository.search(searchQuery);
		if (null != page) {
			List<Entity> retList = page.getContent();
			return retList;
		}
		return null;
	}
	
	
	
	
    public List<Entity> searchAutoComplete(String keyWords){
     
    	Pageable pageable = new PageRequest(Long.valueOf(0).intValue(), Long.valueOf(10).intValue());
    	SearchQuery searchQuery = new NativeSearchQueryBuilder()
		        .withQuery(QueryBuilders.boolQuery()
				.should(QueryBuilders.termQuery("name", keyWords))
				.should(QueryBuilders.termQuery("pinyin", keyWords))
			    .should(QueryBuilders.termQuery("jianpin", keyWords)
			    ))
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



}
