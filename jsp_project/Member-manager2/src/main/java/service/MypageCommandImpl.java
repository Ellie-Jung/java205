package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MypageCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/WEB-INF/views/mypage.jsp";
	}

}
