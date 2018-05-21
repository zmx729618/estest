package com.zmx.estest.dto;


import java.io.Serializable;

/**
 * @Description： 后台书籍列表数据传输对象
 * @date: 2016年9月8日 下午6:31:56 
 * @author zhangyufeng@citicpub.com
 */
public class AdminBookSearchFilter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1844229840276324280L;
	
	/**
	 * uId:当前登录用户ID
	 */
	private String uId;
	
	/**
	 * pageIndex:前台请求的当前页码数
	 */
	private Long pageIndex;
	
	/**
	 * offSet:分页偏移量
	 */
	private Long offSet;
	
	/**
	 * pageSize:单页数量
	 */
	private Long pageSize;

    /**
     * filename:书籍文件名
     */
    private String filename;
    
    /**
     * searchWord:查询字符串
     */
    private String searchWord;
    
    /**
	 * sortedFlag:排序标识 1：asc 正续  2:desc 倒叙
	 */
    private Byte sortedFlag;
    
    /**
     * 所属机构ID
     */
    private Long tbAdminOrgId;

    /**
     * 所属部门ID
     */
    private Long tbAdminDepartmentId;
    
    /**
     * scope:查询范围 1:未认领 2:我认领 3:全部
     */
    private Byte scope;
    
    /**
     * bookId:电子书ID
     */
    private Long bookId;
    
    /**
	 * courseId:课程ID
	 */
	private Long courseId;
    
    /**
     * bookName:电子书名称
     */
    private String bookName;
    
    /**
     * chapterId:章节ID
     */
    private Long chapterId;
	
	/**
	 * digestId:书摘ID
	 */
	private Long digestId;
    
    public Byte getTabType() {
		return tabType;
	}

	public void setTabType(Byte tabType) {
		this.tabType = tabType;
	}

	/**
	 * tabType:书籍页面tab类型  解析中:1  解析失败:2
	 */
	private Byte tabType;


	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public Long getTbAdminOrgId() {
		return tbAdminOrgId;
	}

	public void setTbAdminOrgId(Long tbAdminOrgId) {
		this.tbAdminOrgId = tbAdminOrgId;
	}

	public Long getTbAdminDepartmentId() {
		return tbAdminDepartmentId;
	}

	public void setTbAdminDepartmentId(Long tbAdminDepartmentId) {
		this.tbAdminDepartmentId = tbAdminDepartmentId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getOffSet() {
		return offSet;
	}

	public void setOffSet(Long offSet) {
		this.offSet = offSet;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public Byte getScope() {
		return scope;
	}

	public void setScope(Byte scope) {
		this.scope = scope;
	}

	public Byte getSortedFlag() {
		return sortedFlag;
	}

	public void setSortedFlag(Byte sortedFlag) {
		this.sortedFlag = sortedFlag;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}

	public Long getDigestId() {
		return digestId;
	}

	public void setDigestId(Long digestId) {
		this.digestId = digestId;
	}

	public Long getPageIndex() {
		return pageIndex;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "AdminBookSearchFilter [uId=" + uId + ", pageIndex=" + pageIndex + ", offSet=" + offSet + ", pageSize="
				+ pageSize + ", filename=" + filename + ", searchWord=" + searchWord + ", sortedFlag=" + sortedFlag
				+ ", tbAdminOrgId=" + tbAdminOrgId + ", tbAdminDepartmentId=" + tbAdminDepartmentId + ", scope=" + scope
				+ ", bookId=" + bookId + ", bookName=" + bookName + ", chapterId=" + chapterId + ", digestId="
				+ digestId + ", tabType=" + tabType + "]";
	}

	public String generateCacheKey(){
		return "bookListCahceKey:" + uId + ":" + scope + ":" + sortedFlag + ":" + searchWord + ":" + pageIndex + ":" + pageSize;
	}
}
