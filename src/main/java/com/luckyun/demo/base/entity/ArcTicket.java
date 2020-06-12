package com.luckyun.demo.base.entity;

import com.luckyun.model.data.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ArcTicket extends BaseEntity{

	private Long indocno;
	
	private String sno;
	
	private String sname;
	
	private Long iequipid;
	
	private Long igroupid;

	@Override
	public boolean __isTrueDel() {
		// TODO Auto-generated method stub
		return false;
	}
}
