package com.nway.web.common.event;

import java.util.Map;

public class DbRecordRemoveEvent extends GenericEvent {

	private static final long serialVersionUID = -708006937160972145L;

	public DbRecordRemoveEvent(Map<String, String> source) {

		super(source);
	}
}
