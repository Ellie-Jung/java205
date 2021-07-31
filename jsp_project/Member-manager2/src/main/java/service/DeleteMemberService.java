package service;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDao;

public class DeleteMemberService {

	//싱글톤 처리
	private DeleteMemberService() {}
	private static DeleteMemberService service= new DeleteMemberService();
	public static DeleteMemberService getInstance() {
		return service;
	}
	
	public int deleteMember(HttpServletRequest request){
		
		int resultCnt = 0;
		Connection conn=null;
		MemberDao dao= null;
		
		
		
		
		
		return resultCnt;
	}
	
	
	
}
