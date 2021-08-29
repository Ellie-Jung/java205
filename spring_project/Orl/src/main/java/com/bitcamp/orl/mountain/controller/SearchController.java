package com.bitcamp.orl.mountain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("mountain/search")
public class SearchController {

	@RequestMapping(method = RequestMethod.GET)
	public String local() {
		return "mountain/search";
	}
}
