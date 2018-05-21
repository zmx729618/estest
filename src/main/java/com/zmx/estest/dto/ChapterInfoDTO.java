package com.zmx.estest.dto;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/** * @author  作者 duanlimin@citicpub.com: 
	* @date 创建时间：2016年6月23日 下午4:49:31 
	* @version 1.0 
*/

public class ChapterInfoDTO implements Serializable{
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
    
    private Long digestCount;
    
    private Long charlength;
    
    private StringBuffer chapterContentSB = new StringBuffer();
    
    /**
     * repeatNum:关键词出现次数
     */
    private Integer repeatNum;

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

	public Integer getRepeatNum() {
		return repeatNum;
	}

	public void setRepeatNum(Integer repeatNum) {
		this.repeatNum = repeatNum;
	}

	@Override
	public String toString() {
		return "ChapterInfoDTO [id=" + id + ", chaptername=" + chaptername + ", createtime=" + createtime
				+ ", createuid=" + createuid + ", updateuid=" + updateuid + ", updatetime=" + updatetime + ", bookid="
				+ bookid + ", chapternum=" + chapternum + ", chapterurl="
				+ chapterurl + ", digestCount=" + digestCount + ", charlength=" + charlength + "]";
	}

	public void setChapterContentSB(StringBuffer chapterContentSB) {
		this.chapterContentSB = chapterContentSB;
	}

    public StringBuffer getChapterContentSB() {
        return chapterContentSB;
    }
}

