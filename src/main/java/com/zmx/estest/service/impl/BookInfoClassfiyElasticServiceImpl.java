package com.zmx.estest.service.impl;

import java.util.ArrayList;
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

import com.zmx.estest.dao.CommonClassfiyBookRepository;
import com.zmx.estest.dao.CustomeClassfiyBookRepository;
import com.zmx.estest.domain.CommonBookIndex;
import com.zmx.estest.domain.CustomeBookIndex;
import com.zmx.estest.dto.ClassBookDTO;
import com.zmx.estest.service.BookInfoClassfiyElasticService;


@Service
public class BookInfoClassfiyElasticServiceImpl extends BaseService implements BookInfoClassfiyElasticService {

	@Autowired
	private CommonClassfiyBookRepository commonClassfiyBookRepository;

	@Autowired
	private CustomeClassfiyBookRepository customeClassfiyBookRepository;

	@Override
	public void loadCommonClassifyBook2ES(List<ClassBookDTO> classifyBookList) {

		if (null != classifyBookList && classifyBookList.size() > 0) {
			for (ClassBookDTO classBookDTO : classifyBookList) {
				if (classBookDTO.getIsDeleted() == 1 && classBookDTO.getIsDelete() == 0) {
					this.LoadCommonClassifyBook2ES(classBookDTO);
				} else {
					this.delCommonClassifyBook2ES(classBookDTO.getId());
				}
			}
		}
	}

	public void LoadCommonClassifyBook2ES(ClassBookDTO classBookDTO) {
		try {
			CommonBookIndex index = new CommonBookIndex();
			index.setId(classBookDTO.getId());
			index.setBookName(classBookDTO.getBookName());
			index.setBookAuthor(classBookDTO.getBookAuthor());
			index.setBookCover(classBookDTO.getBookCover());
			index.setBookDigest(classBookDTO.getBookDigest());
			index.setBookId(classBookDTO.getBookId());
			index.setClaId(classBookDTO.getClaId().toString());
			commonClassfiyBookRepository.save(index);
		} catch (Exception e) {
			log.error("保存常规分类书籍信息进es出错", e);
		}
	}

	public void delCommonClassifyBook2ES(Long id) {
		commonClassfiyBookRepository.delete(id);
	}

	public void LoadCustomeClassifyBook2ES(ClassBookDTO classBookDTO) {
		try {
			CustomeBookIndex index = new CustomeBookIndex();
			index.setId(classBookDTO.getId());
			index.setBookName(classBookDTO.getBookName());
			index.setBookAuthor(classBookDTO.getBookAuthor());
			index.setBookCover(classBookDTO.getBookCover());
			index.setBookDigest(classBookDTO.getBookDigest());
			index.setBookId(classBookDTO.getBookId());
			index.setClaId(classBookDTO.getClaId().toString());
			customeClassfiyBookRepository.save(index);
		} catch (Exception e) {
			log.error("保存自定义分类书籍信息进ES出错", e);
		}
	}

	public void delCustomeClassifyBook2Es(Long id) {
		customeClassfiyBookRepository.delete(id);
	}

	@Override
	public void loadCustomeClassifyBook2ES(List<ClassBookDTO> classifyBookList) {
		if (null != classifyBookList && classifyBookList.size() > 0) {
			for (ClassBookDTO classBookDTO : classifyBookList) {
				if (classBookDTO.getIsDeleted() == 1 && classBookDTO.getIsDelete() == 0) {
					this.LoadCustomeClassifyBook2ES(classBookDTO);
				} else {
					this.delCustomeClassifyBook2Es(classBookDTO.getId());
				}
			}
		}

	}

	@Override
	public List<ClassBookDTO> searchCommonClassifyBook(String keyWord, String claId, Long offset, Long pageSize) {
		Pageable pageable = new PageRequest(Long.valueOf(offset).intValue(), Long.valueOf(pageSize).intValue());
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("claId", claId))
						.must(QueryBuilders.multiMatchQuery(keyWord, "bookName^2", "bookAuthor", "bookDigest")
								.type(MultiMatchQueryBuilder.Type.BEST_FIELDS)))
				.withIndices("zxsy").withTypes("common").withSort(SortBuilders.scoreSort()).withPageable(pageable)
				.build();
		Page<CommonBookIndex> page = commonClassfiyBookRepository.search(searchQuery);
		if (null != page) {
			List<CommonBookIndex> commonBookIndexList = page.getContent();
			List<ClassBookDTO> retList = new ArrayList<ClassBookDTO>();
			if (page.getSize() > 0) {
				try {
					for (CommonBookIndex commonBookIndex : commonBookIndexList) {
						ClassBookDTO retDto = new ClassBookDTO();
						retDto.setId(commonBookIndex.getId());
						retDto.setBookAuthor(commonBookIndex.getBookAuthor());
						retDto.setBookCover(commonBookIndex.getBookCover());
						retDto.setBookDigest(commonBookIndex.getBookDigest());
						retDto.setBookId(commonBookIndex.getBookId());
						retDto.setBookName(commonBookIndex.getBookName());
						retDto.setClaId(Long.valueOf(commonBookIndex.getClaId()));
						retList.add(retDto);
					}
				} catch (Exception e) {
					log.error("拷贝对象出错", e);
				}
			}
			return retList;
		}
		return null;
	}

	@Override
	public List<ClassBookDTO> searchCustomClassifyBook(String keyWord, String claId, Long offset, Long pageSize) {
		Pageable pageable = new PageRequest(Long.valueOf(offset).intValue(), Long.valueOf(pageSize).intValue());
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("claId", claId))
						.must(QueryBuilders.multiMatchQuery(keyWord, "bookName^2", "bookAuthor", "bookDigest")
								.type(MultiMatchQueryBuilder.Type.BEST_FIELDS)))
				.withIndices("zxsy").withTypes("custome").withSort(SortBuilders.scoreSort()).withPageable(pageable)
				.build();
		Page<CustomeBookIndex> page = customeClassfiyBookRepository.search(searchQuery);
		if (null != page) {
			List<CustomeBookIndex> customeBookIndexList = page.getContent();
			List<ClassBookDTO> retList = new ArrayList<ClassBookDTO>();
			if (page.getSize() > 0) {
				try {
					for (CustomeBookIndex customeBookIndex : customeBookIndexList) {
						ClassBookDTO retDto = new ClassBookDTO();
						retDto.setId(customeBookIndex.getId());
						retDto.setBookAuthor(customeBookIndex.getBookAuthor());
						retDto.setBookCover(customeBookIndex.getBookCover());
						retDto.setBookDigest(customeBookIndex.getBookDigest());
						retDto.setBookId(customeBookIndex.getBookId());
						retDto.setBookName(customeBookIndex.getBookName());
						retDto.setClaId(Long.valueOf(customeBookIndex.getClaId()));
						retList.add(retDto);
					}
				} catch (Exception e) {
					log.error("拷贝对象出错", e);
				}
			}
			return retList;
		}
		return null;
	}

}
