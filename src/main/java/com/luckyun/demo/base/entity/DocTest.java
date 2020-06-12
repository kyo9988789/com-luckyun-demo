package com.luckyun.demo.base.entity;

import com.luckyun.annotation.Describe;
import com.luckyun.model.data.DocEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class DocTest extends DocEntity {
	
	
	@Describe("标题")
	private String stitle;
	
	@Describe("用户名")
	private String suserName;
	
	@Override
	public boolean __isTrueDel() {
		// TODO Auto-generated method stub
		return false;
	}

}
