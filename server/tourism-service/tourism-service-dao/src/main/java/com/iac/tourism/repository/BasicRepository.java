package com.iac.tourism.repository;

import java.io.Serializable;




import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BasicRepository<E, pk extends Serializable> 
	extends PagingAndSortingRepository<E, pk>, JpaSpecificationExecutor<E> {
}
