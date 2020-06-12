package com.luckyun.demo.base.entity;

import java.util.List;

import com.luckyun.annotation.Describe;

/**
 * 消息体
 * 
 * @author omai
 *
 */
public class MsgBody {

	@Describe("消息内容")
	private String msg;

	@Describe("消息明细")
	private List<MsgDetail> list;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<MsgDetail> getList() {
		return list;
	}

	public void setList(List<MsgDetail> list) {
		this.list = list;
	}

}
