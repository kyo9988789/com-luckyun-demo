package com.luckyun.demo.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckyun.core.data.BaseMapper;
import com.luckyun.core.data.BaseService;
import com.luckyun.demo.base.entity.SysUser;
import com.luckyun.demo.base.mapper.SysUserMapper;

@Service
public class SysUserService extends BaseService<SysUser> {
	
	@Autowired
	SysUserMapper sysUserMapper;

	@Override
	public BaseMapper<SysUser> getMapper() {
		return sysUserMapper;
	}
	

}
