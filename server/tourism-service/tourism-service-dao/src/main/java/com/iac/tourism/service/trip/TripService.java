package com.iac.tourism.service.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.iac.tourism.entity.trip.Trip;
import com.iac.tourism.repository.BasicRepository;
import com.iac.tourism.repository.trip.TripDao;
import com.iac.tourism.service.BasicService;


@Component
@Transactional
public class TripService extends BasicService<Trip,java.lang.Long> {

	@Autowired
	private TripDao tripDao;
	
	@Override
	public BasicRepository<Trip,java.lang.Long> getRepository() {
		return tripDao;
	}
}
