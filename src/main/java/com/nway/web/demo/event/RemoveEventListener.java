package com.nway.web.demo.event;

import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.nway.web.common.event.DbRecordRemoveEvent;

@Component
public class RemoveEventListener implements ApplicationListener<DbRecordRemoveEvent> {

	@Override
	public void onApplicationEvent(DbRecordRemoveEvent event) {

		Map<String, String> source = event.getSource();

		System.out.println("数据删除成功，元数据 ：" + new Gson().toJson(source));
	}

}
