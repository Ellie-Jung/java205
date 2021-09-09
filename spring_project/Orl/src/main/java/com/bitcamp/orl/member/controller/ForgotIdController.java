package com.bitcamp.orl.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForgotIdController {
	
	@RequestMapping("/member/mypage/forgotId")
	public String getForgotId() {
		return "member/forgotId";
	}
}
