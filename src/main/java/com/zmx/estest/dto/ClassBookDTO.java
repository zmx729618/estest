package com.zmx.estest.dto;

import java.io.Serializable;

public class ClassBookDTO implements Serializable {

	/**
	 * serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 2360226768557421320L;

	private Long id;

	private Long bookId;

	private String bookName;

	private String bookCover;

	private String bookAuthor;

	private String bookDigest;
	
	private Long goodsID;
	
	private Integer isDeleted;
	
	private Long claId;
	
	private Integer isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCover() {
		return bookCover;
	}

	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookDigest() {
		return bookDigest;
	}

	public void setBookDigest(String bookDigest) {
		this.bookDigest = bookDigest;
	}

	public Long getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(Long goodsID) {
		this.goodsID = goodsID;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getClaId() {
		return claId;
	}

	public void setClaId(Long claId) {
		this.claId = claId;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	
}

