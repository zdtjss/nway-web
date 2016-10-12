package com.nway.web.common.mapper;

import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;

public interface GenericMapper {

	Page<Object> list(Map<String, String> param, RowBounds rowBounds);
	
	Object getById(long id);
	
	int add(Map<String, String> param);
	
	int update(Map<String, String> param);
	
	int removeById(String ids);
}
