package com.iac.tourism.entity;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Listener - 创建日期、修改日期处理
 * 
 */
public class EntityListener {

	@PrePersist
	public void prePersist(IdEntity entity) {
		if(entity.getCreated() == null)
			entity.setCreated(new Date());
		
		if(entity.getModified() == null)
			entity.setModified(new Date());
	}

	@PreUpdate
	public void preUpdate(IdEntity entity) {
		entity.setModified(new Date());
	}

}