package com.iac.tourism.rop;

import com.rop.AbstractRopRequest;
import com.rop.response.BusinessServiceErrorResponse;

public class ResultFactory {

	public static BusinessServiceErrorResponse fail(AbstractRopRequest request, ErrorCode error, Object...params) {
		return new BusinessServiceErrorResponse(request.getRopRequestContext(), error.name(), params);
	}
	
	public enum ErrorCode {
		INVALID_USERNAME_PASSWORD,
		USER_FORBIDDEN,
		USERNAME_EXISTED,
		MOBILE_EXISTED
	}
}
