package com.luckyun.demo.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.luckyun.auth.provider.feign.AuthSysModuleProvider;
import com.luckyun.base.provider.cache.datadic.SysDatadicCacheHelper;
import com.luckyun.base.provider.feign.BaseSysDeptProvider;
import com.luckyun.base.provider.feign.BaseSysUserProvider;
import com.luckyun.core.annotation.Pageable;
import com.luckyun.core.annotation.UrlByPkgController;
import com.luckyun.core.api.annotation.Api;
import com.luckyun.core.api.annotation.Param;
import com.luckyun.core.data.filter.AuthInfo;
import com.luckyun.core.response.ApiResult;
import com.luckyun.core.response.PageWrap;
import com.luckyun.demo.base.entity.DocTest;
import com.luckyun.demo.base.entity.SysAccount;
import com.luckyun.demo.base.param.UserParams;
import com.luckyun.demo.base.service.SysAccountService;
import com.luckyun.model.datadic.SysDatadic;
import com.luckyun.model.dept.SysDept;
import com.luckyun.model.group.SysGroup;


@Api(author = "omai",name = "账号管理",regdate = "2019-06-26")
@UrlByPkgController
public class UserController {

	@Autowired
	SysAccountService sysAccountService;

	@Autowired
	private SysDatadicCacheHelper sysDatadicCacheHelper; 
	
	@Autowired
	BaseSysDeptProvider baseSysDeptProvider;
	
	@Autowired
	private BaseSysUserProvider baseSysUserProvider;
	
	@Autowired
	private AuthSysModuleProvider authSysModuleProvider;
	
    @Api(author = "omai",name = "账号信息")
	@GetMapping(value = "/readOne")
	public SysAccount user() {
		List<SysDatadic> datadics = sysDatadicCacheHelper.getObjByField("base_data1");
		com.luckyun.model.user.SysAccount account =baseSysUserProvider.findFSysUserByIndocno(19L);
		return sysAccountService.select(1L);
	}
    
   	@GetMapping(value = "/test")
   	public String test() {
   		SysDept dept = baseSysDeptProvider.findByIndocno(184L);
   		DocTest docTest = new DocTest();
   		return "";
   	}
   	
   	@GetMapping(value = "/base/provder/finduserPwd")
   	public com.luckyun.model.user.SysAccount testProvider() {
   		return baseSysUserProvider.findAccoutContainerPwd(null, 1L);
   	}
   	
   	@GetMapping(value = "/auth/provder/singlelogin")
   	public ApiResult singleLogin() {
   		Map<String, Object> params =new HashMap<>();
   		params.put("username", "admin");
   		params.put("password", "123456");
   		JSONObject result = authSysModuleProvider.singleLogin(params);
   		ApiResult apiResult = JSONObject.parseObject(result.toJSONString(), ApiResult.class);
   		return apiResult;
   	}
	
    @Api(author = "omai",name = "账号列表")
	@GetMapping(value = "/readAll")
	public List<SysAccount> readAll() {
    	SysDept dept = baseSysDeptProvider.findByIndocno(184L);
		return sysAccountService.readAll();
	}
	
    @Api(author = "omai",name = "账号列表-分页")
	@GetMapping(value = "/readAllWithPage")
	@Pageable
	public List<SysAccount> readAllWithPage() {
		return sysAccountService.readAll();
	}

	
	@Api(author = "姚小川", name = "添加账号信息", require = {"indocno"},regdate = "2019-08-27")
	@PostMapping(value = "/add")
	public SysAccount add(@Param("账号信息") @RequestBody SysAccount account) {
		sysAccountService.Add(account);
		return account;
	}
	
	@Api(author = "omai",name = "账号列表附加信息")
	@GetMapping("/main")
	PageWrap mainInfo() {
		return sysAccountService.listWithMainInfo();
	}

	@Api(author = "omai",name = "账号列表-权限过滤")
	@GetMapping("/filter")
	List<SysAccount> filter() {
		return sysAccountService.listWithFilter();
	}

	@Api(author = "omai",name = "更新用户")
	@PostMapping(value = "/update")
	public SysAccount Update(@RequestBody SysAccount account) {
		// 取消记录日志
		sysAccountService.setLogable(true);
		sysAccountService.update(account);
		return account;
	}
	
	@Api(author = "omai",name = "删除用户")
	@GetMapping(value = "/delete")
	public int delete(@Param("用户编号") @RequestParam("id") Long id) {
		return sysAccountService.deleteAccount(id);
	}


	@Api(author = "omai",name = "添加用户事务示例")
	@PostMapping(value = "/addUserAndInfo")
	public int addUserAndInfo(@RequestBody UserParams params) {
		return sysAccountService.addUserAndLInfo(params);
	}

	@Api(author = "omai",name = "Redis设置")
	@GetMapping(value = "/redisSet")
	public String redisSet(@RequestParam("value") String value) {
		sysAccountService.redisSet(value);
		return value;
	}

	@Api(author = "omai",name = "Redis读取")
	@GetMapping(value = "/redisRead")
	public String redisGet() {
		return sysAccountService.redisRead();
	}

	@Api(author = "omai",name = "Session设置")
	@GetMapping(value = "/setSession")
	public void setSession(@RequestParam("value") String value) {
		sysAccountService.setSession("test", value);
	}
	
	
	@Api(author = "omai",name = "Session读取")
	@GetMapping(value = "/getSession")
	public String getSession() {
		return sysAccountService.getSession().getAttribute("test").toString();
	}

	@Api(author = "omai",name = "获取授权")
	@GetMapping(value = "/auth")
	public AuthInfo auth() {
		return sysAccountService.auth();
	}

	@Api(author = "omai",name = "队列测试")
	@GetMapping(value = "/mqSend")
	public void mqSend() {
		sysAccountService.mqSend();
	}
	
	@Api(author = "omai",name = "动态队列")
	@GetMapping(value = "/dynamicQueue")
	public void dynamicQueue() {
		sysAccountService.dynamicQueue();
	}

	@Api(author = "omai",name = "事件测试")
	@GetMapping(value = "/eventTest")
	public void eventTest() {
		sysAccountService.eventTest();
	}
	
	@Api(author = "omai",name = "锁")
	@GetMapping(value = "/lock")
	public void lock() {
		sysAccountService.lock();
	}
	
	@Api(author = "omai",name = "锁测试")
	@GetMapping(value = "/lockTest")
	public void lockTest() {
		sysAccountService.lockTest();
	}
	
	@Api(author = "omai",name = "日志测试")
	@GetMapping(value = "/logTest")
	public void logTest() {
		sysAccountService.saveOptLog("TEST", "log", 1L, "test");
	}

}
