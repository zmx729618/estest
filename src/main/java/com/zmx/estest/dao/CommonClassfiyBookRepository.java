package com.zmx.estest.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.zmx.estest.domain.CommonBookIndex;


@Repository
public interface CommonClassfiyBookRepository extends ElasticsearchRepository<CommonBookIndex,Long> {

	
	
}
