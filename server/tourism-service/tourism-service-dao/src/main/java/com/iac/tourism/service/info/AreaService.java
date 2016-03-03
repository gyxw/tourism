package com.iac.tourism.service.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.iac.tourism.entity.info.Area;
import com.iac.tourism.repository.BasicRepository;
import com.iac.tourism.repository.info.AreaDao;
import com.iac.tourism.service.BasicService;


@Component
@Transactional
public class AreaService extends BasicService<Area,java.lang.Long> {

	@Autowired
	private AreaDao areaDao;
	
	@Override
	public BasicRepository<Area,java.lang.Long> getRepository() {
		return areaDao;
	}
}
