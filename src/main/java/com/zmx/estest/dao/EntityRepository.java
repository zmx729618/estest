package com.zmx.estest.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.zmx.estest.domain.Entity;



@Repository
public interface EntityRepository extends ElasticsearchRepository<Entity,Long> {
	
    /**
     * @desccroption:根据关键词语查询信息
     */
    public List<Entity> findByName(String name);
    public List<Entity> findByJianpin(String name);
    public List<Entity> findByPinyin(String name);
    
    public List<Entity> findByNameOrPinyinOrJianpin(String name,String name1,String name2);
    
    
    public List<Entity> findByFullName(String name);
    
    public List<Entity> findByShortName(String name);
    
    public List<Entity> findByAbstractText(String name);
    
    public List<Entity> findByFullNameAndAbstractText(String name);
    public List<Entity> findByFullNameOrAbstractText(String name);
    
    
    
    List<Entity> findByNameAndFullName(String name, String fullName);

    // Enables the distinct flag for the query
    List<Entity> findDistinctEntityByNameAndFullName(String name, String fullName);
    List<Entity> findEntityDistinctByIdOrName(Long id, String name);

    // Enabling ignoring case for an individual property
    List<Entity> findByNameIgnoreCase(String name);
    
    // Enabling ignoring case for all suitable properties
    List<Entity> findByNameAndFullNameAllIgnoreCase(String name, String fullName);

    // Enabling static ORDER BY for a query
    List<Entity> findByNameOrderByFullNameAsc(String name);
    List<Entity> findByNameOrderByFullNameDesc(String name);
    
    
    Page<Entity> findPageByName(String name, Pageable pageable);

    Slice<Entity> findSliceByName(String name, Pageable pageable);

    List<Entity> findListByName(String name, Sort sort);

    List<Entity> findListByName(String name, Pageable pageable);
    
    
    /**
     * @desccroption:根据ID删除信息
     */
    public Long deleteById(Long Id);
	

}