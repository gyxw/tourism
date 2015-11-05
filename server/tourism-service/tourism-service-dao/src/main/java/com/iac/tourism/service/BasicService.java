package com.iac.tourism.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import com.iac.tourism.repository.BasicRepository;

public abstract class BasicService<E, pk extends Serializable> {
	public abstract BasicRepository<E, pk> getRepository();
	
	public E get(pk id) {
		return getRepository().findOne(id);
	}

	public void save(E entity) {
		getRepository().save(entity);
	}
	
	public void save(Iterable<E> entities) {
		getRepository().save(entities);
	}

	public void delete(pk id) {
		getRepository().delete(id);
	}

	public List<E> listAll() {
		return (List<E>) getRepository().findAll();
	}

	public Page<E> findPage(Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<E> spec = buildSpecification(searchParams);
		return getRepository().findAll(spec, pageRequest);
	}

	public List<E> findAll(Map<String, Object> searchParams) {
		Specification<E> spec = buildSpecification(searchParams);
		return getRepository().findAll(spec);
	}
	
	public List<E> findAll(Map<String, Object> searchParams, String sortType) {
		Specification<E> spec = buildSpecification(searchParams);
		Sort sort = from(sortType);
		return getRepository().findAll(spec, sort);
	}
	
	/**
	 * 创建sort
	 * @param sortType	字段 asc|desc
	 * @return
	 */
	public Sort from(String sortType) {
		Sort sort = null;
		if (StringUtils.isNotBlank(sortType)) {
			String[] sortTypeGroup = sortType.split(" ");

			String dirctionStr = sortTypeGroup.length == 1
					|| StringUtils.isBlank(sortTypeGroup[1]) ? "asc"
					: sortTypeGroup[1];
			Direction dirction = Direction.fromString(dirctionStr);
			sort = new Sort(dirction, sortTypeGroup[0]);
		}
		return sort;
	}
	
	/**
	 * 创建分页请求. PageRequest start index with 0
	 * @param pageNumber
	 * @param pagzSize
	 * @param sortType	字段 asc|desc
	 * @return
	 */
	protected PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = from(sortType);

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	@SuppressWarnings("unchecked")
	private Specification<E> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Class<E> entityClass = (Class<E>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Specification<E> spec = DynamicSpecifications.bySearchFilter(filters.values(), entityClass);
		return spec;
	}

}
