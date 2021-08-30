package com.bitcamp.orl.mountain.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.mountain.dao.Dao;
import com.bitcamp.orl.mountain.domain.MountainLocInfo;

@Service
public class MountainLocInfoViewService {
	
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//지역별 산 리스트
	public List<MountainLocInfo> getMountainLocInfo(String loc){
		List<MountainLocInfo> mountainLocInfoList = null;
		if (loc != null) {
			dao = template.getMapper(Dao.class);
			mountainLocInfoList = dao.selectByLocName(loc);
		}
		return mountainLocInfoList;
	};
	
	//지역별 산 리스트 높이순
	public List<MountainLocInfo> getMountainLocInfo2(String loc){
		List<MountainLocInfo> mountainLocInfoList = null;
		if (loc != null) {
			dao = template.getMapper(Dao.class);
			mountainLocInfoList = dao.selectByLocName(loc);
		}
		return mountainLocInfoList;
	};
	
	//지역별 산 갯수
	public int getCountLoc(String loc) {
		int result = 0;
		if(loc !=null) {
			dao= template.getMapper(Dao.class);
			result=dao.countByLocName(loc);
		}
		return result;
	}

}
