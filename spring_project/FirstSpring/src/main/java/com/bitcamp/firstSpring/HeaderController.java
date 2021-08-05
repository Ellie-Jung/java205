package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {
	
	@RequestMapping("/header/header")
	public String getHeader(@RequestHeader("referer" ) String reString , Model model ) {
		
		System.out.println(reString);
		model.addAttribute("re",reString);
		
		return "header/headerInfo";
//		return "redirect:"+reString;  // view 이름에 "redirect:" 붙이면 지정한 페이지로 리다이렉트됨
	}
}
