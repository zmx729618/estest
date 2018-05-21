package com.zmx.estest.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.zmx.estest.domain.BookInfoIndex;



/**
 * @Description： 书摘后台：书籍相关搜索ES接口
 * @date: 2016年10月13日 下午4:00:55 
 * @author zhangyufeng@citicpub.com
 */
@Repository
public interface BookInfoRepository extends ElasticsearchRepository<BookInfoIndex,Long> {

    /**
     * @desccroption:根据关键词或短语查询书籍信息
     * @date: 2016年10月13日 下午4:03:08
     * @author:zhangyufeng@citicpub.com
     * @param searchKey
     * @return
     * List<ChapterInfoIndex>
     */
    public List<BookInfoIndex> findBySearchKey(String searchKey);
    
    /**
     * @desccroption:根据ID删除书籍信息
     * @date: 2016年10月13日 下午4:03:31
     * @author:zhangyufeng@citicpub.com
     * @param Id
     * @return
     * Long
     */
    public Long deleteById(Long Id);

}
