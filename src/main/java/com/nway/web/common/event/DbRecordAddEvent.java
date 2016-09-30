package com.nway.web.common.event;

import java.util.Map;

import org.springframework.context.ApplicationEvent;

public class DbRecordAddEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1819246511527898381L;

	public DbRecordAddEvent(Object source) {
		
		super(source);
	}

	public Map<String,String> getSource() {
		
		return (Map) super.getSource();
	}
}
