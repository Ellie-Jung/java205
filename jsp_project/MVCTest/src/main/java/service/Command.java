package service;

import javax.servlet.http.HttpServletRequest;

public interface Command {

	// GreetingCommandImpl
	// 메서드가 추상메서드
	// public abstract 생략 
	String getPage(HttpServletRequest request);
	
}
