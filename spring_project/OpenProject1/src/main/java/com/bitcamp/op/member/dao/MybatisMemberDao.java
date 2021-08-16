package com.bitcamp.op.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.SearchIdPw;

@Repository
public class MybatisMemberDao {
	
	@Autowired
	private SqlSessionTemplate template;
	private final String NAME_SPACE="com.bitcamp.op.member.dao.memberMapper";
	
	public int insertMember(Member member) {
		
		return template.update(NAME_SPACE+".insertMember",member);
	}
	
	public Member selectByIdPw(String id, String pw) {
		return template.selectOne(NAME_SPACE+".selectByIdPw", new SearchIdPw(id,pw));
	}
	
	// Id 중복여부 확인을 위한 id 값으로 검색 -> 갯수 반환
	public int selectById(String memberId) {
		return template.selectOne(NAME_SPACE+".selectById", memberId);
	}
	
}
