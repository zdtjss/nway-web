package com.nway.web.demo.event;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.nway.web.common.event.DbRecordRemoveEvent;
import com.nway.web.common.event.GenericEvent;
import com.nway.web.common.event.GenericListener;


@Component
public class RemoveEventListener implements GenericListener {

	@Override
	public void onEvent(GenericEvent event) {

		Map<String, String> source = event.getSource();

		System.out.println("数据删除成功，元数据 ：" + new Gson().toJson(source));
	}

	@Override
	public boolean supports(Class<? extends GenericEvent> expectedClass, String module) {

		return DbRecordRemoveEvent.class.equals(expectedClass) && module.equals("demo");
	}

}
