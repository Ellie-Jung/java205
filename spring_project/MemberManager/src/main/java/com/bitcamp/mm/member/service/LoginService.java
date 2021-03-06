package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.domain.Member;
import com.bitcamp.mm.util.ConnectionProvider;

@Service
public class LoginService {
	
	@Autowired
	MemberDao dao;
	

	public boolean login(String id, String pw,String reid, 
						 HttpSession session,HttpServletResponse response) {
		
		boolean loginChk=false;
		
		Connection conn=null;
		
		try {
			conn=ConnectionProvider.getConnection();
			
			// 전달받은 id와 pw로 DB에서 검색 
			//=> 있다면 로그인 처리 true return, 
			//=> 없다면 false return
			Member member=dao.selectByIdPw(conn, id, pw);
			
			if(member !=null) {
				// 로그인 처리
				session.setAttribute("loginInfo", member.toLoginInfo());
				
				loginChk=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//아이디 저장을 위한 Cookie 설정
		if(reid!=null && reid.length()>0) {
			Cookie cookie= new Cookie("reid", reid);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24);
			
			response.addCookie(cookie);
		}else {
			Cookie cookie= new Cookie("reid", reid);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			
			response.addCookie(cookie);
		}
		
		
		
		return loginChk;
	}
	
}
