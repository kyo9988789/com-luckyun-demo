package com.luckyun.demo.base.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.luckyun.core.annotation.UrlByPkgController;
import com.luckyun.core.api.annotation.Api;
import com.luckyun.demo.base.entity.MsgBody;
import com.luckyun.demo.base.entity.MsgDetail;

@Api(author = "omai", name = "消息接口测试", regdate = "2019-12-10")
@UrlByPkgController
public class MsTestController {

	// 接口请求失败概率值
	public final static int SEND_ERROR_RATE = 10;

	// 状态查询立即成功的概率值
	public final static int STATUS_SUCCESS_RATE = 10;

	// 状态查询在一定时间内完成的概率值
	public final static int STATUS_PROGRESS_RATE = 90;

	// 消息成功的概率值
	public final static int MSG_SUCCUSS_RATE = 90;

	public final static String MS_KEY = "MS_TEST";

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Api(author = "omai", name = "发送消息")
	@PostMapping(value = "/send")
	public String send(@RequestBody MsgBody msgBody) throws Exception {

		double random = Math.random() * 100;

		if (random <= SEND_ERROR_RATE) {
			throw new Exception("error!");
		}

		Long max = stringRedisTemplate.opsForValue().increment(MS_KEY);

		random = Math.random() * 100;

		if (random <= STATUS_SUCCESS_RATE) { // 立即成功
			setTime(msgBody, 0);
		} else if (random <= STATUS_PROGRESS_RATE) { // 五分钟内成功
			setTime(msgBody, 300);
		} else { // 半小时内超时完成
			setTime(msgBody, 1800);
		}

		stringRedisTemplate.opsForValue().set(MS_KEY + "_" + max, JSON.toJSONString(msgBody));

		return max.toString();
	}

	@Api(author = "omai", name = "状态查询")
	@GetMapping(value = "/status")
	public MsgBody status(@RequestParam("code") String code) throws Exception {

		double random = Math.random() * 100;

		if (random <= SEND_ERROR_RATE) {
			throw new Exception("error!");
		}

		String msgStr = stringRedisTemplate.opsForValue().get(MS_KEY + "_" + code);

		if (msgStr == null || "".equals(msgStr)) {
			throw new Exception("invail code!");
		}

		MsgBody msgBody = JSON.parseObject(msgStr, MsgBody.class);

		for (MsgDetail msg : msgBody.getList()) {

			Date now = new Date();

			if (now.getTime() >= msg.getDatetime().getTime()) {

				random = Math.random() * 100;

				if(msg.getStatus()==0) {
					if (random > MSG_SUCCUSS_RATE) {
						msg.setStatus(1);
					} else {
						msg.setStatus(-1);
					}
				}
				
			}

		}
		
		stringRedisTemplate.opsForValue().set(MS_KEY + "_" + code, JSON.toJSONString(msgBody));

		return msgBody;
	}

	/**
	 * 
	 * @param msgBody     消息体
	 * @param maxInterval 最大时间间隔
	 */
	private void setTime(MsgBody msgBody, int maxInterval) {
		for (MsgDetail msg : msgBody.getList()) {
			Calendar now = Calendar.getInstance();
			now.add(Calendar.SECOND, (int) (maxInterval * Math.random()));
			msg.setDatetime(now.getTime());
		}
	}

}
