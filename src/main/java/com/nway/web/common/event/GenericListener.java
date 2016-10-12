package com.nway.web.common.event;

import java.util.EventListener;

public interface GenericListener extends EventListener {

	void onEvent(GenericEvent event);

	boolean supports(Class<? extends GenericEvent> expectedClass, String module);
}
