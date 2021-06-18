package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTest {

	public static void main(String[] args) {

		//���� ��ü : ���� ������ ������.
		Connection conn = null;          //try-catch�� �ۿ� ������ �����ؾ��Ѵ�.
		//sql�� ������ �޼ҵ� ����
		Statement stmt = null;
		//executeQuery () ��ȯŸ�� -> select�� ��� (ǥ)�� ��� ��ü 
		ResultSet rs = null;
		//Statement -> PreparedStatement : ���ɰ���
		PreparedStatement pstmt = null;

		try {
			//1. ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ���� !");

			//2. ����
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";

			conn = DriverManager.getConnection(jdbcUrl,user,pw);
			System.out.println("������ ���̽� ���� ����");

			
			//3. sqló��
			
			stmt = conn.createStatement();
			
			int dno= 10; // �̷������� �ش��ϴ� ���� ã���� �ְ�, ����ڿ��� �Է� �������� �ִ�. 
			String otype = "deptno";
			
			String sqlSelect = "select * from dept where deptno="+dno+" order by "+otype ;
			
			
	
			
			rs =stmt.executeQuery(sqlSelect); //resultSet ��ȯ�Ѵ�.
			
			//rs.next() -> �������� ���� ���� Ȯ��
			while(rs.next()) { //true�϶�, �������� ������ 
				int deptno = rs.getInt("deptno");
				System.out.print(deptno+"\t");
				String dname = rs.getString("dname");
				System.out.print(dname+"\t");
				String loc = rs.getString("loc");
				System.out.println(loc+"\t");
			}
			
			
			//////////////////////////////////////////////////
			///PreparedStatement  -> Sql ���� ��� - > �Ű�����ó�� ?�� �̿��ؼ� ���߿� ������ ���ε�
			
			System.out.println("PreparedStatement ���");
			System.out.println("==================================================");
			
			String sqlSelect2 = "select * from dept where deptno = ? "; //�̰� �ϼ��� ��ü�� ���°��� .ó�� ��ü�����Ҷ� �̰� ����ϰ� �޼ҵ带 ���� ���߿� ���� �־���//���ɰ���
			pstmt = conn.prepareStatement(sqlSelect2);
			// ?������ ������ ���ε� (�����־���)
			pstmt.setInt(1, 10); // ù��° ����ǥ, �ű⿡ 10�� �μ� �ִ´�.
			
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
			System.out.println("����̹� Ŭ���� ã������ !!!");
			e.printStackTrace();
			
		}catch (SQLException e) {
			System.out.println("������ ���̽� ���� ���� !!!");
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
