package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.domain.Member;
import com.bitcamp.mm.member.domain.RegFormRequest;
import com.bitcamp.mm.util.ConnectionProvider;

@Service
public class MemberRegService {
	
	@Autowired
	MemberDao dao;
	

	public int regMember(RegFormRequest regFormRequest,HttpServletRequest request) {
		int resultCnt= 0;
		Member member=new Member();
		Connection conn=null;

		System.out.println(regFormRequest.getMemberid());
		System.out.println(regFormRequest.getMemberName());
		////////////////////////////////////////////////////////////////
		// DB insert
		//Connection, MemberDao
		
		try {
			conn = ConnectionProvider.getConnection();
			
			member.setMemberid(regFormRequest.getMemberid());
			member.setPassword(regFormRequest.getPassword());
			member.setMembername(regFormRequest.getMemberName());
			
			resultCnt =dao.insertMember(conn, member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		
		request.setAttribute("result", resultCnt);
		
		
		
		return resultCnt; //정상적으로 처리되면 결과1나온다.
	}
	
}
