package com.luckyun.demo.base.bpm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.luckyun.bpm.event.BpmEventQueue;
import com.luckyun.bpm.event.BpmMessage;

@Component
public class TestModelKey extends BpmEventQueue {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 流程启动
	 */
	@Override
	protected void onStart(BpmMessage message) {
		logger.info("onStart：" + message.getDocid());
	}

	/**
	 * 流程步骤变化
	 */
	@Override
	protected void onProcessing(BpmMessage message) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 流程结束
	 */
	@Override
	protected void onComplete(BpmMessage message) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 流程拒绝
	 */
	@Override
	protected void onRefuse(BpmMessage message) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 流程删除
	 */
	@Override
	protected void onDelete(BpmMessage message) {
		// TODO Auto-generated method stub
	}

	/**
	 * 流程取消
	 */
	@Override
	protected void onCancel(BpmMessage message) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 流程转交
	 */
	@Override
	protected void onTransfer(BpmMessage message) {
		// TODO Auto-generated method stub
		
	}
}
