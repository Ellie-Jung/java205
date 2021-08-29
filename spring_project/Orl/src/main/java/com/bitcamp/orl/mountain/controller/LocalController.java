package com.bitcamp.orl.mountain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("mountain/local")
public class LocalController {

	@RequestMapping(method = RequestMethod.GET)
	public String local() {
		return "mountain/local";
	}
}
