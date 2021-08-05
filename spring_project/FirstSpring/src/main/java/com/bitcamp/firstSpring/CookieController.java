package com.bitcamp.firstSpring;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	// 쿠키를 생성해주는 요청 처리
	@RequestMapping(value ="/cookie/make")
	public String makeCookie(HttpServletResponse response) {
		
		Cookie c= new Cookie("username", "KING");
		response.addCookie(c);
		
		// Service.process(response)
		
		return "cookie/make";
	}
	
	@RequestMapping("/cookie/view")
	public String viewCookie(
//					@CookieValue(value="usernames", required = false) String userName // 없는 벨류 이름 넣을때 false넣으면 널로 들어간다. 
					@CookieValue(value="usernames", defaultValue = "SCOTT") String userName, /*쿠키값 없으면 디폴트밸류로 스캇 넣자*/
					Model model 
					) {
											
		model.addAttribute("userName",userName);
		System.out.println(userName);
		// .. Cookie 정보를 이용해서 데이터 처리
		
		
		return "cookie/view";
	}
	
}
