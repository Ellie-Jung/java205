package com.bitcamp.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.Dao;

@Service
public class IdCheckService {
	
//	@Autowired
//	private JdbcTemplateMemberDao dao;
	
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	public String idCheck(String id) {
		
		String result = "Y";
		
		// 인터페이스의 매퍼 Dao 생성
		dao=template.getMapper(Dao.class);
		
		if(dao.selectById(id)>0) {
				result="N";
		}
		return result;
	}

}