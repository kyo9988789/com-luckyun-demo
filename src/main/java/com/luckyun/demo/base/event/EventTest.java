package com.luckyun.demo.base.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.luckyun.core.event.EventQueue;

/**
 * 通用事件测试
 * @author omai
 *
 */
@Component
public class EventTest extends EventQueue {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void onMessage(String message) throws Exception {
		logger.info("EventTest：" + message);
	}

}
