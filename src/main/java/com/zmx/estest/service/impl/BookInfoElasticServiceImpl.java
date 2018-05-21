package com.zmx.estest.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.zmx.estest.dao.BookInfoRepository;
import com.zmx.estest.domain.BookInfoIndex;
import com.zmx.estest.dto.AdminBookInfoDTO;
import com.zmx.estest.dto.AdminBookSearchFilter;
import com.zmx.estest.dto.BookInfoDTO;
import com.zmx.estest.service.BookInfoElasticService;



/**
 * @Description： 书摘后台：书籍相关搜索数据接口实现
 * @date: 2016年10月13日 下午3:59:25 
 * @author zhangyufeng@citicpub.com
 */
@Service
public class BookInfoElasticServiceImpl extends BaseService implements BookInfoElasticService {


    @Autowired
    private BookInfoRepository bookInfoRepository;

	@Override
	public void loadBookInfo2Es(AdminBookInfoDTO bookDto) {
		try {
			BookInfoIndex index = new BookInfoIndex();
			BeanUtils.copyProperties(index,bookDto);
			bookInfoRepository.save(index);
        }catch (Exception e){
            log.error("转换bookDto对象出错, Bookid:{}",bookDto.getId(),e);
            throw new RuntimeException("转换bookDto对象出错, Bookid:{}:"+bookDto.getId(),e);
        }
	}


	@Override
	public void loadBookInfoList2Es(List<BookInfoDTO> bookDto) {
		try {
            List<BookInfoIndex> BookInfoList = new ArrayList<BookInfoIndex>();
            for(BookInfoDTO chp : bookDto) {
            	BookInfoIndex index = new BookInfoIndex();
            	BeanUtils.copyProperties(index,chp);
            	BookInfoList.add(index);
            }
            bookInfoRepository.save(BookInfoList);
        }catch (Exception e){
            log.error("保存bookDto对象列表到elastic出错,",e);
        }
		
	}

	@Override
	public Map<String, Object> searchBookInfoFromEs(String searchKeys,long offset, long pageSize) {
		Pageable pageable = new PageRequest(Long.valueOf(offset).intValue(),Long.valueOf(pageSize).intValue());
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(searchKeys, "bookName^2", "bookSecname", "authorName").type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
                .withIndices("shuzhai").withTypes("book")
                .withSort(SortBuilders.scoreSort()).withPageable(pageable)
                .build();
        Page<BookInfoIndex> page = bookInfoRepository.search(searchQuery);
        Map<String,Object> retMap = new HashMap<String,Object>();
        Long totalCount = Long.valueOf(0);
        if(null!=page){
            totalCount = page.getTotalElements();
            List<BookInfoIndex> bookIndexList = page.getContent();
            List<BookInfoDTO> bookInfoDTOList = new ArrayList<BookInfoDTO>();
            if(page.getSize()>0){
                try {
                    for (BookInfoIndex bookIndex : bookIndexList) {
                    	BookInfoDTO bookInfoDTO = new BookInfoDTO();
                        BeanUtils.copyProperties(bookInfoDTO, bookIndex);
                        bookInfoDTOList.add(bookInfoDTO);
                    }
                }catch (Exception e){
                    log.error("拷贝对象出错",e);
                }
            }
            retMap.put("datas",bookInfoDTOList);
        }
        retMap.put("totalCount",totalCount);
        return retMap;
	}

	@Override
	public Map<String, Object> searchBookInfoFromEsForAdmin(AdminBookSearchFilter filter,long offset, long pageSize) {
		//构造分页条件
		Pageable pageable = new PageRequest(Long.valueOf(offset).intValue(),Long.valueOf(pageSize).intValue());
		
		//构造全文搜索查询条件
		SearchQuery searchQuery = null;
		QueryStringQueryBuilder builder = QueryBuilders.queryStringQuery(filter.getSearchWord())
				.field("bookName").field("isbnnum").field("bookSecname")
		        .field("authorName").field("tagList").field("keyWordList");
		
		//构造排序器
		FieldSortBuilder sortBuilder = SortBuilders.fieldSort("id").order(SortOrder.ASC);
		if(filter.getSortedFlag() == null || filter.getSortedFlag() == 2){
			sortBuilder = SortBuilders.fieldSort("id").order(SortOrder.DESC);
		}
		
		NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(builder)
                .withIndices("shuzhai").withTypes("book")
                .withSort(sortBuilder).withPageable(pageable);
		
		//构造过滤器
		if(filter.getTbAdminOrgId() != null){
			searchQueryBuilder.withFilter(QueryBuilders.termQuery("tbAdminOrgId", filter.getTbAdminOrgId()));
		}
		if(filter.getTbAdminDepartmentId() != null){
			searchQueryBuilder.withFilter(QueryBuilders.termQuery("tbAdminDepartmentId", filter.getTbAdminDepartmentId()));
		}
		//查询未认领
		if(filter.getScope() == 1){
			searchQueryBuilder.withFilter(QueryBuilders.termQuery("owneruid", null));
		}
		//查询我认领
		if(filter.getScope() == 2){
			searchQueryBuilder.withFilter(QueryBuilders.termQuery("owneruid", filter.getuId()));
		}
		//查询全部
		if(filter.getScope() == 3){
			
		}
		
		searchQuery = searchQueryBuilder.withSearchType(SearchType.COUNT).build();
		
        Page<BookInfoIndex> page = bookInfoRepository.search(searchQuery);
        Map<String,Object> retMap = new HashMap<String,Object>();
        Long totalCount = Long.valueOf(0);
        if(null!=page){
            totalCount = page.getTotalElements();
            List<BookInfoIndex> bookIndexList = page.getContent();
            List<AdminBookInfoDTO> bookInfoDTOList = new ArrayList<AdminBookInfoDTO>();
            if(page.getSize()>0){
                try {
                    for (BookInfoIndex bookIndex : bookIndexList) {
                    	AdminBookInfoDTO bookInfoDTO = new AdminBookInfoDTO();
                        BeanUtils.copyProperties(bookInfoDTO, bookIndex);
                        bookInfoDTOList.add(bookInfoDTO);
                    }
                }catch (Exception e){
                    log.error("拷贝对象出错",e);
                }
            }
            retMap.put("datas",bookInfoDTOList);
        }
        retMap.put("totalCount",totalCount);
        return retMap;
	}

	@Override
	public long countBookInfoFromEsForAdmin(AdminBookSearchFilter filter) {
		NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder().withIndices("shuzhai").withTypes("book");
		
		//构造全文搜索查询条件
		if(StringUtils.isNotBlank(filter.getSearchWord())){
			QueryStringQueryBuilder queryStringQueryBuilder = QueryBuilders.queryStringQuery(filter.getSearchWord())
					.field("bookName").field("isbnnum").field("bookSecname")
					.field("authorName").field("tagList").field("keyWordList");
			searchQueryBuilder.withQuery(queryStringQueryBuilder);
		}
		
		//构造过滤器
		if(filter.getTbAdminOrgId() != null){
			searchQueryBuilder.withFilter(QueryBuilders.termQuery("tbAdminOrgId", filter.getTbAdminOrgId()));
		}
		if(filter.getTbAdminDepartmentId() != null){
			searchQueryBuilder.withFilter(QueryBuilders.termQuery("tbAdminDepartmentId", filter.getTbAdminDepartmentId()));
		}
		//查询未认领
		if(filter.getScope() == 1){
			searchQueryBuilder.withFilter(QueryBuilders.termQuery("owneruid", null));
		}
		//查询我认领
		if(filter.getScope() == 2){
			searchQueryBuilder.withFilter(QueryBuilders.termQuery("owneruid", filter.getuId()));
		}
		//查询全部
		if(filter.getScope() == 3){
			
		}
		
		SearchQuery searchQuery = searchQueryBuilder.withSearchType(SearchType.COUNT).build();
		
        Page<BookInfoIndex> page = bookInfoRepository.search(searchQuery);
        System.out.println(page);
        if(null!=page){
        	return page.getTotalElements();
        }else{
        	return 0;
        }
	}


	@Override
	public void deleteBookInfoFromEs(Long bookId) {
		bookInfoRepository.delete(bookId);
	}
	
	@Override
	public void batchDeleteBookInfoFromEs(List<Long> bookIds) {
		for(Long id : bookIds){
			bookInfoRepository.delete(id);
		}
	}

}
