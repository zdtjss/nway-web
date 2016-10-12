package com.nway.web.common.event;

import java.util.EventObject;
import java.util.Map;

public abstract class GenericEvent extends EventObject {

	private static final long serialVersionUID = 8895379008920319581L;

	public GenericEvent(Map<String, String> source) {

		super(source);
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getSource() {

		return (Map<String, String>) super.getSource();
	}
	
	public String getModule() {
		
		return getSource().get("module");
	}
}
