package com.bitcamp.mm.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.mm.member.service.LoginService;


@RequestMapping("/member/login")
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm() {
		
		
		return "member/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("memberid") String memberid, 
						@RequestParam("password") String password, 
						@RequestParam(value = "reid",required = false) String reid, 
						HttpSession session,
						HttpServletResponse response,  /*쿠키 받기 위해서 response필요하다*/
						Model model) {
		
		boolean loginChk=loginService.login(memberid, password, reid, session, response);

		model.addAttribute("loginChk", loginChk);
		return "member/login";
	}
	
}

