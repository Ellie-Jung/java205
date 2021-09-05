package com.bitcamp.orl.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.admin.service.AdminMemberService;
import com.bitcamp.orl.member.domain.Member;

@Controller
public class AdminMemberDeleteController {

	@RequestMapping("/admin/member/delete")
	public String MemberList(HttpServletRequest request, Model model) {
		
		
		return "admin/admin_memberDelete";
	}
	
}
