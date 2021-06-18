package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTest {

	public static void main(String[] args) {

		//연결 객체 : 연결 정보를 가진다.
		Connection conn = null;          //try-catch문 밖에 변수를 선언해야한다.
		//sql을 실행할 메소드 제공
		Statement stmt = null;
		//executeQuery () 반환타입 -> select의 결과 (표)를 담는 객체 
		ResultSet rs = null;
		//Statement -> PreparedStatement : 성능개선
		PreparedStatement pstmt = null;

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

			
			//3. sql처리
			
			stmt = conn.createStatement();
			
			int dno= 10; // 이런식으로 해당하는 정보 찾을수 있고, 사용자에게 입력 받을수도 있다. 
			String otype = "deptno";
			
			String sqlSelect = "select * from dept where deptno="+dno+" order by "+otype ;
			
			
	
			
			rs =stmt.executeQuery(sqlSelect); //resultSet 반환한다.
			
			//rs.next() -> 다음행의 존재 유무 확인
			while(rs.next()) { //true일때, 다음행이 있을때 
				int deptno = rs.getInt("deptno");
				System.out.print(deptno+"\t");
				String dname = rs.getString("dname");
				System.out.print(dname+"\t");
				String loc = rs.getString("loc");
				System.out.println(loc+"\t");
			}
			
			
			//////////////////////////////////////////////////
			///PreparedStatement  -> Sql 먼저 등록 - > 매개변수처럼 ?를 이용해서 나중에 변수를 바인딩
			
			System.out.println("PreparedStatement 사용");
			System.out.println("==================================================");
			
			String sqlSelect2 = "select * from dept where deptno = ? "; //이걸 완성된 객체로 보는거임 .처음 객체생성할때 이걸 등록하고 메소드를 통해 나중에 값을 넣어줌//성능개선
			pstmt = conn.prepareStatement(sqlSelect2);
			// ?변수에 데이터 바인딩 (변수넣어줌)
			pstmt.setInt(1, 10); // 첫번째 물음표, 거기에 10번 부서 넣는다.
			
			rs =pstmt.executeQuery();
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				System.out.print(deptno+"\t");
				String dname = rs.getString("dname");
				System.out.print(dname+"\t");
				String loc = rs.getString("loc");
				System.out.println(loc+"\t");
			}
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스 찾지못함 !!!");
			e.printStackTrace();
			
		}catch (SQLException e) {
			System.out.println("데이터 베이스 연결 실패 !!!");
			e.printStackTrace();
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
