package com.bitcamp.demo.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.demo.member.domain.Member;
import com.bitcamp.demo.member.domain.MemberRegRequest;
import com.bitcamp.demo.member.service.MemberRegService;
import com.bitcamp.demo.member.service.MemberRestService;

//@Controller
@RestController
public class MemberRestController {
	
	@Autowired
	private MemberRestService restService;
	
	@Autowired
	private MemberRegService regService;
	
	
	@RequestMapping("/members/{id}")
	@CrossOrigin
	public Member getMember(
			@PathVariable("id") int idx
			) {
		Member member = restService.getMember(idx);
		System.out.println(member);
		return member;
	}
	@GetMapping("/members")
	@CrossOrigin  //어디에서 요청이들어오든 상관없이 허용해줌
	public List<Member> getMembers(){
		return restService.getMembers();
	}
	
	@GetMapping("/members1")
	public Map<Integer, Member> getMembers1(){
		
		return restService.getMembers1();
	}
	
	@PostMapping("/members/reg1")
	@CrossOrigin
	public String regMember1(
			MemberRegRequest regRequest,
			HttpServletRequest request
			) {
		System.out.println(regRequest);
		return Integer.toString(regService.memberReg(regRequest, request));
	}
	
	
	@PostMapping("/members/reg2")
	@CrossOrigin
	public String regMember2(
			@RequestBody MemberRegRequest regRequest,
			HttpServletRequest request
			) {
		System.out.println(regRequest);
		return Integer.toString(regService.memberReg(regRequest, request));
	}
	
}



