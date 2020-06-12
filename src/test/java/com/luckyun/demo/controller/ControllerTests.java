package com.luckyun.demo.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.luckyun.core.response.ApiResult;
import com.luckyun.demo.BaseTest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ControllerTests extends BaseTest {

	@Test(timeout = 5000)
	public void Home() {
		ApiResult result = testRestTemplate.getForObject("/home/user", ApiResult.class);
		Assert.assertEquals(1,result.getCode());
	}
	
	@Test(timeout = 5000)
	public void list() {
		ApiResult result = testRestTemplate.getForObject("/home/list", ApiResult.class);
		Assert.assertEquals(1,result.getCode());
	}

}
