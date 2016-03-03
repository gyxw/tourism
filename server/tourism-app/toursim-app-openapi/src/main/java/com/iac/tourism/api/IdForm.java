package com.iac.tourism.api;

import com.rop.AbstractRopRequest;
import com.sun.istack.NotNull;

public class IdForm extends AbstractRopRequest {

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
