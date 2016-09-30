package com.nway.web.common.event;

import java.util.Map;

import org.springframework.context.ApplicationEvent;

public class DbRecordRemoveEvent extends ApplicationEvent {

	private static final long serialVersionUID = -708006937160972145L;

	public DbRecordRemoveEvent(Object source) {
		super(source);
	}

	public Map<String, String> getSource() {

		return (Map) super.getSource();
	}
}
