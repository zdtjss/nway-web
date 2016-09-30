package com.nway.web.common.event;

import java.util.EventObject;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SyncEventPublisher implements ApplicationContextAware, InitializingBean {

	private ApplicationContext applicationContext;

	public void publishEvent(EventObject event) {
		
		this.applicationContext.publishEvent(event);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		this.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		
	}
}
