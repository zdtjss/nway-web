package com.nway.web.common.controller;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nway.web.common.service.GenericService;

@RestController
@RequestMapping("/generic")
public class GenericController {

	@Autowired
	private GenericService genericService;
	
	/**
	 * 请求参数： <br>
	 * 
	 * page ： 要显示第几页的数据 <br>
	 * rows ： 页面最大数据量<br>
	 * module :（模块名称，Mybatis mapper名称基于此参数+Mapper） <br>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/{moduleName}/list")
	public Object list(HttpServletRequest request, @PathVariable String moduleName) {

		return genericService.list(request.getParameterMap());
	}

	/**
	 * module :（模块名称，Mybatis mapper名称基于此参数+Mapper） <br>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/{moduleName}/detail")
	public Object detail(HttpServletRequest request, @PathVariable String moduleName) {

		return genericService.get(request.getParameterMap());
	}

	/**
	 * module :（模块名称，Mybatis mapper名称基于此参数+Mapper） <br>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/{moduleName}/add")
	public Map<String, Integer> add(HttpServletRequest request, @PathVariable String moduleName) {

		genericService.add(request.getParameterMap());
		
		return Collections.singletonMap("code", 200);
	}
	
	/**
	 * module :（模块名称，Mybatis mapper名称基于此参数+Mapper） <br>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/{moduleName}/update")
	public Map<String, Integer> update(HttpServletRequest request, @PathVariable String moduleName) {
		
		genericService.update(request.getParameterMap());
		
		return Collections.singletonMap("code", 200);
	}

	/**
	 * module :（模块名称，Mybatis mapper名称基于此参数+Mapper） <br>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/{moduleName}/remove")
	public Map<String, Integer> remove(HttpServletRequest request, @PathVariable String moduleName) {

		genericService.remove(request.getParameterMap());
		
		return Collections.singletonMap("code", 200);
	}
}
