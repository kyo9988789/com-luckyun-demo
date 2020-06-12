package com.luckyun.demo.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luckyun.core.annotation.UrlByPkgController;
import com.luckyun.demo.base.entity.ArcTicket;
import com.luckyun.demo.base.mapper.ArcTicketMapper;

@UrlByPkgController
public class ArcTicketController {

	@Autowired
	ArcTicketMapper arcTicketMapper;
	
	@RequestMapping("readAll")
	public List<ArcTicket> readAll(){
		return arcTicketMapper.readAll(new ArcTicket());
	}
}
