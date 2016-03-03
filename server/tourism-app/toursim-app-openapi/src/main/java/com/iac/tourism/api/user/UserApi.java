package com.iac.tourism.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.utils.Identities;

import com.iac.tourism.api.CommonResponse;
import com.iac.tourism.entity.user.User;
import com.iac.tourism.rop.OpenSession;
import com.iac.tourism.rop.ResultFactory;
import com.iac.tourism.rop.ResultFactory.ErrorCode;
import com.iac.tourism.service.user.UserService;
import com.rop.AbstractRopRequest;
import com.rop.RopRequest;
import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;

@ServiceMethodBean(version="0.0.1")
public class UserApi {
	
	@Autowired
	private UserService userService;

	@ServiceMethod(method = "user.login", needInSession = NeedInSessionType.NO)
    public Object logon(LoginForm request) {
        //创建一个会话
		String sessionId = Identities.uuid();
		User user = userService.validate(request.getUsername(), request.getPassword());
		
		if(user == null) {
			return ResultFactory.fail(request, ErrorCode.INVALID_USERNAME_PASSWORD);
		}
		
        return setupSession(request, sessionId, user);
    }

	private LoginResponse setupSession(AbstractRopRequest request, String sessionId, User user) {
		OpenSession session = new OpenSession(sessionId, OpenSession.Type.APP_LOGIN, user);
        request.getRopRequestContext().addSession(sessionId, session);

        //返回响应
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setSessionId(sessionId);
		return loginResponse;
	}
	
	@ServiceMethod(method = "user.openlogin", needInSession = NeedInSessionType.NO)
	public Object openLogin(OpenLoginForm request) {
		//创建一个会话
		String sessionId = request.getOpenId() + request.getUserType().name();
		User user = userService.openLogin(request.getOpenId(), request.getUserType());
		
		return setupSession(request, sessionId, user);
	}
	
	@ServiceMethod(method = "user.logout")
    public Object logout(RopRequest request){
		request.getRopRequestContext().removeSession();
		return new CommonResponse();
    }
	
	@ServiceMethod(method = "user.register", needInSession = NeedInSessionType.NO)
	public Object register(RegisterForm request) {
		if(userService.exists(request.getUsername())) {
			return ResultFactory.fail(request, ErrorCode.USERNAME_EXISTED, request.getMobile());
		}
		if(userService.exists(request.getMobile())) {
			return ResultFactory.fail(request, ErrorCode.MOBILE_EXISTED, request.getMobile());
		}
		//TODO: validate captchas
		
		User user = new User();
		user.setLoginName(request.getUsername());
		user.setMobile(request.getMobile());
		user.setPlainPassword(request.getPassword());
		
		userService.save(user);
		String sessionId = Identities.uuid();
		return setupSession(request, sessionId, user);
	}
	
	/**
	 * FIX:
	 * @return
	 */
	public Object validUserName() {
		return null;
	}
	
	public Object mobileExists() {
		return null;
	}
}
