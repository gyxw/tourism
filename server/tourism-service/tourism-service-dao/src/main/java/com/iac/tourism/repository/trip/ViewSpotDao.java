package com.iac.tourism.repository.trip;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.iac.tourism.entity.trip.ViewSpot;
import com.iac.tourism.repository.BasicRepository;


public interface ViewSpotDao extends BasicRepository<ViewSpot,java.lang.Long>{

	@Query("from ViewSpot vs where vs.name like CONCAT('%', ?1, '%') or ?1 like CONCAT('%', vs.name, '%')")
	List<ViewSpot> search(String key);

	List<ViewSpot> findByAreaId(Long area);

	List<ViewSpot> findByParent(Long id);
}
