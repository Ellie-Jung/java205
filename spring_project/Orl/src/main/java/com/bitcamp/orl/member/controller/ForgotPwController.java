package com.bitcamp.orl.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForgotPwController {
	
	@RequestMapping("/member/mypage/forgotPw")
	public String getForgotId() {
		return "member/forgotPw";
	}
}
