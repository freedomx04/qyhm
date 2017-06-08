package com.hm.qyhm.controller.contacts;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hm.qyhm.common.result.Code;
import com.hm.qyhm.common.result.Result;
import com.hm.qyhm.common.result.ResultInfo;
import com.hm.qyhm.common.utils.HttpUtils;
import com.hm.qyhm.common.utils.WxUtils;
import com.hm.qyhm.common.wx.WxResult;

@RestController
public class TagController {
	
	static Logger log = LoggerFactory.getLogger(TagController.class);
	
	private Gson gson = new Gson();
	
	/**
	 * 微信返回的标签类
	 */
	public class TagEntity extends WxResult {
		
		private long tagid;
		
		private Object taglist;
		
		public TagEntity() {
			// TODO Auto-generated constructor stub
		}

		public long getTagid() {
			return tagid;
		}

		public void setTagid(long tagid) {
			this.tagid = tagid;
		}

		public Object getTaglist() {
			return taglist;
		}

		public void setTaglist(Object taglist) {
			this.taglist = taglist;
		}
	}
	
	@RequestMapping(value = "/api/contacts/tag/add", method = RequestMethod.POST)
	public Result add(String tagname) {
		try {
			String token = WxUtils.getInstace().getToken();
			
			HashMap<String, String> map = new HashMap<>();
			map.put("tagname", tagname);
			
			String url = "https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=" + token;
			String ret = HttpUtils.getResponseAsString(url, map);
			
			TagEntity tag = gson.fromJson(ret, TagEntity.class);
			
			if (tag.getErrcode() != 0) {
				return new Result(tag.getErrcode(), tag.getErrmsg());
			}
			
			return new Result(Code.SUCCESS.value(), "created");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new Result(Code.ERROR.value(), e.getMessage());
		}
	}
	
	/**
	 * 删除标签
	 * @param tagid
	 * @return
	 */
	@RequestMapping(value = "/api/contacts/tag/delete", method = RequestMethod.GET)
	public Result delete(long tagid) {
		try {
			String token = WxUtils.getInstace().getToken();
			String url = "https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=" + token + "&tagid=" + tagid;
			String ret = HttpUtils.getResponseAsString(url);
			
			TagEntity tag = gson.fromJson(ret, TagEntity.class);
			if (tag.getErrcode() != 0) {
				return new Result(tag.getErrcode(), tag.getErrmsg());
			}
			
			return new Result(Code.SUCCESS.value(), "deleted");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new Result(Code.ERROR.value(), e.getMessage());
		}
	}
	
	/**
	 * 标签列表
	 * @return
	 */
	@RequestMapping(value = "/api/contacts/tag/list", method = RequestMethod.GET)
	public Result list() {
		try {
			String token = WxUtils.getInstace().getToken();
			String url = "https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token=" + token;
			String ret = HttpUtils.getResponseAsString(url);
			
			TagEntity tag = gson.fromJson(ret, TagEntity.class);
			
			return new ResultInfo(Code.SUCCESS.value(), "ok", tag.taglist);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new Result(Code.ERROR.value(), e.getMessage());
		}
	}

}
