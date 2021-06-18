package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DeptDao { //sql 처리만 하는 클래스 (자바 프로그램과 데이터베이스 연결해서 처리하는것만 한다)

	//1. 전체 데이터 검색 기능
	//반환 타입은 List <Dept> 
	//매개변수 - Connection 객체 : Statement 만들기위해 필요
	ArrayList<Dept> getDeptList(Connection conn) { 



		ArrayList<Dept> list = null;

		//데이터 베이스의 테이블 이용 select결과를 -> list에 저장 
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from dept order by deptno";

			//결과 받아오기
			rs = stmt.executeQuery(sql);

			list = new ArrayList<>();

			//데이터를 Dept 객체로 생성 -> list에 저장
			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2),  rs.getString(3)));



			}




		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}




		return list;
	}

	//2.DEPT 테이블에 데이터를 저장하는 메소드
	//반영 횟수 반환 
	//사용자로부터 데이터 받기 -> Dept 객체 
	int insertDept (Connection conn, Dept dept) {

		int result = 0;

		//전달 받은 Dept 객체의 데이터로 Dept 테이블에 저장 -> 결과 값을 반환
		PreparedStatement pstmt = null;

		try {

			String sql = "insert into dept  values (dept01_deptno_seq.nextval,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());

			result = pstmt.executeUpdate();

		} catch  (SQLException e) {
			e.printStackTrace();

		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return result;

	}


	//3. DEPT 테이블의 데이터 수정 메소드 
	//반영된 행의 개수 반환
	//사용자로부터 데이터를 받아서 처리하자 -> Dept 객체
	int editDept(Connection conn, Dept dept) {
		
		int result = 0;

		//전달 받은 Dept 객체의 데이터로 Dept 테이블에 저장 -> 결과 값을 반환
		PreparedStatement pstmt = null;

		try {

			String sql = "update dept set dname =?, loc = ? where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			

			result = pstmt.executeUpdate();

		} catch  (SQLException e) {
			e.printStackTrace();

		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return result;


	}
}