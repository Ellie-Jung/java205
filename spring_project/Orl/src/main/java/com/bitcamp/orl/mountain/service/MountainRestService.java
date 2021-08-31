package com.bitcamp.orl.mountain.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.mountain.dao.Dao;
import com.bitcamp.orl.mountain.domain.MountainLocInfo;

@Service
public class MountainRestService {

	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//지역별 산 리스트 높이순
	public List<MountainLocInfo> getSortingHeight(String loc){
		List<MountainLocInfo> mountainLocInfoList = null;
		dao=template.getMapper(Dao.class);
		mountainLocInfoList = dao.selectByLocName2(loc);
		return mountainLocInfoList;
	};
	
	//이름별 산 리스트 높이순
		public List<MountainLocInfo> getSortingHeight2(String loc){
			List<MountainLocInfo> mountainLocInfoList = null;
			dao=template.getMapper(Dao.class);
			mountainLocInfoList = dao.selectByLocName(loc);
			return mountainLocInfoList;
		};
	
	/*
	 * //지역별 산 리스트 높이순 public List<MountainLocInfo> getSortingHeight(String loc){
	 * List<MountainLocInfo> mountainLocInfoList = null;
	 * dao=template.getMapper(Dao.class); mountainLocInfoList =
	 * dao.selectByLocName2(loc); System.out.println(mountainLocInfoList); return
	 * mountainLocInfoList; };
	 */
	
}
