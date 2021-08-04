package com.bitcamp.firstSpring.member.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.firstSpring.member.domain.LoginRequest;
import com.bitcamp.firstSpring.member.domain.RegFormRequest;

@Controller
@RequestMapping("/member/regform")
public class MemberRegController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getRegForm() {
		
		return "member/memberRegForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String regForm(@RequestParam("memberid")String memberid,@RequestParam("password")String password,
						@RequestParam("membername")String membername,@RequestParam("photo")File photo,
						@ModelAttribute("regReq") RegFormRequest regFormRequest,
						Model model) {
		
		
		
		
		model.addAttribute("memberid",memberid);
		model.addAttribute("password",password);
		model.addAttribute("membername",membername);
		model.addAttribute("photo",photo);
		
		return "member/regForm";
	}
	
	
	
}
