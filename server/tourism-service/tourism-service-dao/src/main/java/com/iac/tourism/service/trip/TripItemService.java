package com.iac.tourism.service.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.iac.tourism.entity.trip.TripItem;
import com.iac.tourism.repository.BasicRepository;
import com.iac.tourism.repository.trip.TripItemDao;
import com.iac.tourism.service.BasicService;


@Component
@Transactional
public class TripItemService extends BasicService<TripItem,java.lang.Long> {

	@Autowired
	private TripItemDao tripItemDao;
	
	@Override
	public BasicRepository<TripItem,java.lang.Long> getRepository() {
		return tripItemDao;
	}
}
