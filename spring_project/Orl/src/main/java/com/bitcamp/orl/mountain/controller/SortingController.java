package com.bitcamp.orl.mountain.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.orl.mountain.domain.MountainLocInfo;
import com.bitcamp.orl.mountain.service.SortingService;

@Controller
public class SortingController {

	@Autowired
	private SortingService service;
	
	/*
	 * @RequestMapping(value="/mountain/sorting", method = RequestMethod.POST)
	 * public String sorting(HttpServletRequest request, Model model) {
	 * 
	 * String loc = null; loc = request.getParameter("locName");
	 * List<MountainLocInfo> mountainLocInfoList = null; mountainLocInfoList =
	 * service.sorting(loc);
	 * model.addAttribute("mountainLocInfoList",mountainLocInfoList);
	 * model.addAttribute("loc", loc);
	 * 
	 * return "member/sorting"; }
	 */
	
}
