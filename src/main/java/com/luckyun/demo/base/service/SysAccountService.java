package com.luckyun.demo.base.service;

import java.util.List;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.luckyun.base.provider.filter.JurisDeptFilter;
import com.luckyun.core.annotation.TransactionalException;
import com.luckyun.core.data.BaseMapper;
import com.luckyun.core.data.BaseService;
import com.luckyun.core.data.filter.AuthInfo;
import com.luckyun.core.data.filter.PermissionHelper;
import com.luckyun.core.event.GlobalEvent;
import com.luckyun.core.mq.DynamicQueue;
import com.luckyun.core.mq.DynamicQueueManager;
import com.luckyun.core.response.PageWrap;
import com.luckyun.demo.base.entity.SysAccount;
import com.luckyun.demo.base.entity.SysUser;
import com.luckyun.demo.base.filter.AuthFilter;
import com.luckyun.demo.base.mapper.SysAccountMapper;
import com.luckyun.demo.base.mq.TestDynamicQueue;
import com.luckyun.demo.base.mq.TestQueue;
import com.luckyun.demo.base.param.UserParams;
import com.luckyun.model.msg.AlertMessage;

@Service
public class SysAccountService extends BaseService<SysAccount> {
	
	@Autowired
	SysAccountMapper sysAccountMapper;
	
	@Autowired
	SysUserService sysUserService;


	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/***
	 * 人员信息
	 * 
	 * @param id
	 * @return
	 */
	public SysAccount select(Long id) {
		SysAccount account = new SysAccount();
		account.setIndocno(id);
		return this.select(account);
	}

	/***
	 * 人员列表
	 * 
	 * @return
	 */
	public List<SysAccount> readAll() {
		List<SysAccount> list = sysAccountMapper.list();
		return list;
	}

	/***
	 * 人员列表结合附加信息
	 * 
	 * @return
	 */
	public PageWrap listWithMainInfo() {
		PageHelper.startPage(1, 5);
		List<SysAccount> list = sysAccountMapper.list();
		SysAccount account = this.select(1L);
		return new PageWrap(account, list);
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public SysAccount Add(SysAccount account) {
		this.insert(account);
		return account;
	}
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteAccount(Long id) {
		SysAccount account = new SysAccount();
		account.setIndocno(id);
		return this.delete(account);
	}

	/**
	 * 更新
	 * @return
	 */
	public int updateAccount(SysAccount sysAccount) {
		return this.update(sysAccount);
	}
	
	/**
	 * 设置session
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public void setSession(String key, String value) {
		this.getSession().setAttribute(key, value);
	}
	
	/**
	 * 获取session
	 * @param key
	 * @return
	 */
	public Object getSession(String key) {
		return this.getSession().getAttribute(key);
	}

	/**
	 * 获得登录用户信息
	 * 
	 * @return
	 */
	public AuthInfo auth() {
		return this.getAuthInfo();
	}
	
	/**
	 * 获取模块服务完整路径，包括微服务前缀
	 * @return
	 */
	public String getPath() {
		return this.getModulePath();
	}

	/***
	 * 事务
	 * 
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	@TransactionalException
	public int addUserAndLInfo(UserParams params){
		SysAccount account = params.getAccount();
		SysUser user = params.getUser();
		this.insert(account);
		user.setIuserid(-100L);
		return sysUserService.insert(user);
	}

	/***
	 * 权限过滤
	 * 
	 * @return
	 */
	public List<SysAccount> listWithFilter() {
		PermissionHelper.addFilter(new AuthFilter(getAuthInfo(),"indocno"));
		return sysAccountMapper.list();
	}

	/***
	 * 多语句权限过滤
	 * 
	 * @return
	 */
	public List<SysAccount> listWithFilterMuti() {
		PermissionHelper.addFilter(new AuthFilter(getAuthInfo(),"indocno"));
		PermissionHelper.addFilter(new JurisDeptFilter(getAuthInfo(),"idept"));
		List<SysAccount> list = sysAccountMapper.list();
		return list;
	}

	/**
	 * Redis赋值
	 * 
	 * @param value 值
	 */
	public void redisSet(String value) {
		stringRedisTemplate.opsForValue().set("redis-test", value);
	}

	/**
	 * Redis读值
	 */
	public String redisRead() {
		return stringRedisTemplate.opsForValue().get("redis-test");
	}
	

	@Autowired
	TestQueue testQueue;

	public void mqSend() {
		testQueue.sendMessage(new SysUser());
	}
	
	/**
	 * 错误测试
	 */
	public void errTest() {
		throw new Error("err test");
	}
	
	@Autowired
	GlobalEvent globalEvent;
	
	public void eventTest() {
		globalEvent.publishEvent("Test Massage", "EventTest");
	}
	
	@Autowired
	RedissonClient redissonClient;
	
	public void lock() {
		RLock lock = redissonClient.getLock("lockTest");
		lock.lock();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock.unlock();
	}
	
	public String lockTest(){
		RLock lock = redissonClient.getLock("lockTest");
		lock.lock();
		String re = "lock test";
		lock.unlock();
		return re;
	}
	
	@Autowired
	DynamicQueueManager dynamicQueueManager;
	
	public void dynamicQueue() {
		DynamicQueue<SysUser> queue = dynamicQueueManager.getInstanceByKey(TestDynamicQueue.class,"1");
		queue.sendMessage(new SysUser());
		
		DynamicQueue<SysUser> queue2 = dynamicQueueManager.getInstanceByKey(TestDynamicQueue.class,"2");
		queue2.sendMessage(new SysUser());
	}
	

	@Override
	public BaseMapper<SysAccount> getMapper() {
		return sysAccountMapper;
	}

}
