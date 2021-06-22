package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;



public class AdminServiceImpl implements AdminService {

	private AdminDaoImpl dao;  //의존성을 낮추기위해 여기서 바로 인스턴스를 생성하면 안된다. 선언만 
	private Scanner sc;


	public AdminServiceImpl(AdminDaoImpl dao) { //생성자
		this.dao = dao;
		sc= new Scanner(System.in);
	}



	//// 전체 리스트 출력 메소드
	/// DAO에서 데이터 리스트를 받고, 출력 처리 
	void orderList() {
		//Connection 객체 생성 -트랜젝션 처리
		Connection conn = null;

		//2. 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";

		try {
			conn = DriverManager.getConnection(jdbcUrl,user,pw);
			List<Order> list = dao.getOrderList(conn);

			System.out.println("주문 정보 리스트 ");
			System.out.println("-------------------------------------");
			System.out.println("주문번호 \t 회원번호 \t 주문날짜 \t 상품번호");
			System.out.println("-------------------------------------");

			for(Order order : list) {
				System.out.printf("%d \t %d \t %d \t %s \n", order.getOrdercode(), order.getIdx(),order.getIcode(),order.getOrderdate());

			}
			System.out.println("-------------------------------------");


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	//총 매출 출력
	@Override
	public void salseManagement() {
		//Connection 객체 생성 -트랜젝션 처리
		Connection conn = null;

		//2. 연결 // 모든 메서드에서 공통으로 쓰이기때문에 메서드 밖으로 빼는게 좋다. 
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		try {
			conn = DriverManager.getConnection(jdbcUrl,user,pw);
			
			int sum = dao.getSales(conn);

			System.out.println("총 매출은 "+ sum);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//달별 매출 출력
	public void salseManagementMonth() {
		//Connection 객체 생성 -트랜젝션 처리
		Connection conn = null;

		//2. 연결 // 모든 메서드에서 공통으로 쓰이기때문에 메서드 밖으로 빼는게 좋다. 
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		try {
			conn = DriverManager.getConnection(jdbcUrl,user,pw);
			
			System.out.println("검색하실 월을 년 / 일 (21/05) 형식으로 입력해주세요.");
			String dno = sc.nextLine();
			
			int sum = dao.getSales(conn);

			System.out.println("총 매출은 "+ sum);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void inventory() {

	}

	
	
	
	
	
}
