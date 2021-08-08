package com.bitcamp.mm.member.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bitcamp.mm.member.domain.Member;

public interface Dao {

	int insertMember(Connection conn, Member member) throws SQLException;
	List<Member> selectList(Connection conn);
	Member selectByIdPw(Connection conn, String id, String pw);
	int selectById(Connection conn, String memberId) throws SQLException;
	int deleteMember(Connection conn,int idx ) throws SQLException;
	int updateMember(Connection conn,Member member ) throws SQLException;
}
