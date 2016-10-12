package com.nway.web.common.event;

import java.util.Map;

public class DbRecordUpdateEvent extends GenericEvent {

	private static final long serialVersionUID = 7187657637813802346L;

	public DbRecordUpdateEvent(Map<String, String> source) {

		super(source);
	}
}
