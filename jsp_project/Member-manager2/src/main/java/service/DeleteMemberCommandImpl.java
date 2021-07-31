package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import domain.Member;
import util.ConnectionProvider;
import util.JdbcUtil;

public class DeleteMemberCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int resultCnt = 0;
		Connection conn=null;
		MemberDao dao=null;
		String idx = request.getParameter("idx");
		
		
		try {
			conn = ConnectionProvider.getConnection();
			dao=MemberDao.getInstance();
			resultCnt=dao.deleteMember(conn,Integer.parseInt(idx));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		
		
		
		request.setAttribute("result", resultCnt);
		
		return "/WEB-INF/views/delete.jsp";
	}

}
