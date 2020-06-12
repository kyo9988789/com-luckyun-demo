package com.luckyun.demo.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luckyun.model.user.SysAccount;
import com.luckyun.solrservice.SolrHelperService;

@RestController
@RequestMapping("/solr")
public class SolrOperateController {

	@Autowired
	private SolrHelperService<SysAccount> solrHelperService;
	
	@RequestMapping("add")
	public void setSolrIndex() {
		SysAccount account = new SysAccount();
		account.setIndocno(1L);
		account.setSname("测试人员");
		account.setSloginid("ceshi");
		account.setDeptname("测试部门");
		solrHelperService.add(account);
	}
	
	@RequestMapping("find")
	public List<SysAccount> getSolrIndex() {
		return solrHelperService.search2(SysAccount.class);
	}
}
