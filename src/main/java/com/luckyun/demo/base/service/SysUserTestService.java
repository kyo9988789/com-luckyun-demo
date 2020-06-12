package com.luckyun.demo.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckyun.core.data.BaseMapper;
import com.luckyun.core.data.BaseService;
import com.luckyun.demo.base.entity.SysUserTest;
import com.luckyun.demo.base.mapper.SysUserTestMapper;

@Service
public class SysUserTestService extends BaseService<SysUserTest>{

	@Autowired
	SysUserTestMapper sysUserTestMapper;
	
	public void batchInsert(List<SysUserTest> sysUserTestList) {
		sysUserTestMapper.batchInsert(sysUserTestList);
	}
	
	@Override
	public BaseMapper<SysUserTest> getMapper() {
		return sysUserTestMapper;
	}

}
