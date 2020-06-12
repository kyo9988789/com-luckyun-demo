package com.luckyun.demo.base.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luckyun.base.provider.feign.BaseSysDeptProvider;
import com.luckyun.base.provider.feign.BaseSysPostProvider;
import com.luckyun.base.provider.feign.BaseSysUserProvider;
import com.luckyun.core.data.filter.AuthFilter;
import com.luckyun.core.data.filter.AuthInfo;
import com.luckyun.core.exception.CustomException;
import com.luckyun.demo.base.entity.SysUserTest;
import com.luckyun.demo.base.service.SysUserTestService;
import com.luckyun.model.dept.SysDept;
import com.luckyun.model.post.SysPost;
import com.luckyun.model.user.SysAccount;

@RestController
@RequestMapping("/sysusertest")
public class SysUserTestController {

	@Autowired
	private SysUserTestService sysUserTestService;
	
	@Autowired
	BaseSysPostProvider baseSysPostProvider;
	
	@Autowired
	BaseSysUserProvider baseSysUserProvider;
	
	@Autowired
	ObjectFactory<HttpSession> httpSessionFactory;
	
	@Autowired
	BaseSysDeptProvider baseSysDeptProvider;
	
	@RequestMapping("/add")
	public void insertBatch() {
		List<SysUserTest> sysUserTestList = new ArrayList<SysUserTest>();
		SysUserTest sysUserTest = new SysUserTest();
		sysUserTest.setIndocno(1L);
		sysUserTest.setSname("ceshishis");
		sysUserTest.setIage(12);
		sysUserTestList.add(sysUserTest);
		sysUserTest = new SysUserTest();
		sysUserTest.setIndocno(2L);
		sysUserTest.setSname("ceshishis22222222222222222222");
		sysUserTest.setIage(13);
		sysUserTestList.add(sysUserTest);
		sysUserTestService.batchInsert(sysUserTestList);
	}
	
	@RequestMapping("/batchAdd")
	public void batchInsertSysPost() {
		List<SysPost> sysPosts = new ArrayList<SysPost>();
		SysPost post = new SysPost();
		post.setSname("feign接口添加的post岗位1111");
		post.setSregid(1L);
		sysPosts.add(post);
		post = new SysPost();
		post.setSname("feign接口添加的post岗位22222");
		post.setSregid(1L);
		sysPosts.add(post);
		post = new SysPost();
		post.setSname("feign接口添加的post岗位3333");
		post.setSregid(1L);
		sysPosts.add(post);
		int istate = baseSysPostProvider.batchAddSysPost(sysPosts);
		if(istate == 0) {
			throw new CustomException("批量添加失败");
		}
	}
	@RequestMapping("/singleAdd")
	public void insertSysPost() {
		SysPost post = new SysPost();
		post.setSname("feign接口添加的post岗位44444");
		post.setSregid(1L);
		SysPost istate = baseSysPostProvider.addSingleSysPost(post);
	}
	
	@RequestMapping("/batchSysAccount")
	public void insertSysAccount() {
		List<SysAccount> sysAccounts = new ArrayList<SysAccount>();
		SysAccount account =new SysAccount();
		account.setSname("管理员");
		account.setSloginid("admin1234x");
		account.setSregid(1L);
		sysAccounts.add(account);
		account =new SysAccount();
		account.setSname("管理员2");
		account.setSloginid("admin1234x2");
		account.setSregid(1L);
		sysAccounts.add(account);
		account =new SysAccount();
		account.setSname("管理员3");
		account.setSloginid("admin1234x3");
		account.setSregid(1L);
		sysAccounts.add(account);
		baseSysUserProvider.batchAddSysAccount(sysAccounts);
	}
	
	@RequestMapping("/batchSysDept")
	public void insertSysDept() {
		AuthInfo authInfo = getAuthInfo();
		List<SysDept> sysDepts = new ArrayList<SysDept>();
		SysDept dept = new SysDept();
		dept.setSname("feign测试部门111");
		dept.setIcompanyid(authInfo.getIcompanyid());
		dept.setSregid(authInfo.getIndocno());
		sysDepts.add(dept);
		dept = new SysDept();
		dept.setSname("feign测试部门222");
		dept.setIcompanyid(authInfo.getIcompanyid());
		dept.setSregid(authInfo.getIndocno());
		sysDepts.add(dept);
		dept = new SysDept();
		dept.setSname("feign测试部门333");
		dept.setIcompanyid(authInfo.getIcompanyid());
		dept.setSregid(authInfo.getIndocno());
		sysDepts.add(dept);
		baseSysDeptProvider.batchAddSingleDept(sysDepts);
	}
	
	/**
	 * 获得登录用户信息
	 * 
	 * @return
	 */
	public AuthInfo getAuthInfo() {
		return (AuthInfo) httpSessionFactory.getObject().getAttribute(AuthFilter.AUTH_SESSION_KEY);
	}
}
