package com.zmx.estest.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.zmx.estest.domain.CustomeBookIndex;


@Repository
public interface CustomeClassfiyBookRepository extends ElasticsearchRepository<CustomeBookIndex, Long> {

}
