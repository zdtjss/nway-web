package com.nway.web.common.event;

import java.util.Collection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher implements ApplicationContextAware, InitializingBean {

	private ApplicationContext applicationContext;

	private Collection<GenericListener> listeners;

	public void publishEvent(GenericEvent event) {

		listeners.forEach((listener) -> {
			
			if (listener.supports(event.getClass(), event.getModule())) {
				
				listener.onEvent(event);
			}
		});
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		this.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		this.listeners = applicationContext.getBeansOfType(GenericListener.class).values();
	}
}
