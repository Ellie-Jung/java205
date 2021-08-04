package com.bitcamp.firstSpring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.firstSpring.member.domain.LoginRequest;

@Controller
@RequestMapping("/member/login") //이거해주면 기본경로 설정하는것..// 브라우저에서 사용하는 url경로. http://localhost:8080/mvc(이까지가 contextPath)/member/login
public class LoginController {

	//똑같은 url들어와도 방식에따라 다른페이지 보여줄수있다.
//	@RequestMapping("/member/loginForm")
//	@RequestMapping(value = "/member/login", method=RequestMethod.GET) //겟방식으로 url직접 치고 들어올경우
	@RequestMapping( method=RequestMethod.GET) //겟방식으로 url직접 치고 들어올경우
//	public String getLoginForm(@RequestParam("page") int page) { //매개변수 값은 필수기떄문에 없으면 오류생김( url뒤에 ?page=1 값이 있어야함) -> required 값 디폴트가 true
//	public String getLoginForm(@RequestParam(value= "page", required=false) String page) { //required false하면 null이어도 괜춘(문자열로받기). 근데 int page하면 오류(null값이 안되니까). String으로 다 받고 내부에서 형변환해서 처리할것.
	public String getLoginForm(@RequestParam(value= "page", defaultValue = "1") String page) { //값이 안들어오면 1로 설정. 파라미터는 문자열로 설정한다. 이떄도 무조건 String으로 체크하는게 안전하다. 
		
	//	System.out.println(page+1);
		return "member/loginForm"; // WEB-INF/views/member/loginForm.jsp 응답을 만들어줄 jsp의 경로 
		//뷰 페이지 정보(이름)를 반환하는 메서드
	}
	
	// 위쪽에 기본경로 설정시 벨류값 설정하면 /meber/login/member/login 두번들어가게된다. 그래서 한개는 뺴줘야함(경로가겹치지않도록)
//	@RequestMapping(value = "/member/login", method=RequestMethod.POST) // 폼에서 post 방식으로 전달될경우
	@RequestMapping(method=RequestMethod.POST) // 폼에서 post 방식으로 전달될경우
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw,
						HttpServletRequest request,@ModelAttribute("loginReq") LoginRequest loginRequest, Model model) { //우리가호출 안함. mvc내부에서 저 url 포스트요청으로 들어오면 알아서 호출 //@ModelAttribute("모델이름지정") 공유될떄 이름속성을 저걸로 지정한다.
		
		// 사용자의 파라미터 데이터를 받는 방법
		// 1. HttpServletRequest 이용                  -> 리퀘스트 사용할 일이 있을때 
		// 2. @RequestParam("파라미터이름")  이용  -> 간단한 데이터 하나 받는경우
		// 3. 커멘드 객체(Beans) 이용                        -> 한번에 여러개의 데이터 받는경우
		
		System.out.println(id+" : "+pw); //애노테이션 @requestParam 이용해서 받아온 값 출력
		
		// 뷰에 전달할 데이터 저장 : Model 객체를 이용 (매개변수에 정의해주고 !) -> 뷰만 반환할때 (반환타입이 스트링)
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		String uid= request.getParameter("id");
		String upw= request.getParameter("pw");
		
		System.out.println(uid+" : "+upw); //request에서 파라미터 받아와서 출력
		
		model.addAttribute("uid", uid);
		model.addAttribute("upw", upw);
		
		System.out.println(loginRequest); //loginRequest 빈즈 만들어서 출력 (폼이랑 도메인의 속성 이름 같아야함)
		
		return "member/login"; // WEB-INF/views/member/login.jsp
	}
	
}
