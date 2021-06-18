package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DeptDao { //sql 처리만 하는 클래스 (자바 프로그램과 데이터베이스 연결해서 처리하는것만 한다)

	////싱글톤 패턴 : 여러개의 인스턴스를 생성하지 못하도록 하는 코딩 스타일 ( 디자인 패턴) --- 메소드에 기능만 있을경우에는 굳이 인스턴스를만들어서 쓸 필요가 없다. 그래서 이런식으로 사용한다./아니면 만들면 안되는경우 하나만존재해야할경우 이렇게사용한다.
	//스프링에서는 이런 패턴의 프레임 워크를 사용한다. 하지만 알고있어야한다. 
	
	// 1. 외부 클래스 또는 인스턴스에서 해당 클래스로 인스턴스를 생성하지 못하도록 처리.
	private DeptDao(){   //생성자에 프라이빗 붙인다. 외부에서 생성자 호출 불가능.외부에서 인스턴스 호출이 불가능해진다.
		
	}
	// 2. 클래스 내부에서 인스턴스를 만들고 
	static private DeptDao dao= new DeptDao() ;  //스테틱붙여줌. 생성자호출이 가능하다. 수정하지못하도록 private 사용// 스테틱은 프로그램 시작할때 메모리에 올라가기때문에 바로 인스턴스생성됨.
	
	
	// 3. 메소드를 통해서 반환하도록 처리 
	public static DeptDao getInstance() { // 요것도 스테틱. // 클래스 내부에서 만든 인스턴스를 반환함. //외부에서 DeptDao 인스턴스를 쓰고 싶으면 이 메소드를 통해서만 사용가능하다. 새로 만들진 못한다. 하나만 생성
		return dao;
	}
	
	
	
	
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

			result = pstmt.executeUpdate(); //값이 0아니면 1 ,, 숫자

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


	//4. DEPT 테이블의 데이터 삭제하는 메소드
	// 삭제된 행의 갯수를 반환
	// 사용자로부터 deptno 받아서 처리
	int deleteDept (Connection conn, int deptno) {

		int result = 0;

		//데이터베이스 처리 sql
		PreparedStatement pstmt = null;

		String sql = "delete from dept where deptno =?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);

			result=pstmt.executeUpdate();






		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt !=null) {
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