/**
 * 版权声明：中图一购网络科技有限公司 版权所有 违者必究 2012 
 * 日    期：12-7-30
 */
package com.iac.tourism.api.security;

import com.rop.security.InvokeTimesController;
import com.rop.session.Session;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
public class AppInvokeTimesController implements InvokeTimesController {
   
    private static Map<String, AtomicLong> appCallCounter = new HashMap<String, AtomicLong>();

    public void caculateInvokeTimes(String appKey, Session session) {
        if(!appCallCounter.containsKey(appKey)){
        	appCallCounter.putIfAbsent(appKey, new AtomicLong(1));
        }
        appCallCounter.get(appKey).incrementAndGet();
    }

    public boolean isUserInvokeLimitExceed(String appKey, Session session) {
        return false;
    }


    public boolean isSessionInvokeLimitExceed(String appKey, String sessionId) {
        return false;
    }

    public boolean isAppInvokeLimitExceed(String appKey) {
        return false;
    }

    public boolean isAppInvokeFrequencyExceed(String appKey) {
        return false;
    }
}

