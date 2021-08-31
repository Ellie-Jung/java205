package com.bitcamp.orl.mountain.dao;

import java.util.List;


import com.bitcamp.orl.mountain.domain.MountainLocInfo;
import org.apache.ibatis.annotations.Param;


public interface Dao {
	
	// 지역별 산 리스트
	List<MountainLocInfo> selectByLocName(String loc);
	// 지역별 산 리스트 높이순
	List<MountainLocInfo> selectByLocName2(String loc);
	
	//지역별 산 갯수
	int countByLocName(@Param("locName")String locName);
}
