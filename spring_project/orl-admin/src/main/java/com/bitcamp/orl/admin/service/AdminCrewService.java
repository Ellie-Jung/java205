package com.bitcamp.orl.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.admin.dao.Dao;
import com.bitcamp.orl.admin.domain.Crew;
import com.bitcamp.orl.admin.domain.CrewMemberList;



@Service
public class AdminCrewService {

		//크루의 Dao
		private Dao dao;
		
		@Autowired
		private SqlSessionTemplate template;
		
		// 크루 삭제
		public int deleteCrew(int crewIdx) {
			return template.getMapper(Dao.class).deleteCrew(crewIdx);
		}
		
		//관리자용 크루 리스트 가져오기 
		public List<Crew> getCrewListAdmin(){ 
			dao = template.getMapper(Dao.class); 
			return dao.selectCrewListByAdmin(); 
		}
		
		
		// 크루reg테이블- 가입크루 모두 읽어오는 리스트
		public List<CrewMemberList> getCrewRegList(){
			dao = template.getMapper(Dao.class);
			List<CrewMemberList> list = dao.selectAllCrewMemberList();
			return list;
		}
		
		
}
