package com.bitcamp.mm.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.mm.member.domain.RegFormRequest;
import com.bitcamp.mm.member.service.MemberRegService;

@RequestMapping("/member/regform")
@Controller
public class MemberRegController {

	@Autowired
	private MemberRegService memberRegservice;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getRegForm() {
		
		return "member/regForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String regForm(RegFormRequest regFormRequest,HttpServletRequest request,Model model) {
		
		int result=memberRegservice.regMember(regFormRequest, request);
//		request.setAttribute("result", result);
		System.out.println(regFormRequest);
//		request.getSession(false).setAttribute("loginInfo", );
		
		return "member/reg_view";
	}
}
