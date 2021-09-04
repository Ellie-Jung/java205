package com.bitcamp.orl.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.member.dao.Dao;
import com.bitcamp.orl.member.domain.Member;

@Service
public class AdminMemberService {

	//멤버의 Dao
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//모든 멤버 리스트
	public List<Member> getMemberList(){
		
		return template.getMapper(Dao.class).selectAll();
		
	}
	
}
