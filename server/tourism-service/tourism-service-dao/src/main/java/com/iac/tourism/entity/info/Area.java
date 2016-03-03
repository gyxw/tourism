package com.iac.tourism.entity.info;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.iac.tourism.entity.IdEntity;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * * Area
 */
@Entity
@Table(name = "c_area")
@XmlRootElement(name="area")
@XmlAccessorType(XmlAccessType.FIELD)
public class Area extends IdEntity {
	

	private static final long serialVersionUID = 742616702075466667L;
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * name       db_column: name 
     */ 	
	@NotBlank @Length(max=100)
	private java.lang.String name;
    /**
     * fullName       db_column: full_name 
     */ 	
	@NotBlank
	private java.lang.String fullName;
    /**
     * 排序 越大优先级越高       db_column: sort 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer sort;
    /**
     * parent       db_column: parent 
     */ 	
	@Max(9223372036854775807L)
	private java.lang.Long parent;
    /**
     * 树路径 db_column: tree_path 
     */ 	
	@Length(max=255)
	private java.lang.String treePath;
    /**
     * 关于旅游城市的描述       db_column: description 
     */ 	
	@Length(max=255)
	private java.lang.String description;
    /**
     * 星级， 达到固定星级的应该在默认选择页面上 出现热门城市       db_column: star 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer star;
	//columns END

	@Column(name = "name")
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	@Column(name = "full_name")
	public java.lang.String getFullName() {
		return this.fullName;
	}
	
	public void setFullName(java.lang.String value) {
		this.fullName = value;
	}
	
	@Column(name = "sort")
	public java.lang.Integer getSort() {
		return this.sort;
	}
	
	public void setSort(java.lang.Integer value) {
		this.sort = value;
	}
	
	@Column(name = "parent")
	public java.lang.Long getParent() {
		return this.parent;
	}
	
	public void setParent(java.lang.Long value) {
		this.parent = value;
	}
	
	@Column(name = "tree_path")
	public java.lang.String getTreePath() {
		return this.treePath;
	}
	
	public void setTreePath(java.lang.String value) {
		this.treePath = value;
	}
	
	@Column(name = "description")
	public java.lang.String getDescription() {
		return this.description;
	}
	
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	
	@Column(name = "star")
	public java.lang.Integer getStar() {
		return this.star;
	}
	
	public void setStar(java.lang.Integer value) {
		this.star = value;
	}
}

