package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.Dao;
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.LoginInfo;
import com.bitcamp.op.member.domain.Member;

@Service
public class LoginService {
	
//	@Autowired
//	MemberDao dao;
	
//	@Autowired
//	private JdbcTemplateMemberDao dao;
	
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public boolean login(String id, String pw,String reid, 
						 HttpSession session,HttpServletResponse response) {
		
		boolean loginChk=false;
		
		
		// 전달받은 id와 pw로 DB에서 검색 
		//=> 있다면 로그인 처리 true return, 
		//=> 없다면 false return
		Member member=dao.selectByIdPw(id, pw);
		
		if(member !=null) {
			// 로그인 처리
			session.setAttribute("loginInfo", member.toLoginInfo());
			
			loginChk=true;
		}
		
		//아이디 저장을 위한 Cookie 설정
		if(reid!=null && reid.length()>0) {
			Cookie cookie= new Cookie("reid", id);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24);
			
			response.addCookie(cookie);
		}else {
			Cookie cookie= new Cookie("reid", id);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			
			response.addCookie(cookie);
		}
		
		
		
		return loginChk;
	}
}
