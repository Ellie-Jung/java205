package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	// GreetingCommandImpl
	// 메서드가 추상메서드
	// public abstract 생략 
	String getPage(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
}
