package com.hm.qyhm.common.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class WxUtils {
	
	static Logger log = LoggerFactory.getLogger(WxUtils.class);
	
	
	public static WxUtils INSTANCE = null;
	
	private WxUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static WxUtils getInstace() {
		if (INSTANCE == null) {
			synchronized (WxUtils.class) {
				if (INSTANCE == null) {
					INSTANCE = new WxUtils();
				}
			}
		}
		return INSTANCE;
	}
	
	/**
	 * access token
	 */
	public class TokenEntity {
		private String access_token;
		private long expires_in;
		
		public TokenEntity() {}

		public String getAccess_token() {
			return access_token;
		}

		public void setAccess_token(String access_token) {
			this.access_token = access_token;
		}

		public long getExpires_in() {
			return expires_in;
		}

		public void setExpires_in(long expires_in) {
			this.expires_in = expires_in;
		}
	}
	
	private String accessToken = null;
	private long expireTime = 0;
	
	/**
	 * 获取access_token
	 * @return access_token
	 */
	public String getToken() throws IOException {
		String corpid = ConfigUtils.get("customize.weixin.corpid");
		String corpsecret = ConfigUtils.get("customize.weixin.corpsecret");
		
		long current = System.currentTimeMillis();
		if (expireTime < current) {
			String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + corpsecret;
			String ret = HttpUtils.getResponseAsString(url);
			TokenEntity token = new Gson().fromJson(ret, TokenEntity.class);
			
			if (token.getAccess_token() != null) {
				accessToken = token.getAccess_token();
				expireTime = current + 7200 * 1000;
				
				log.info("get token from weixin, token is " + accessToken);
			} else {
				throw new IOException("invalid token");
			}
		}
		
		return accessToken;
	}
	
}
