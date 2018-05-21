package com.zmx.estest.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * @Description：书摘后台书籍相关数据传输对象
 * @date: 2016年9月12日 下午3:11:05 
 * @author zhangyufeng@citicpub.com
 */
public class AdminBookInfoDTO implements Serializable {

    /**
	 * serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	/**
	 * bid:书籍ID别名
	 */
	private Long bid;
	
	/**
	 * bookFilesId:TbBookFiles表ID
	 */
	private Long bookFilesId;
	
    private String uid;

    private String bookName;

    private String isbnnum;

    private String publishdate;

    private Integer status;

    private String bookSecname;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String img;

    private String updateUser;

    private String authorName;

    private String owneruid;

    private String ebookid;

    private Date owntime;

    private String bookDigest;
    
    /**
     * coverImgUrl:图书封面全路径
     */
    private String coverImgUrl;
    
    /**
     * 图书所属出版社ID
     */
    private Long tbAdminOrgId;

    /**
     * 图书所属部门ID
     */
    private Long tbAdminDepartmentId;
    
    /**
     * 1:正常 2:删除
     */
    private Integer isDeleted;
    
    /**
     * ownerName:书籍的当前认领者
     */
    private String ownerName;
    
    /**
     * tagList:书籍书签列表
     */
    private List<String> tagList;
    

    
    /**
     * keyWordList:书籍关键词列表
     */
    private List<String> keyWordList;
    
    
    /**
     * chapterList:章节列表
     */
    private List<AdminChapterInfoDTO> chapterList;
    
    /**
     * digestCount:电子书书摘数量
     */
    private Long digestCount;
    
    /**
     * likeCount:喜欢收藏数量
     */
    private Long likeCount;
    
    /**
     * commentCount:评论数量
     */
    private Long commentCount;
    
    /**
     * bookAudioList:音频资源列表
     */
    private List<Map<String,Object>> bookAudioList;
    
    /**
     * bookVideoList:视频资源列表
     */
    private List<Map<String,Object>> bookVideoList;
    
    /**
     * bookClubList:读书会资源列表
     */
    private List<Map<String,Object>> bookClubList;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookFilesId() {
		return bookFilesId;
	}

	public void setBookFilesId(Long bookFilesId) {
		this.bookFilesId = bookFilesId;
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
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

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getIsbnnum() {
        return isbnnum;
    }

    public void setIsbnnum(String isbnnum) {
        this.isbnnum = isbnnum == null ? null : isbnnum.trim();
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate == null ? null : publishdate.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBookSecname() {
        return bookSecname;
    }

    public void setBookSecname(String bookSecname) {
        this.bookSecname = bookSecname == null ? null : bookSecname.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getOwneruid() {
        return owneruid;
    }

    public void setOwneruid(String owneruid) {
        this.owneruid = owneruid == null ? null : owneruid.trim();
    }

    public String getEbookid() {
        return ebookid;
    }

    public void setEbookid(String ebookid) {
        this.ebookid = ebookid == null ? null : ebookid.trim();
    }

    public Date getOwntime() {
        return owntime;
    }

    public void setOwntime(Date owntime) {
        this.owntime = owntime;
    }

    public String getBookDigest() {
        return bookDigest;
    }

    public void setBookDigest(String bookDigest) {
        this.bookDigest = bookDigest == null ? null : bookDigest.trim();
    }

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public List<String> getTagList() {
		return tagList;
	}

	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}

	public List<String> getKeyWordList() {
		return keyWordList;
	}

	public void setKeyWordList(List<String> keyWordList) {
		this.keyWordList = keyWordList;
	}

	public List<AdminChapterInfoDTO> getChapterList() {
		return chapterList;
	}

	public void setChapterList(List<AdminChapterInfoDTO> chapterList) {
		this.chapterList = chapterList;
	}

	public Long getDigestCount() {
		return digestCount;
	}

	public void setDigestCount(Long digestCount) {
		this.digestCount = digestCount;
	}



	public Long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public String getCoverImgUrl() {
		return coverImgUrl;
	}

	public void setCoverImgUrl(String coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
	}


	public List<Map<String, Object>> getBookAudioList() {
		return bookAudioList;
	}

	public void setBookAudioList(List<Map<String, Object>> bookAudioList) {
		this.bookAudioList = bookAudioList;
	}

	public List<Map<String, Object>> getBookVideoList() {
		return bookVideoList;
	}

	public void setBookVideoList(List<Map<String, Object>> bookVideoList) {
		this.bookVideoList = bookVideoList;
	}

	public List<Map<String, Object>> getBookClubList() {
		return bookClubList;
	}

	public void setBookClubList(List<Map<String, Object>> bookClubList) {
		this.bookClubList = bookClubList;
	}

	@Override
	public String toString() {
		return "AdminBookInfoDTO [id=" + id + ", bid=" + bid + ", uid=" + uid + ", bookName=" + bookName + ", isbnnum="
				+ isbnnum + ", publishdate=" + publishdate + ", status=" + status + ", bookSecname=" + bookSecname
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", createUser=" + createUser + ", img="
				+ img + ", updateUser=" + updateUser + ", authorName=" + authorName + ", owneruid=" + owneruid
				+ ", ebookid=" + ebookid + ", owntime=" + owntime + ", bookDigest=" + bookDigest + ", coverImgUrl="
				+ coverImgUrl + ", tbAdminOrgId=" + tbAdminOrgId + ", tbAdminDepartmentId=" + tbAdminDepartmentId
				+ ", isDeleted=" + isDeleted + ", ownerName=" + ownerName + ", tagList=" + tagList 
				+ ", keyWordList=" + keyWordList + ", chapterList=" + chapterList
				+ ", digestCount=" + digestCount + ", likeCount=" + likeCount + ", commentCount=" + commentCount
				+ "]";
	}

}

