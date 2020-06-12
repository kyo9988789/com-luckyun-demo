package com.luckyun.demo.base.entity;

import com.luckyun.model.data.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class SysUserTest extends BaseEntity{
	
	private Long indocno;
	
	private Integer iage;
	
	private String sname;

	@Override
	public boolean __isTrueDel() {
		return true;
	}

	
}
