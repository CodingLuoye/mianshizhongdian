package com.jiguang.push;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

/**
 * app极光推送消息测试代码
 * @author Administrator
 *
 */
public class PushToApp {

	
	private static final String MASTER_SECRET = "a693fab3c14e1c6aea4701f9";
	private static final String APP_KEY = "bbfd23789ec2bdb556bf6499";

	public static void main(String[] args) {
		
		PropertyConfigurator.configure("G:/workplace_newsphere/mianshizhongdian/log4j.properties");
		final Logger log = LoggerFactory.getLogger(PushToApp.class);
		
		JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
	    // For push, all you need do is to build PushPayload object.
	    PushPayload payload = buildPushObjectAllAllAlert();

	    try {
	        PushResult result = jpushClient.sendPush(payload);
	        log.info("Got result - " + result);

	    } catch (APIConnectionException e) {
	        // Connection error, should retry later
	    	log.error("Connection error, should retry later", e);

	    } catch (APIRequestException e) {
	        // Should review the error, and fix the request
	    	log.error("Should review the error, and fix the request", e);
	    	log.info("HTTP Status: " + e.getStatus());
	    	log.info("Error Code: " + e.getErrorCode());
	    	log.info("Error Message: " + e.getErrorMessage());
	    }

	}

	private static PushPayload buildPushObjectAllAllAlert() {
		List<String>  aliasList = new ArrayList<String>();
		aliasList.add("zw001");
		return PushPayload.newBuilder()
	                .setPlatform(Platform.all())
	                .setAudience(Audience.alias(aliasList))
	                .setNotification(Notification.alert("test Specified push to "))
	                .build();
//		return PushPayload.alertAll("test push to all");
	}

}
