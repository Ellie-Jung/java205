package com.bitcamp.orl.crew.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.Crew;



@Service
public class CrewListViewService {
	
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	public List<Crew> getCrewListAll(){
		dao = template.getMapper(Dao.class);
		return dao.selectAll();
	}
	
	
}