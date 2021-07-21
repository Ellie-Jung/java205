package jdbc.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Loader extends HttpServlet{

	@Override
	public void init() throws ServletException { //톰캣 컨테이너 시작할때 해야할 작업이있으면 이렇게 시작한다.

		//데이터 베이스 드라이버 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("드라이버 로드 성공!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!");
		}
		
	}
	
	
	
}
