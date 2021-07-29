package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Command;
import service.DateCommandImpl;
import service.DateService;
import service.GreetingCommandImpl;
import service.GreetingService;
import service.InvalidCommandImpl;
import service.InvalidService;

public class FrontController extends HttpServlet{

	private Map<String, Command> commands = new HashMap<String, Command>();
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	
		//설정 파일의 경로 가져오기
		String configFile = config.getInitParameter("config"); //경로 넣기
		Properties prop = new Properties(); //  command.properties파일은 키값 = 벨류 로 작성되어있다. 그 키값 밸류 저장할 객체 만들기위해 
		
		FileInputStream fis = null;
		// 설정 파일의 시스템 경로
		String configPath = config.getServletContext().getRealPath(configFile);
		
		
		try {
			fis= new FileInputStream(configPath);
			prop.load(fis);//properties파일 한줄씩 읽음.  다음 = 표시는 끊어서 앞에는 키/ 뒤에는 벨류 라는 값으로 저장하기위함.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator<Object> itr = prop.keySet().iterator(); //이터레이터 반환한다.
		//Iterator로 하나씩 돌릴껀데 itr 는 그 prop - 한줄씩 읽어서 키랑 벨류값으로 저장한것 을 하나씩 돌릴꺼다 키값만가지고 
		
		while(itr.hasNext()) {
			String command = (String)itr.next(); //읽어온 키값을 command에 문자열로 저장   ->키
			String commandClassName = prop.getProperty(command); // prop객체에서 벨류값을 불러내는데 키값 넣어서 불러옴 ->값
			
			//클래스 이름으로 해당 클래스의 인스턴스 생성
			try {
				Class commandClass = Class.forName(commandClassName); //클래스이름으로 클래스를 찾는다.
				Command commandObj = (Command) commandClass.newInstance(); //그 클래스로 객체 만들어준다.
				commands.put(command, commandObj);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}

	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 사용자의 요청을 분석 : URI를 추출해서 사용
		String commandUri= request.getRequestURI();
		//  http://localhost:8080/mvc/guest/list.do  ->  /mvc/guest/list.do 컨텍스트경로 (/mvc)는 배포될때마다 바뀔수도있따.-> 이부분 뺴고 추출하쟈
		
		if(commandUri.indexOf(request.getContextPath()) == 0) { //indexOf(String) -> 해당문자열 시작인덱스
			commandUri = commandUri.substring(request.getContextPath().length()); // subString(index) -> 현재 문자열의 index값부터 끝까지 발췌 
		}
			
		//request.getContextPath() 프로젝트 Path만 가져온다. /mvc 만 가져옴
		//request.getRequestURI()  프로젝트+파일경로까지 가져온다.  /mvc/list.do
		//request.getRequestURL()  전체 경로 가져온다.  http://localhost:8080/project/list.do
		//request.ServletPath()   파일명만 가져온다    /list.do
		//request.getRealPath("")  서버or 로컬 웹 애플리케이션 절대경로 가져온다  c:\project\webapps\projectname\
		
		
		// 결과 Data 
		//Object resultObj = null;
		//view 페이지
		String viewPage = "/WEB-INF/views/default.jsp";
		Command command = null;
		
		command = commands.get(commandUri);
		if(command == null) {
			command = new InvalidCommandImpl();
			
		}
			
		
	
		
		viewPage=command.getPage(request);
		
		
		
		// 4. viewPage로 포워딩 
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); //예외던지기
		
	}
	
}
