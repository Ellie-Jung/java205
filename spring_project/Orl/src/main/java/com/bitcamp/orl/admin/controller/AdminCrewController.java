package com.bitcamp.orl.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.admin.service.AdminCrewService;
import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewMemberList;
import com.bitcamp.orl.crew.service.CrewListViewService;
import com.bitcamp.orl.crew.service.CrewMemberMngService;
import com.bitcamp.orl.member.service.RegService;

@Controller
public class AdminCrewController {

	@Autowired
	private CrewListViewService service;
	@Autowired
	private AdminCrewService regListService;
	
	@RequestMapping("/admin/crew")
	public String CrewList() {
		
		/*
		 * List<Crew> crewList = null; List<CrewMemberList> crewRegList= null;
		 * 
		 * crewList=service.getCrewListAdmin();
		 * crewRegList=regListService.getCrewRegList();
		 * model.addAttribute("crewList",crewList);
		 * model.addAttribute("crewRegList",crewRegList);
		 */
		
		return "admin/admin_crew";
	}
	
}
