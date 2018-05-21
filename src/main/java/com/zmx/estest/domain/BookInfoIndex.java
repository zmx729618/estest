package com.zmx.estest.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @Description： 书摘内容后台章节索引对象
 * @date: 2016年10月13日 下午3:54:22 
 * @author zhangyufeng@citicpub.com
 */
@Document(indexName = "shuzhai", type = "book",shards = 5 , replicas = 1)
public class BookInfoIndex implements Serializable{
	
	/**
	 * serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private Long id;

    /**
     * 
     */
    private String uid;

    /**
     * 书名
     */
    @Field(type = FieldType.String,index = FieldIndex.analyzed,analyzer="ik_max_word")
    private String bookName;

    /**
     * ISBN编号
     */
    private String isbnnum;

    /**
     * 图书出版日期
     */
    private String publishdate;

    /**
     * 状态（1：待审核，2：审核失败，3：上线）
     */
    private Integer status;

    /**
     * 副标题
     */
    @Field(type = FieldType.String,index = FieldIndex.analyzed,analyzer="ik_max_word")
    private String bookSecname;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private String createUser;

    /**
     * 封面
     */
    private String img;

    /**
     * 
     */
    private String updateUser;

    /**
     * 作者名称
     */
    @Field(type = FieldType.String,index = FieldIndex.analyzed,analyzer="ik_max_word")
    private String authorName;

    /**
     * 图书所属出版社ID
     */
    private Long tbAdminOrgId;

    /**
     * 图书所属部门ID
     */
    private Long tbAdminDepartmentId;

    /**
     * 拥有者id
     */
    private String owneruid;

    /**
     * 电子书id
     */
    private String ebookid;

    /**
     * 领用时间
     */
    private Date owntime;

    /**
     * 1:正常 2:删除
     */
    private Integer isDeleted;

    /**
     * 扩展备用字段
     */
    private String ext;

    /**
     * 摘要
     */
    @Field(type = FieldType.String,index = FieldIndex.analyzed,analyzer="ik_max_word")
    private String bookDigest;
    
    /**
     * searchKey:查询字符串
     */
    private String searchKey;
    

    /**
     * tagList:书籍书签列表
     */
//    @Field( type = FieldType.Nested)
    private List<String> tagList;
    
    /**
     * keyWordList:书籍关键词列表
     */
    @Field(type = FieldType.String,index = FieldIndex.analyzed,analyzer="ik_max_word")
    private List<String> keyWordList;
    
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


	/**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }


	/**
     * 
     * @return uid 
     */
    public String getUid() {
        return uid;
    }

    /**
     * 
     * @param uid 
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * 书名
     * @return book_name 书名
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 书名
     * @param bookName 书名
     */
    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    /**
     * ISBN编号
     * @return isbnnum ISBN编号
     */
    public String getIsbnnum() {
        return isbnnum;
    }

    /**
     * ISBN编号
     * @param isbnnum ISBN编号
     */
    public void setIsbnnum(String isbnnum) {
        this.isbnnum = isbnnum == null ? null : isbnnum.trim();
    }

    /**
     * 图书出版日期
     * @return publishdate 图书出版日期
     */
    public String getPublishdate() {
        return publishdate;
    }

    /**
     * 图书出版日期
     * @param publishdate 图书出版日期
     */
    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate == null ? null : publishdate.trim();
    }

    /**
     * 状态（1：待审核，2：审核失败，3：上线）
     * @return status 状态（1：待审核，2：审核失败，3：上线）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态（1：待审核，2：审核失败，3：上线）
     * @param status 状态（1：待审核，2：审核失败，3：上线）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 副标题
     * @return book_secname 副标题
     */
    public String getBookSecname() {
        return bookSecname;
    }

    /**
     * 副标题
     * @param bookSecname 副标题
     */
    public void setBookSecname(String bookSecname) {
        this.bookSecname = bookSecname == null ? null : bookSecname.trim();
    }

    public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	/**
     * 
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return update_time 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 
     * @return create_user 
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 
     * @param createUser 
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 封面
     * @return img 封面
     */
    public String getImg() {
        return img;
    }

    /**
     * 封面
     * @param img 封面
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 
     * @return update_user 
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 
     * @param updateUser 
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 作者名称
     * @return author_name 作者名称
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * 作者名称
     * @param authorName 作者名称
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    /**
     * 图书所属出版社ID
     * @return tb_admin_org_id 图书所属出版社ID
     */
    public Long getTbAdminOrgId() {
        return tbAdminOrgId;
    }

    /**
     * 图书所属出版社ID
     * @param tbAdminOrgId 图书所属出版社ID
     */
    public void setTbAdminOrgId(Long tbAdminOrgId) {
        this.tbAdminOrgId = tbAdminOrgId;
    }

    /**
     * 图书所属部门ID
     * @return tb_admin_department_id 图书所属部门ID
     */
    public Long getTbAdminDepartmentId() {
        return tbAdminDepartmentId;
    }

    /**
     * 图书所属部门ID
     * @param tbAdminDepartmentId 图书所属部门ID
     */
    public void setTbAdminDepartmentId(Long tbAdminDepartmentId) {
        this.tbAdminDepartmentId = tbAdminDepartmentId;
    }

    /**
     * 拥有者id
     * @return owneruid 拥有者id
     */
    public String getOwneruid() {
        return owneruid;
    }

    /**
     * 拥有者id
     * @param owneruid 拥有者id
     */
    public void setOwneruid(String owneruid) {
        this.owneruid = owneruid == null ? null : owneruid.trim();
    }

    /**
     * 电子书id
     * @return ebookid 电子书id
     */
    public String getEbookid() {
        return ebookid;
    }

    /**
     * 电子书id
     * @param ebookid 电子书id
     */
    public void setEbookid(String ebookid) {
        this.ebookid = ebookid == null ? null : ebookid.trim();
    }

    /**
     * 领用时间
     * @return owntime 领用时间
     */
    public Date getOwntime() {
        return owntime;
    }

    /**
     * 领用时间
     * @param owntime 领用时间
     */
    public void setOwntime(Date owntime) {
        this.owntime = owntime;
    }

    /**
     * 1:正常 2:删除
     * @return is_deleted 1:正常 2:删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 1:正常 2:删除
     * @param isDeleted 1:正常 2:删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 扩展备用字段
     * @return ext 扩展备用字段
     */
    public String getExt() {
        return ext;
    }

    /**
     * 扩展备用字段
     * @param ext 扩展备用字段
     */
    public void setExt(String ext) {
        this.ext = ext == null ? null : ext.trim();
    }

    /**
     * 摘要
     * @return book_digest 摘要
     */
    public String getBookDigest() {
        return bookDigest;
    }

    /**
     * 摘要
     * @param bookDigest 摘要
     */
    public void setBookDigest(String bookDigest) {
        this.bookDigest = bookDigest == null ? null : bookDigest.trim();
    }

}
