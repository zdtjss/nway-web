package com.nway.web.common.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.nway.web.common.event.DbRecordAddEvent;
import com.nway.web.common.event.DbRecordRemoveEvent;
import com.nway.web.common.event.DbRecordUpdateEvent;
import com.nway.web.common.mapper.GenericMapper;

@Service
public class GenericService implements ApplicationContextAware, InitializingBean {

	private Map<String, GenericMapper> mappers;

	private ApplicationContext applicationContext;

	public Object list(Map<String, String[]> requestParam) {

		Map<String, String> queryParam = reformRequestParam(requestParam);

		String mapperName = queryParam.get("mapper");
		
		String pageStr = queryParam.get("page");
		
		String pageSizeStr = queryParam.get("rows");

		// 页面数据量
		int limit = isBlank(pageSizeStr) ? RowBounds.NO_ROW_LIMIT : Integer.parseInt(queryParam.get("rows"));

		// 第一页是 1
		int offset = isBlank(pageStr) ? RowBounds.NO_ROW_OFFSET : Integer.parseInt(pageStr) * limit;
				
		RowBounds rowBounds = new RowBounds(offset, limit);

		Page<Object> data = mappers.get(mapperName).list(queryParam, rowBounds);
		
		Map<String,Object> pageData = new HashMap<>();
		
		pageData.put("total", data.getTotal());
		pageData.put("rows", data.getResult());
		
		return pageData;
	}

	/**
	 * 注意：本方法假定主键是数字类型的
	 * 
	 * @param requestParam
	 * @return
	 */
	public Object get(String mapperName, long id) {

		return mappers.get(mapperName).getById(id);
	}

	public void add(Map<String, String[]> requestParam) {

		Map<String, String> queryParam = reformRequestParam(requestParam);

		String mapperName = queryParam.get("mapper");

		int effectCount = mappers.get(mapperName).add(queryParam);
		
		if (effectCount != 1) {

			throw new RuntimeException("数据保存失败 {} " + queryParam);
		}
		
		this.applicationContext.publishEvent(new DbRecordAddEvent(queryParam));
	}
	
	public void update(Map<String, String[]> requestParam) {
		
		Map<String, String> queryParam = reformRequestParam(requestParam);
		
		String mapperName = queryParam.get("mapper");
		
		int effectCount = mappers.get(mapperName).update(queryParam);
		
		if (effectCount <= 0) {
			
			throw new RuntimeException("数据更新失败 {} " + queryParam);
		}
		
		this.applicationContext.publishEvent(new DbRecordUpdateEvent(queryParam));
	}

	/**
	 * 注意：本方法假定主键是数字类型的
	 * 
	 * @param requestParam
	 */
	public void remove(String mapperName, String ids) {

		int effectCount = mappers.get(mapperName).removeById(ids);

		if (ids.split(",").length != effectCount) {

			throw new RuntimeException("数据删除失败 {} " + mapperName + "\t" + ids);
		}
		
		Map<String,String> queryParam = new HashMap<>();
		
		queryParam.put("mapper", mapperName);
		queryParam.put("ids", ids);
		
		this.applicationContext.publishEvent(new DbRecordRemoveEvent(queryParam));
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		this.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		this.mappers = applicationContext.getBeansOfType(GenericMapper.class);
	}

	private Map<String, String> reformRequestParam(Map<String, String[]> requestParam) {

		Map<String, String> reformedMap = new HashMap<>(requestParam.size());

		requestParam.forEach((key, value) -> {

			reformedMap.put(key, join(value));
		});

		return reformedMap;
	}
	
	private String join(String[] array) {
		
		StringBuilder buf = new StringBuilder(array.length * 16);

        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buf.append(',');
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
	}
	
	public boolean isBlank(String str) {

		return str == null || str.trim().length() == 0;
	}
}
