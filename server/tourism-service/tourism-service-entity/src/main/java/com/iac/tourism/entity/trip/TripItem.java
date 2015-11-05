package com.iac.tourism.entity.trip;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import com.iac.tourism.entity.IdEntity;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * * 行程清单
 */
@Entity
@Table(name = "c_trip_item")
public class TripItem extends IdEntity {
	
	private static final long serialVersionUID = -6381436063159003579L;
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 行程       db_column: trip 
     */ 	
	private Trip trip;
    /**
     * 景点       db_column: view_spot 
     */ 	
	private ViewSpot viewSpot;
    /**
     * sort       db_column: sort 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer sort;
    /**
     * 行程日期       db_column: trip_date 
     */ 	
	private java.util.Date tripDate;
    /**
     * 类型 1 景点 2 酒店 3 饭店       db_column: type 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer type;
	//columns END

	@Column(name = "sort")
	public java.lang.Integer getSort() {
		return this.sort;
	}
	
	public void setSort(java.lang.Integer value) {
		this.sort = value;
	}
	
	@Column(name = "trip_date")
	public java.util.Date getTripDate() {
		return this.tripDate;
	}
	
	public void setTripDate(java.util.Date value) {
		this.tripDate = value;
	}
	
	@Column(name = "type")
	public java.lang.Integer getType() {
		return this.type;
	}
	
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	
	public void setTrip(Trip trip){
		this.trip = trip;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "trip") 
	})
	public Trip getTrip() {
		return trip;
	}
	
	public void setViewSpot(ViewSpot viewSpot){
		this.viewSpot = viewSpot;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "view_spot") 
	})
	public ViewSpot getViewSpot() {
		return viewSpot;
	}
}

