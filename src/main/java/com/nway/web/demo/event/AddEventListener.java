package com.nway.web.demo.event;

import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.nway.web.common.event.DbRecordAddEvent;

@Component
public class AddEventListener implements ApplicationListener<DbRecordAddEvent> {

	@Override
	public void onApplicationEvent(DbRecordAddEvent event) {

		Map<String, String> source = event.getSource();

		System.out.println("新增数据保存成功，原数据 ：" + new Gson().toJson(source));
	}

}

