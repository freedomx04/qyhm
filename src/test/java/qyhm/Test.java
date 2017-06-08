package qyhm;

import java.util.HashMap;

import com.hm.qyhm.common.utils.HttpUtils;

public class Test {
	
	public static void main(String[] args) throws Exception {
		Test test = new Test();
		test.execute();
	}
	
	public void execute() throws Exception {
		String token = "Hya52J8QG5IioHlzLNJtz96aDV4p_kstwL4qUjtdOWODpLObCCqo9izNJXY2sCJm";
		String url = "https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=" + token;
		
		HashMap<String, String> map = new HashMap<>();
		map.put("tagname", "tagname");
		map.put("tagid", "1");
		
		String ret = HttpUtils.getResponseAsString(url, map);
		
		System.out.println(ret);
		
	}

}
