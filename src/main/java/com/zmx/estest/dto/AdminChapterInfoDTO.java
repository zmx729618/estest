package com.zmx.estest.dto;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description： 章节信息数据传输对象
 * @date: 2016年9月26日 下午6:12:25 
 * @author zhangyufeng@citicpub.com
 */
public class AdminChapterInfoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9006792568185846421L;
	
	private Long id;

    private String chaptername;

    private Date createtime;

    private String createuid;

    private String updateuid;

    private Date updatetime;

    private Long bookid;

    private Integer chapternum;

    private String chaptercontent;
    
    private String chapterurl;
    
    /**
     * digestCount:书摘数量
     */
    private Long digestCount;
    

    
    /**
     * keyWordList:章节关键词列表
     */
    private List<String> keyWordList;
    
    
    public List<String> getKeyWordList() {
		return keyWordList;
	}

	public void setKeyWordList(List<String> keyWordList) {
		this.keyWordList = keyWordList;
	}

	private Long charlength;
    
    public StringBuffer chapterContentSB = new StringBuffer();
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChaptername() {
		return chaptername;
	}

	public void setChaptername(String chaptername) {
		this.chaptername = chaptername;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreateuid() {
		return createuid;
	}

	public void setCreateuid(String createuid) {
		this.createuid = createuid;
	}

	public String getUpdateuid() {
		return updateuid;
	}

	public void setUpdateuid(String updateuid) {
		this.updateuid = updateuid;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public Integer getChapternum() {
		return chapternum;
	}

	public void setChapternum(Integer chapternum) {
		this.chapternum = chapternum;
	}

	public String getChaptercontent() {
		if(null==chaptercontent && StringUtils.isNotBlank(chapterContentSB.toString())){
			this.chaptercontent = chapterContentSB.toString();
		}
		return chaptercontent;
	}

	public void setChaptercontent(String chaptercontent) {
		this.chaptercontent = chaptercontent;
	}

	public Long getDigestCount() {
		return digestCount;
	}

	public void setDigestCount(Long digestCount) {
		this.digestCount = digestCount;
	}

	public String getChapterurl() {
		return chapterurl;
	}

	public void setChapterurl(String chapterurl) {
		this.chapterurl = chapterurl;
	}

	public Long getCharlength() {
		return charlength;
	}

	public void setCharlength(Long charlength) {
		this.charlength = charlength;
	}


	
	public StringBuffer getChapterContentSB() {
		return chapterContentSB;
	}

	public void setChapterContentSB(StringBuffer chapterContentSB) {
		this.chapterContentSB = chapterContentSB;
	}

	@Override
	public String toString() {
		return "AdminChapterInfoDTO [id=" + id + ", chaptername=" + chaptername + ", createtime=" + createtime
				+ ", createuid=" + createuid + ", updateuid=" + updateuid + ", updatetime=" + updatetime + ", bookid="
				+ bookid + ", chapternum=" + chapternum + ", chaptercontent=" + chaptercontent + ", chapterurl="
				+ chapterurl + ", digestCount=" + digestCount 
				+ ", keyWordList=" + keyWordList + ", charlength=" + charlength + ", chapterContentSB="
				+ chapterContentSB + "]";
	}
	
}

