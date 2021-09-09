package com.bitcamp.orl.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForgotIdViewController {
	
	@RequestMapping("/member/mypage/forgotIdView")
	public String getForgotId() {
		return "member/forgotIdView";
	}
}
