package dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dept.domain.Dept;
import jdbc.util.JdbcUtil;

public class DeptDao { //메서드만 있는 클래스 => 싱글톤 패턴으로 만들자
	
	// 싱글톤 패턴
	// 1. 인스턴스 생성을 막는다 !! (생성자통해서 막기)
	private DeptDao() {} //외부에서 생성자 호출 불가
	
	//2. 클래스 내부에서 인스턴스를 생성 !!
	private static DeptDao dao = new DeptDao(); //인스턴스변수를 스테틱으로 생성 => 스테틱은 클래스로드될때 선언되고 처리됨(외부에선 못쓰게 프라이빗)
	
	//3. 외부에서 참조값을 반환 받을 수 있는 메서드 필요
	public static DeptDao getInstance() {
		//return dao;
		return dao==null? new DeptDao() : dao ; //삼항연산자. 이렇게 사용하기도 한다.
	}
	

	public List<Dept> getDeptList(Connection conn){
		
		Statement stmt= null; 
		ResultSet rs = null;
		List<Dept> list = null;

		try {
			// 3. Statement 객체 만들기
			stmt = conn.createStatement();
			
			//sql
			String sql = "select * from dept";
			
			
			// 4. ResultSet
			rs= stmt.executeQuery(sql);
			
			// 5. List<Dept>   <- 결과 
			list = new ArrayList<Dept>();
			
			
			while(rs.next()){
				//List에 객체 추가
				list.add(makeDept(rs));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		
		
				
		return  list;
	}
	
	
	public int insertDept(Connection conn, Dept dept) {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into dept values (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			resultCnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		
		
		return resultCnt;
		
	}
	
	
	
	public int deleteDept(Connection conn, int deptno) {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "delete from dept where deptno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
	
		
		
		
		return resultCnt;
	}
	
	
	
	public Dept selectByDeptno(Connection conn, int deptno) {
		
		Dept dept = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select *from dept where deptno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dept = makeDept(rs);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		return dept;
	}
	
	
	
	public int updateDept(Connection conn, Dept dept) {
		
		int resultCnt=0;
		PreparedStatement pstmt = null;
		
		String sql = "update dept set dname = ?, loc=? where deptno=?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			resultCnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
				
		
		return resultCnt;
	}
	
	
	
	//new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)); 중복코드 없애기
	private Dept makeDept(ResultSet rs) throws SQLException {
		
		Dept dept = new Dept();
		dept.setDeptno(rs.getInt("deptno"));
		dept.setDname(rs.getString("dname"));
		dept.setLoc(rs.getString("loc"));
		
		return dept;
		
	}	
	
	
}




























