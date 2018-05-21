package com.zmx.estest.dto;


import java.io.Serializable;
import java.util.Date;

import com.zmx.estest.utils.JsonIgnore;


/** * @author  作者 duanlimin@citicpub.com: 
	* @date 创建时间：2016年7月9日 下午1:52:22 
	* @version 1.0 
*/
public class TagInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5799868365061101285L;

	private Long id;

    private String tagname;

    @JsonIgnore
    private Long tagratio;

    @JsonIgnore
    private Date createtime;

    @JsonIgnore
    private Date updtaetime;

    @JsonIgnore
    private String createuid;

    @JsonIgnore
    private String updateuid;
    
    @JsonIgnore
    private String backurl;
    
    private Integer ordernum;

    private Integer viewenable;
    
    private Long parentid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public Long getTagratio() {
		return tagratio;
	}

	public void setTagratio(Long tagratio) {
		this.tagratio = tagratio;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdtaetime() {
		return updtaetime;
	}

	public void setUpdtaetime(Date updtaetime) {
		this.updtaetime = updtaetime;
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

	public String getBackurl() {
		return backurl;
	}

	public void setBackurl(String backurl) {
		this.backurl = backurl;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Integer getViewenable() {
		return viewenable;
	}

	public void setViewenable(Integer viewenable) {
		this.viewenable = viewenable;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	
}

