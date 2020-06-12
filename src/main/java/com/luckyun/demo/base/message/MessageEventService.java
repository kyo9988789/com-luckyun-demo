package com.luckyun.demo.base.message;

import org.springframework.stereotype.Component;

import com.luckyun.core.message.MessageCallBackEvent;
import com.luckyun.model.msg.SysMsg;

@Component
public class MessageEventService extends MessageCallBackEvent{

	@Override
	protected void sendMsgInfo(SysMsg sysMsg) {
		System.out.println("23131");
	}

}
