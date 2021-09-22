package com.bitcamp.orl.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.admin.domain.Crew;
import com.bitcamp.orl.admin.domain.CrewMemberList;
import com.bitcamp.orl.admin.service.AdminCrewService;

@RestController
public class AdminCrewController {

	
	@Autowired
	private AdminCrewService service;
	
	//크루 리스트
	@GetMapping("/admin/crewList")
	@CrossOrigin
	public List<Crew> getCrewList(){
		return service.getCrewListAdmin();
	}
	//크루의 멤버 리스트
	@GetMapping("/admin/crewMemberList")
	@CrossOrigin
	public List<CrewMemberList> getCrewMemberList(){
		return service.getCrewRegList();
	}
	
	
	
	
	
}
