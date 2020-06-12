package com.luckyun.demo.base.entity;

import java.util.Date;

import com.luckyun.annotation.Describe;
import com.luckyun.annotation.Virtual;
import com.luckyun.model.data.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class SysAccount extends BaseEntity {

	@Describe("主键编号")
	private Long indocno;
	@Describe("登陆账号")
	private String sloginid;
	@Describe("登陆密码")
	private String spassword;
	@Describe("名称")
	private String sname;
	@Describe("拼音简写")
	private String spinyinsingle;
	@Describe("全拼")
	private String spinyinfull;
	@Describe("手机号")
	private String sphone;
	@Describe("类型")
	private Integer itype;
	@Describe("状态")
	private Integer istate;
	@Describe("创建人")
	private Long sregid;
	@Describe("创建时间")
	private Date dregt;
	
	@Describe("性别统计")
	@Virtual
	private Integer count;
	
	@Override
	public String __getTableName() {
		return "sys_account";
	}

	@Override
	public boolean __isTrueDel() {
		return false;
	}

}
