package com.bitcamp.mm.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/member/regform")
@Controller
public class MemberRegController {

	@RequestMapping(method=RequestMethod.GET)
	public String getRegForm() {
		
		return "member/regForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String regForm() {
		
		return "member/regForm";
	}
}
