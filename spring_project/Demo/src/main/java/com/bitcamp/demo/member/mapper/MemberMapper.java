package com.bitcamp.demo.member.mapper;

import java.util.List;

import com.bitcamp.demo.member.domain.Member;
import com.bitcamp.demo.member.domain.SearchType;

public interface MemberMapper {
	
	//로그인
	Member selectByIdPw(String id, String pw);
	//아이디 체크
	int selectById(String memberId);
	//회원가입
	int insertMember(Member member);
	//회원정보 수정
	int updateMember(Member member);
	//회원정보삭제
	int deleteMember(int idx);
	//회원리스트
	List<Member> selectAll();
	//페이징 처리가 가능한 리스트
	List<Member> selectList(int startRow, int count); // (0,3)
	//전체 회원수
	int selectTotalCount();
	
	//검색을 통한 회원 리스트
	List<Member> selectMember(SearchType searchType);
	
	// Rest get : idx 값으로 Member 객체를 반환
	Member selectByIdx(int idx);
	
}
