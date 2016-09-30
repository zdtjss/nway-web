package com.nway.web.common.controller;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nway.web.common.service.GenericService;

@RestController
@RequestMapping("generic")
public class GenericController {

	@Autowired
	private GenericService genericService;
	
	/**
	 * 请求参数：mapper（MyBatis mapper名称，必须）
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("list")
	public Object list(HttpServletRequest request) {

		return genericService.list(request.getParameterMap());
	}

	@RequestMapping("detail")
	public Object detail(String mapper, long id) {

		return genericService.get(mapper, id);
	}

	/**
	 * 请求参数：mapper（MyBatis mapper名称，必须）
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("add")
	public Map<String, Integer> add(HttpServletRequest request) {

		genericService.add(request.getParameterMap());
		
		return Collections.singletonMap("code", 200);
	}
	
	/**
	 * 请求参数：mapper（MyBatis mapper名称，必须）
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("update")
	public Map<String, Integer> update(HttpServletRequest request) {
		
		genericService.update(request.getParameterMap());
		
		return Collections.singletonMap("code", 200);
	}

	@RequestMapping("remove")
	public Map<String, Integer> remove(String mapper, String ids) {

		genericService.remove(mapper, ids);
		
		return Collections.singletonMap("code", 200);
	}
}
