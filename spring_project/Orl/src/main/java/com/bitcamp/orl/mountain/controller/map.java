package com.bitcamp.orl.mountain.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class map {
	
	@RequestMapping("/mountain/map")
	public String getMountainAll() {
		return "mountain/map";
	}
	
}