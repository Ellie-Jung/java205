package com.bitcamp.orl.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.orl.admin.domain.Crew;
import com.bitcamp.orl.admin.domain.CrewMemberList;

public interface Dao {

	// 관리자 crew 전체 리스트
	List<Crew> selectCrewListByAdmin();

	// 관리자 crewReg 전체 리스트
	List<CrewMemberList> selectAllCrewMemberList();


	// 크루 삭제
	int deleteCrew(@Param("crewIdx") int crewIdx);
	
	
}
