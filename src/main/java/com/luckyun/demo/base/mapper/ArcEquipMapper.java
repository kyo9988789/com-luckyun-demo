package com.luckyun.demo.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.luckyun.core.data.BaseMapper;
import com.luckyun.demo.base.entity.ArcEquip;

@Repository
public interface ArcEquipMapper extends BaseMapper<ArcEquip>{

	List<ArcEquip> readAll(@Param("condition") ArcEquip condition);
}
