package com.luckyun.demo.base.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.luckyun.core.mq.Dynamic;
import com.luckyun.core.mq.DynamicQueue;
import com.luckyun.demo.base.entity.SysUser;

@Dynamic
public class TestDynamicQueue extends DynamicQueue<SysUser> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void onMessage(SysUser message) throws Exception {
		logger.info("TestDynamicQueue：" + message );
	}

}
