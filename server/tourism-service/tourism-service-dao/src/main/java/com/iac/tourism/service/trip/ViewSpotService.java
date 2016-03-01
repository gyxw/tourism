package com.iac.tourism.service.trip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.iac.tourism.entity.trip.ViewSpot;
import com.iac.tourism.repository.BasicRepository;
import com.iac.tourism.repository.trip.ViewSpotDao;
import com.iac.tourism.service.BasicService;


@Component
@Transactional
public class ViewSpotService extends BasicService<ViewSpot,java.lang.Long> {

	@Autowired
	private ViewSpotDao viewSpotDao;
	
	@Override
	public BasicRepository<ViewSpot,java.lang.Long> getRepository() {
		return viewSpotDao;
	}

	public List<ViewSpot> search(String key) {
		return viewSpotDao.search(key);
	}

	public List<ViewSpot> findByArea(Long id) {
		return viewSpotDao.findByAreaId(id);
	}

	public List<ViewSpot> findByParent(Long id) {
		return viewSpotDao.findByParent(id);
	}
}
