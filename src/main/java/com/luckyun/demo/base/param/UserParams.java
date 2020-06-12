package com.luckyun.demo.base.param;

import com.luckyun.annotation.Describe;
import com.luckyun.demo.base.entity.SysAccount;
import com.luckyun.demo.base.entity.SysUser;
import lombok.Data;

@Data
public class UserParams {
	@Describe("账号信息")
	private SysAccount account;
	@Describe("用户信息")
	private SysUser user;
}
