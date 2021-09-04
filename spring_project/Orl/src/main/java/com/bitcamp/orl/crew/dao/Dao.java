package com.bitcamp.orl.crew.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.member.domain.Member;

public interface Dao {

	
	List<Crew> selectAll();
	
	
	
}
