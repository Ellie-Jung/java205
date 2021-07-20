package jdbc.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCTestDeptDML2 {

	public static void main(String[] args) {

		//연결 객체 : 연결 정보를 가진다.
		Connection conn = null;          //try-catch문 밖에 변수를 선언해야한다.
		//sql을 실행할 메소드 제공
		Statement stmt = null;
		//executeQuery () 반환타입 -> select의 결과 (표)를 담는 객체 
		ResultSet rs = null;
		//Statement -> PreparedStatement : 성능개선
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);

		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공 !");

			//2. 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";

			conn = DriverManager.getConnection(jdbcUrl,user,pw);
			System.out.println("데이터 베이스 연결 성공");

			//트랜젝션 설정
			conn.setAutoCommit(false);
			
			
			System.out.println("부서 정보의 삭제를 시작합니다. ");
			System.out.println("부서 번호를 입력해주세요. ");
			String deptno  = sc.nextLine();
			
			
			//3. sql처리
			// 사용자에게 정보를 받아서 부서 데이터를 삭제하는 프로그램을 만들어보자.
			
			String sql = "delete from dept01 where deptno = ?";
			pstmt  = conn.prepareStatement(sql);   //PreparedStatement
			pstmt.setInt(1, Integer.parseInt(deptno));
			
			int result = pstmt.executeUpdate(); 
			
			if (result >0) {
				
				System.out.println(result +"개 행이 삭제되었습니다.");
			}else {
				System.out.println("조건에 맞는 데이터가 존재하지 않습니다.");
			}
			
			
			
			
			//트랜젝션 완료 (성공) -> 물리적 저장
			conn.commit(); 
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스 찾지못함 !!!");
			e.printStackTrace();
			
		}catch (SQLException e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
			}
			
		}finally {
			//4. close
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			if(conn !=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}



	}

}
