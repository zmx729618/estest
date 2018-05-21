package com.zmx.estest.service;


import java.util.List;
import java.util.Map;

import com.zmx.estest.dto.AdminBookInfoDTO;
import com.zmx.estest.dto.AdminBookSearchFilter;
import com.zmx.estest.dto.BookInfoDTO;

/**
 * @Description： 书摘后台：书籍书籍相关搜索数据接口
 * @date: 2016年9月30日 下午1:52:06 
 * @author zhangyufeng@citicpub.com
 */
public interface BookInfoElasticService {
	
	/**
	 * @desccroption:添加书籍信息到ES
	 * @date: 2016年10月13日 下午4:14:11
	 * @author:zhangyufeng@citicpub.com
	 * @param bookDto
	 * void
	 */
	void loadBookInfo2Es(AdminBookInfoDTO bookDto);
	/**
	 * @desccroption:批量添加书籍信息到ES
	 * @date: 2016年10月13日 下午4:53:55
	 * @author:zhangyufeng@citicpub.com
	 * void
	 */
	void loadBookInfoList2Es(List<BookInfoDTO> bookDto);
	
	/**
	 * @desccroption:根据关键词查询书籍信息
	 * @date: 2016年10月13日 下午4:58:05
	 * @author:zhangyufeng@citicpub.com
	 * @param searchKeys
	 * @param offset
	 * @param pageSize
	 * @return
	 * Map<String,Object>
	 */
	Map<String,Object> searchBookInfoFromEs(String searchKeys,long offset, long pageSize);
	
	/**
	 * @desccroption:后台管理系统根据关键词分页查询书籍列表
	 * @date: 2016年11月18日 上午11:36:35
	 * @author:zhangyufeng@citicpub.com
	 * @param searchKeys
	 * @param offset
	 * @param pageSize
	 * @return
	 * Map<String,Object>
	 */
	Map<String,Object> searchBookInfoFromEsForAdmin(AdminBookSearchFilter filter,long offset, long pageSize);
	
	/**
	 * @desccroption:后台管理系统根据关键词分页查询书籍总数
	 * @date: 2016年11月18日 上午11:36:35
	 * @author:zhangyufeng@citicpub.com
	 * @param filter
	 * @return
	 * long
	 */
	long countBookInfoFromEsForAdmin(AdminBookSearchFilter filter);
	
	/**
	 * @desccroption:根据bookId从Es删除
	 * @date: 2016年11月17日 下午7:12:54
	 * @author:zhangyufeng@citicpub.com
	 * @param bookId
	 * void
	 */
	void deleteBookInfoFromEs(Long bookId);
	
	/**
	 * @desccroption:根据bookIds从Es批量删除
	 * @date: 2016年11月17日 下午7:12:54
	 * @author:zhangyufeng@citicpub.com
	 * @param bookIds
	 * void
	 */
	void batchDeleteBookInfoFromEs(List<Long> bookIds);
}
