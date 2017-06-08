package com.hm.qyhm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	
	static Logger log = LoggerFactory.getLogger(BaseController.class);
	
	/**
	 * 后台管理home页面
	 */
	@RequestMapping(value = "home")
	String home() {
		return "home";
	}

	/**
	 * 首页
	 */
	@RequestMapping(value = "overview")
	String overview() {
		return "overview";
	}
	
	/**
	 * 通讯录管理
	 */
	@RequestMapping(value = "contacts")
	String contactsUser() {
		return "pages/wx/contacts";
	}
	
	
}
