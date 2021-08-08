package com.bitcamp.mm.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/member/login")
@Controller
public class LoginController {

	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm() {
		
		
		return "member/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login() {
		
		
		return "member/login";
	}
	
}

