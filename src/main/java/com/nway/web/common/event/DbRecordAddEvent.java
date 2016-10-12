package com.nway.web.common.event;

import java.util.Map;

public class DbRecordAddEvent extends GenericEvent {

	private static final long serialVersionUID = 1819246511527898381L;

	public DbRecordAddEvent(Map<String, String> source) {

		super(source);
	}

}
