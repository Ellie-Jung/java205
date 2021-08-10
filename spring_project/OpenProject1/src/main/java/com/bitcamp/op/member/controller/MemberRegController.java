package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.op.member.domain.RegFormRequest;
import com.bitcamp.op.member.service.MemberRegService;


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
		model.addAttribute("result", result);
		
		String view = "member/reg_view" ;
		if(result == 1) {
			// 인텍스 페이지로 리다이렉트
			view = "redirect:/index";
		}
		return view;
		
	}
}
