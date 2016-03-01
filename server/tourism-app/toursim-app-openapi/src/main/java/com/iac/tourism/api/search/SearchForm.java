package com.iac.tourism.api.search;

import org.hibernate.validator.constraints.NotBlank;

import com.rop.AbstractRopRequest;

public class SearchForm extends AbstractRopRequest {

	@NotBlank
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
