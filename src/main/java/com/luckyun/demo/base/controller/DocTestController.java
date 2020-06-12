package com.luckyun.demo.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.luckyun.core.annotation.UrlByPkgController;
import com.luckyun.core.api.annotation.Api;
import com.luckyun.core.api.annotation.Param;
import com.luckyun.demo.base.entity.DocTest;
import com.luckyun.demo.base.service.DocTestService;

@Api(author = "omai", name = "业务示例", regdate = "2019-10-14")
@UrlByPkgController
public class DocTestController {

	@Autowired
	DocTestService docTestService;

	@Api(author = "omai", name = "账号列表")
	@GetMapping(value = "/readOne")
	public DocTest readOne(@Param("业务主键") @RequestParam("id") Long id) {
		return docTestService.readOne(id);
	}
	
	@Api(author = "omai", name = "添加")
	@PostMapping(value = "/add")
	public int readOne(@Param("业务信息") @RequestBody DocTest docTest) {
		return docTestService.Add(docTest);
	}
	
	@Api(author = "omai",name = "更新业务")
	@PostMapping(value = "/update")
	public int Update(@RequestBody DocTest docTest) {
		// 取消记录日志
		int re = docTestService.update(docTest);
		return re;
	}
	
	@Api(author = "omai",name = "删除业务")
	@GetMapping(value = "/delete")
	public int delete(@Param("业务编号") @RequestParam("id") Long id) {
		return docTestService.deleteDoc(id);
	}
}
