package com.iac.tourism.entity.trip;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.iac.tourism.entity.IdEntity;
import com.iac.tourism.entity.user.User;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * * 行程
 */
@Entity
@Table(name = "c_trip")
public class Trip extends IdEntity {
	
	private static final long serialVersionUID = -6123652781818397815L;
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 行程开始日期       db_column: start_date 
     */ 	
	private java.util.Date startDate;
    /**
     * 行程结束日期       db_column: end_date 
     */ 	
	private java.util.Date endDate;
    /**
     * user       db_column: user 
     */ 	
	private User user;
	//columns END

	@Column(name = "start_date")
	public java.util.Date getStartDate() {
		return this.startDate;
	}
	
	public void setStartDate(java.util.Date value) {
		this.startDate = value;
	}
	
	@Column(name = "end_date")
	public java.util.Date getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(java.util.Date value) {
		this.endDate = value;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "user") 
	})
	public User getUser() {
		return user;
	}
}

