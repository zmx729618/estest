package com.zmx.estest.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName="index_entity", type="type_entity",shards = 5 , replicas = 1)
public class Entity implements Serializable {

	private static final long serialVersionUID = -763638353551774166L;

	@Id
	private Long id;
	
	@Field(type = FieldType.String,index = FieldIndex.analyzed,analyzer="ik_max_word")
	private String name;
	
	@Field(type = FieldType.String,index = FieldIndex.analyzed,analyzer="ik_max_word")
	private String fullName;
	
	@Field(type = FieldType.String,index = FieldIndex.analyzed,analyzer="ik_max_word")
	private String shortName;
	
	@Field(type = FieldType.String,index = FieldIndex.analyzed,analyzer="ik_max_word")
	private String abstractText;
	
	
	public Entity(){}

	public Entity(Long id, String name, String fullName, String shortName, String abstractText) {
		super();
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.shortName = shortName;
		this.abstractText = abstractText;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getAbstractText() {
		return abstractText;
	}

	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + ", fullName=" + fullName + ", shortName=" + shortName
				+ ", abstractText=" + abstractText + "]";
	}
	
	
	
	
    
	
	
	
	
}
