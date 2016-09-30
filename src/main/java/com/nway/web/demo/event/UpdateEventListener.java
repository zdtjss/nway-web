package com.nway.web.demo.event;

import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.nway.web.common.event.DbRecordUpdateEvent;

@Component
public class UpdateEventListener implements ApplicationListener<DbRecordUpdateEvent> {

	@Override
	public void onApplicationEvent(DbRecordUpdateEvent event) {

		Map<String, String> source = event.getSource();

		System.out.println("数据更新成功，原数据：" + new Gson().toJson(source));
	}

}
