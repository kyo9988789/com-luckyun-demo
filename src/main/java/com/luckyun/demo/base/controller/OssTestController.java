package com.luckyun.demo.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luckyun.core.tool.OssPathHelperUtils;

@RestController
public class OssTestController {

	@Autowired
	private OssPathHelperUtils ossPathHelperUtils;
	
	@RequestMapping("/oss/generate/download/url")
	public String generatePrefixUrl() {
		
		return ossPathHelperUtils.generatePdfShowPreviewNoAuth("guanj", "xuefu", "20200114/15c7c10e-a544-49d5-9716-04bce23e3e3c.xlsx", "测试.xlsx");
	} 
}
