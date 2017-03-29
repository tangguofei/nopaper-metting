package com.open.yun.ysmsvs.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.open.yun.common.model.ReqBody;
import com.open.yun.common.utils.HttpUtils;
import com.open.yun.common.utils.MD5Utils;

public class BaseAPiTest {
	private static final Logger log = LoggerFactory.getLogger(BaseAPiTest.class);
	
	public String url = "http://localhost:9090";

	public Map<String, String> header = new HashMap<String, String>();


	public <T> String doService(String action, T content) {
		String requestUrl = url + "/" + action + ".json";

		ReqBody<T> obj = new ReqBody<T>();
		obj.setContent(content);

		String requestJson = JSON.toJSONString(obj);
		requestJson = "{\"request\":" + requestJson + "}";
		log.info(requestJson);
		
		header.put("format", "json");

		String response = HttpUtils.doApiPost(requestUrl, requestJson, header);
		log.info(response);
		return response;
	}
	
	public <T> String doUpFileService(String action, Map<String, String> paramMap, String filepath){
		String requestUrl = url + "/" +action + ".json";
		header.put("format", "json");
		header.put("reqcontentmd5", MD5Utils.md5file(filepath).toLowerCase());
		header.putAll(paramMap);
		String response = HttpUtils.doApiPostFile(requestUrl, filepath, header);
		log.debug(response);
		return response;
	}
}
