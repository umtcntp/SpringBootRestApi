package com.spring.mvc.entity;


import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
/*
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
*/

@MappedSuperclass

public class BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date createDate;
	private String createdBy;
	private Date updateAt;
	private String updateBy;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	

}
