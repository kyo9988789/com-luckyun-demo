package com.luckyun.demo.base.entity;

import java.util.Date;

import com.luckyun.annotation.Describe;

/**
 * 消息明细
 * @author omai
 *
 */
public class MsgDetail {

	@Describe("接收人")
	private String receive;

	@Describe("状态")
	private int status;

	@Describe("状态更新时间")
	private Date datetime;

	public String getReceive() {
		return receive;
	}

	public void setReceive(String receive) {
		this.receive = receive;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
