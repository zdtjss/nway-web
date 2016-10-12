package com.nway.web.demo.event;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.nway.web.common.event.DbRecordAddEvent;
import com.nway.web.common.event.GenericEvent;
import com.nway.web.common.event.GenericListener;


@Component
public class AddEventListener implements GenericListener {

	@Override
	public void onEvent(GenericEvent event) {

		Map<String, String> source = event.getSource();

		System.out.println("新增数据保存成功，原数据 ：" + new Gson().toJson(source));
	}

	@Override
	public boolean supports(Class<? extends GenericEvent> expectedClass, String module) {
		
		return DbRecordAddEvent.class.equals(expectedClass) && module.equals("demo");
	}

}
