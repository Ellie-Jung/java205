package com.bitcamp.orl.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.orl.member.domain.Member;
import com.bitcamp.orl.member.domain.MemberEditRequest;
import com.bitcamp.orl.member.domain.MemberVo;
import com.bitcamp.orl.member.service.MypageService;

@Controller
public class MypageController {

   @Autowired
   private MypageService service;

   @RequestMapping(value = "/member/mypage", method = RequestMethod.GET)
   public String getMypage(HttpServletRequest request, Model model) {
      MemberVo memberVo = (MemberVo) request.getSession().getAttribute("memberVo");
      Member member = service.getMemberSelectByIdx(memberVo.getMemberIdx());
      model.addAttribute("member", member);
      return "member/mypage";
   }

   @RequestMapping(value = "/member/mypage", method = RequestMethod.POST)
   public String postMypage(HttpServletRequest request, MemberEditRequest memberEditRequest, Model model) {
      MemberVo memberVo = (MemberVo) request.getSession().getAttribute("memberVo");
      Member member = service.getMemberSelectByIdx(memberVo.getMemberIdx());
      int result = service.editMember(request, member, memberEditRequest);
      model.addAttribute("result", result);
      return "member/update";
   }
   
   @RequestMapping(value="/member/mypage_pw_change", method=RequestMethod.GET)
   public String getPwChangePage(HttpServletRequest request, Model model) {
	  MemberVo memberVo = (MemberVo) request.getSession().getAttribute("memberVo");
      Member member = service.getMemberSelectByIdx(memberVo.getMemberIdx());
      model.addAttribute("member", member);
      return "member/mypagePwChange";
   }
   
   @RequestMapping(value="/member/mypage_pw_change", method=RequestMethod.POST)
   public String getPwChange(HttpServletRequest request, Model model) {
	   MemberVo memberVo = (MemberVo) request.getSession().getAttribute("memberVo");
      Member member = service.getMemberSelectByIdx(memberVo.getMemberIdx());

	   String oldPw=request.getParameter("pw");
	   String newPw=request.getParameter("newpw");
	   String newPw2=request.getParameter("newpw2");
	   int result = service.editPw(oldPw,newPw,newPw2,member);
      model.addAttribute("result", result);
      return "member/changePw";
   }
   
   
}