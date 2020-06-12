package com.luckyun.demo.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.luckyun.core.data.BaseMapper;
import com.luckyun.demo.base.entity.ArcTicket;

@Repository
public interface ArcTicketMapper extends BaseMapper<ArcTicket>{

	List<ArcTicket> readAll(@Param("condition") ArcTicket condition);
}
