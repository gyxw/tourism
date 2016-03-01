package com.iac.tourism.api.search;

import com.rop.annotation.IgnoreSignType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;

@ServiceMethodBean(version="0.0.1", ignoreSign=IgnoreSignType.YES)
public class SearchApi {

	@ServiceMethod(method="search")
	public Object search(SearchForm request) {
		// not support now
		return null;
	}
}
