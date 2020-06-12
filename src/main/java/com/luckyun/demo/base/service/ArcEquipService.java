package com.luckyun.demo.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckyun.core.data.BaseMapper;
import com.luckyun.core.data.BaseService;
import com.luckyun.demo.base.entity.ArcEquip;
import com.luckyun.demo.base.mapper.ArcEquipMapper;

@Service
public class ArcEquipService extends BaseService<ArcEquip>{

	@Autowired
	ArcEquipMapper arcEquipMapper;
	
	public List<ArcEquip> readAll(ArcEquip arcEquip){
		
		return arcEquipMapper.readAll(arcEquip);
	}
	
	@Override
	public BaseMapper<ArcEquip> getMapper() {
		return arcEquipMapper;
	}

}
