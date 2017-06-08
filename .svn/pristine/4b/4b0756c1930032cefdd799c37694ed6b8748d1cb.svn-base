package com.hm.qyhm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hm.qyhm.common.result.Code;
import com.hm.qyhm.common.result.Result;
import com.hm.qyhm.common.result.ResultInfo;
import com.hm.qyhm.common.utils.WxUtils;

@RestController
public class CommonController {
	
	static Logger log = LoggerFactory.getLogger(CommonController.class);
	
	/**
	 * 实时获取access token
	 * @return
	 */
	@RequestMapping(value = "/api/common/gettoken", method = RequestMethod.GET)
	public Result getToken() {
		try {
			String token = WxUtils.getInstace().getToken();
			return new ResultInfo(Code.SUCCESS.value(), "ok", token);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new Result(Code.ERROR.value(), e.getMessage());
		}
	}
	

}
