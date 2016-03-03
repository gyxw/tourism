package com.iac.tourism.entity.trip;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.iac.tourism.entity.IdEntity;
import com.iac.tourism.entity.info.Area;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * * 旅游景点
 */
@Entity
@Table(name = "c_view_spot")
@XmlRootElement(name="viewSpot")
@XmlAccessorType(XmlAccessType.FIELD)
public class ViewSpot extends IdEntity {
	
	private static final long serialVersionUID = -8899148435675407830L;
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 景点名       db_column: name 
     */ 	
	@Length(max=255)
	private java.lang.String name;
    /**
     * picture       db_column: picture 
     */ 	
	@Length(max=255)
	private java.lang.String picture;
    /**
     * area       db_column: area 
     */ 	
	@NotNull
	private Area area;
    /**
     * title       db_column: title 
     */ 	
	@NotBlank @Length(max=50)
	private java.lang.String title;
    /**
     * description       db_column: description 
     */ 	
	@Length(max=255)
	private java.lang.String description;
    /**
     * parent       db_column: parent 
     */ 	
	@Max(9223372036854775807L)
	private java.lang.Long parent;
    /**
     * 点击数（热度）       db_column: clicked 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer clicked;
    /**
     * 星级（名气）       db_column: star 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer star;
    /**
     * 经度       db_column: longitude 
     */ 	
	private java.lang.Float longitude;
    /**
     * 纬度       db_column: latitude 
     */ 	
	private java.lang.Float latitude;
    /**
     * 可参观开始时间       db_column: visit_start_time 
     */ 	
	private java.util.Date visitStartTime;
    /**
     * 可参观截止时间       db_column: visit_end_time 
     */ 	
	private java.util.Date visitEndTime;
	//columns END

	@Column(name = "name")
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	@Column(name = "picture")
	public java.lang.String getPicture() {
		return this.picture;
	}
	
	public void setPicture(java.lang.String value) {
		this.picture = value;
	}
	
	@Column(name = "title")
	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	@Column(name = "description")
	public java.lang.String getDescription() {
		return this.description;
	}
	
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	
	@Column(name = "parent")
	public java.lang.Long getParent() {
		return this.parent;
	}
	
	public void setParent(java.lang.Long value) {
		this.parent = value;
	}
	
	@Column(name = "clicked")
	public java.lang.Integer getClicked() {
		return this.clicked;
	}
	
	public void setClicked(java.lang.Integer value) {
		this.clicked = value;
	}
	
	@Column(name = "star")
	public java.lang.Integer getStar() {
		return this.star;
	}
	
	public void setStar(java.lang.Integer value) {
		this.star = value;
	}
	
	@Column(name = "longitude")
	public java.lang.Float getLongitude() {
		return this.longitude;
	}
	
	public void setLongitude(java.lang.Float value) {
		this.longitude = value;
	}
	
	@Column(name = "latitude")
	public java.lang.Float getLatitude() {
		return this.latitude;
	}
	
	public void setLatitude(java.lang.Float value) {
		this.latitude = value;
	}
	
	@Column(name = "visit_start_time")
	public java.util.Date getVisitStartTime() {
		return this.visitStartTime;
	}
	
	public void setVisitStartTime(java.util.Date value) {
		this.visitStartTime = value;
	}
	
	@Column(name = "visit_end_time")
	public java.util.Date getVisitEndTime() {
		return this.visitEndTime;
	}
	
	public void setVisitEndTime(java.util.Date value) {
		this.visitEndTime = value;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "area") 
	})
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
}

