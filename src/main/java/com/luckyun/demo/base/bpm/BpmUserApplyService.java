package com.luckyun.demo.base.bpm;

import org.springframework.stereotype.Component;

import com.luckyun.bpm.event.BpmEventQueue;
import com.luckyun.bpm.event.BpmMessage;

@Component
public class BpmUserApplyService extends BpmEventQueue{

	@Override
	protected void onStart(BpmMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onProcessing(BpmMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onComplete(BpmMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onRefuse(BpmMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onDelete(BpmMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onCancel(BpmMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onTransfer(BpmMessage message) {
		// TODO Auto-generated method stub
		
	}

}
