package com.zmx.estest.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "zxsy", type = "common",shards = 5 , replicas = 1)
public class CommonBookIndex implements Serializable {

	/**
	 * serialVersionUID:TODO
	 */
	private static final long serialVersionUID = -1561082695325558504L;

	@Id
    @Field(type = FieldType.Long,index = FieldIndex.not_analyzed)
	private Long id;

    @Field(type = FieldType.Long,index = FieldIndex.not_analyzed)
	private Long bookId;
	
    @Field(type = FieldType.String,index = FieldIndex.analyzed,analyzer="ik_max_word")
	private String bookName;

    @Field(type = FieldType.String,index = FieldIndex.not_analyzed)
	private String bookCover;
	
    @Field(type = FieldType.String,index = FieldIndex.analyzed,analyzer="ik_max_word")
	private String bookAuthor;
	
    @Field(type = FieldType.String,index = FieldIndex.analyzed,analyzer="ik_max_word")
	private String bookDigest;
	
	@Field(type = FieldType.String,index = FieldIndex.not_analyzed)
	private String claId;
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
	public String getClaId() {
		return claId;
	}
	public void setClaId(String claId) {
		this.claId = claId;
	}
	
    
    
    
}
