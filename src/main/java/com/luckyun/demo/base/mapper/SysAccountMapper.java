package com.luckyun.demo.base.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.luckyun.core.data.BaseMapper;
import com.luckyun.demo.base.entity.SysAccount;

@Repository
public interface SysAccountMapper extends BaseMapper<SysAccount> {
	
	/**
	 * 账号列表
	 * @return
	 */
	List<SysAccount> list();
	
	/**
	 * 性别统计
	 * @return
	 */
	List<Map<String, Object>> count();
}
