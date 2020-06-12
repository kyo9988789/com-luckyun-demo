package com.luckyun.demo.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luckyun.demo.base.entity.ArcEquip;
import com.luckyun.demo.base.service.ArcEquipService;

@RequestMapping("arc/equip")
@RestController
public class ArcEquipController {

	@Autowired
	ArcEquipService arcEquipService;
	
	@RequestMapping("/readAll")
	public List<ArcEquip> readAll(ArcEquip arcEquip){
		Long iparentid = arcEquip.getIparentid() != null ? arcEquip.getIparentid() : 0L;
		arcEquip.setIparentid(iparentid);
		return arcEquipService.readAll(arcEquip);
	}
}
