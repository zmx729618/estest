package com.zmx.estest.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * * @author 作者 duanlimin@citicpub.com:
 * 
 * @date 创建时间：2016年6月23日 上午10:41:01
 * @version 1.0
 */
public class BookInfoDTO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -2836996036816426287L;

	private Long id;

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
    
    private List<Long> tagInfos;
    
    private List<String> tagNames;
    
    private Long digestCount;

	private List<ChapterInfoDTO> chapterInfoDTOList = new ArrayList<ChapterInfoDTO>();
	
	private List<TagInfoDTO> tagInfoDTOList;
	
	
	/**
	 * parseResult:解析成功失败标志 0:文件名重复 1：epub格式不正确
	 */
	private Integer parseResult;
	
	public Integer getParseResult() {
		return parseResult;
	}

	public void setParseResult(Integer parseResult) {
		this.parseResult = parseResult;
	}

	public List<TagInfoDTO> getTagInfoDTOList() {
		return tagInfoDTOList;
	}

	public void setTagInfoDTOList(List<TagInfoDTO> tagInfoDTOList) {
		this.tagInfoDTOList = tagInfoDTOList;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
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

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getIsbnnum() {
		return isbnnum;
	}

	public void setIsbnnum(String isbnnum) {
		this.isbnnum = isbnnum;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
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
		this.bookSecname = bookSecname;
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
		this.createUser = createUser;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBookDigest() {
		return bookDigest;
	}

	public void setBookDigest(String bookDigest) {
		this.bookDigest = bookDigest;
	}

	public List<Long> getTagInfos() {
		return tagInfos;
	}

	public void setTagInfos(List<Long> tagInfos) {
		this.tagInfos = tagInfos;
	}

	public List<ChapterInfoDTO> getChapterInfoDTOList() {
		return chapterInfoDTOList;
	}

	public void setChapterInfoDTOList(List<ChapterInfoDTO> chapterInfoDTOList) {
		this.chapterInfoDTOList = chapterInfoDTOList;
	}

	public Long getDigestCount() {
		return digestCount;
	}

	public void setDigestCount(Long digestCount) {
		this.digestCount = digestCount;
	}

	public String getOwneruid() {
		return owneruid;
	}

	public void setOwneruid(String owneruid) {
		this.owneruid = owneruid;
	}

	public String getEbookid() {
		return ebookid;
	}

	public void setEbookid(String ebookid) {
		this.ebookid = ebookid;
	}

	public Date getOwntime() {
		return owntime;
	}

	public void setOwntime(Date owntime) {
		this.owntime = owntime;
	}

	public List<String> getTagNames() {
		return tagNames;
	}

	public void setTagNames(List<String> tagNames) {
		this.tagNames = tagNames;
	}

	@Override
	public String toString() {
		return "BookInfoDTO [id=" + id + ", uid=" + uid + ", bookName=" + bookName + ", isbnnum=" + isbnnum
				+ ", publishdate=" + publishdate + ", status=" + status + ", bookSecname=" + bookSecname
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", createUser=" + createUser + ", img="
				+ img + ", updateUser=" + updateUser + ", authorName=" + authorName + ", owneruid=" + owneruid
				+ ", ebookid=" + ebookid + ", owntime=" + owntime + ", bookDigest=" + bookDigest + ", tagInfos="
				+ tagInfos + ", tagNames=" + tagNames + ", digestCount=" + digestCount + ", chapterInfoDTOList="
				+ chapterInfoDTOList + "]";
	}
	
}

