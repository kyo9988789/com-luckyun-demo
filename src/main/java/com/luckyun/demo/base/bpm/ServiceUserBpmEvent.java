package com.luckyun.demo.base.bpm;

import org.springframework.stereotype.Component;

import com.luckyun.bpm.callback.BpmEventAfterService;
import com.luckyun.bpm.event.BpmMessage;

/**
 * 流程事件处理完成后的业务逻辑处理
 * @author yangj080
 *
 */
@Component
public class ServiceUserBpmEvent implements BpmEventAfterService{

	@Override
	public void onStartAfter(BpmMessage message, BpmMessage nextMessage) {
		System.out.println("onStart");
	}

	@Override
	public void onProcessingAfter(BpmMessage message, BpmMessage nextMessage) {
		System.out.println("nextMessage");
	}

	@Override
	public void onCompleteAfter(BpmMessage message) {
		System.out.println("onCompeteAfter");
		
	}

	@Override
	public void onRefuseAfter(BpmMessage message, BpmMessage nextMessage) {
		System.out.println("OnRefuseAfter");
		
	}

	@Override
	public void onDeleteAfter(BpmMessage message) {
		
		System.out.println("OnDeleteAfter");
	}

	@Override
	public void onCancelAfter(BpmMessage message) {
		System.out.println("onCancelAfter");
		
	}

	@Override
	public void onTransferAfter(BpmMessage message) {
		System.out.println("onTransferAfter");
		
	}

	@Override
	public String getModelKey() {
		return "BpmUserApplyService";
	}

}
