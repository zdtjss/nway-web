package com.nway.web.common.event;

import java.util.Map;

import org.springframework.context.ApplicationEvent;

public class DbRecordUpdateEvent extends ApplicationEvent {

	private static final long serialVersionUID = 7187657637813802346L;

	public DbRecordUpdateEvent(Object source) {

		super(source);
	}

	public Map<String, String> getSource() {

		return (Map) super.getSource();
	}
}
