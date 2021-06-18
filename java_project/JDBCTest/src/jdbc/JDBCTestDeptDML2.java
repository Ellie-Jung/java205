package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCTestDeptDML2 {

	public static void main(String[] args) {

		//���� ��ü : ���� ������ ������.
		Connection conn = null;          //try-catch�� �ۿ� ������ �����ؾ��Ѵ�.
		//sql�� ������ �޼ҵ� ����
		Statement stmt = null;
		//executeQuery () ��ȯŸ�� -> select�� ��� (ǥ)�� ��� ��ü 
		ResultSet rs = null;
		//Statement -> PreparedStatement : ���ɰ���
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);

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

			//Ʈ������ ����
			conn.setAutoCommit(false);
			
			
			System.out.println("�μ� ������ ������ �����մϴ�. ");
			System.out.println("�μ� ��ȣ�� �Է����ּ���. ");
			String deptno  = sc.nextLine();
			
			
			//3. sqló��
			// ����ڿ��� ������ �޾Ƽ� �μ� �����͸� �����ϴ� ���α׷��� ������.
			
			String sql = "delete from dept01 where deptno = ?";
			pstmt  = conn.prepareStatement(sql);   //PreparedStatement
			pstmt.setInt(1, Integer.parseInt(deptno));
			
			int result = pstmt.executeUpdate(); 
			
			if (result >0) {
				
				System.out.println(result +"�� ���� �����Ǿ����ϴ�.");
			}else {
				System.out.println("���ǿ� �´� �����Ͱ� �������� �ʽ��ϴ�.");
			}
			
			
			
			
			//Ʈ������ �Ϸ� (����) -> ������ ����
			conn.commit(); 
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� Ŭ���� ã������ !!!");
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
