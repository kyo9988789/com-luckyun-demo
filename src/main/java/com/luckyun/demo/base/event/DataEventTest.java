package com.luckyun.demo.base.event;

import org.springframework.stereotype.Component;

import com.luckyun.core.event.DataEventQueue;
import com.luckyun.demo.base.entity.SysUser;

/**
 * 监听User实体增删改
 * @author omai
 *
 */
@Component
public class DataEventTest extends DataEventQueue<SysUser> {

	@Override
	protected void onUpdate(SysUser older, SysUser newer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onInsert(SysUser entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onDelete(SysUser entity) {
		// TODO Auto-generated method stub
		
	}
}
