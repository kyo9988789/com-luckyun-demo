package com.luckyun.demo.base.entity;

import java.util.Date;

import com.luckyun.annotation.Describe;
import com.luckyun.model.data.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class SysUser extends BaseEntity {
    
	@Describe("主键编号")
    private Long indocno;
	@Describe("用户账号ID")
	private Long iuserid;
	@Describe("性别")
	private Integer isex;
	@Describe("创建人")
	private Long sregid;
	@Describe("创建时间")
	private Date dregt;
	
	@Override
	public String __getTableName() {
		// TODO Auto-generated method stub
		return "sys_user";
	}

	@Override
	public boolean __isTrueDel() {
		// TODO Auto-generated method stub
		return false;
	}


}
