package orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OrderManager {
	ProductManager p;
	ProductDao pdao;
	Scanner sc;
	OrderDao odao ;
	ArrayList<Product> pro;
	ArrayList<Order> arr;
	
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "tiger";


	public OrderManager() {
		odao = new OrderDao();
		p = new ProductManager();
		pdao = new ProductDao();
		arr = new ArrayList<Order>();
		sc = new Scanner(System.in);
	}

	void orderinsert() {
		Connection conn = null;

		try {
			Order or = new Order();

			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			conn.setAutoCommit(false);
			pro = pdao.getProductList(conn);
			

			while (true) {
				p.productList();
				System.out.println("주문하실 메뉴 번호를 선택해주세요.");
				int a = sc.nextInt();
				or.setIcode(a);
				System.out.println("주문 수량을 선택해주세요.");
				int b = sc.nextInt();
				or.setCount(b);

				for (int i = 0; i < pro.size(); i++) {
					if(pro.get(i).getIcode() == a) {
						or.setOprice(pro.get(i).getIprice()*b);
						break;
					}
				}

				System.out.println("주문을 계속하시려면 [1] 예 , 주문을 그만하시고 결제하시려면  [2] 아니오  ");
				String input = sc.next();
				if (input.equalsIgnoreCase("1")) {
					arr.add(or);
					System.out.println();

					System.out.println("주문완료. 감사합니다.");
					continue;
				} else if (input.equalsIgnoreCase("2")) {
					
					System.out.println("감사합니다. ");
					break;
				} else {
					System.out.println("잘못입력하셨습니다. 초기화면으로 이동합니다.");
					return;
				}
			}

			long ordercode = System.nanoTime();

			for (int i = 0; i < arr.size(); i++) {

				arr.get(i).setOrdercode(ordercode);
				int result = odao.orderInsert(conn, arr.get(i));
			}
			for (int i = 0; i < arr.size(); i++) {

				int result = odao.updateProduct(conn, arr.get(i));
			}

			conn.commit();
			
			System.out.println("영수증");
			orderList();

		} catch (SQLException e) { 
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}


	}

	void orderList() {
		Connection conn = null;
		Order order = new Order();
		try {		
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			arr = odao.getOrderList(conn, order);



			for (int i = 0; i < arr.size(); i++) {
				//				if(tmp == arr.get(i).getIdx()) {
				System.out.println("----------------------------영수증--------------------------------");
				System.out.println("----------------------------------------------------------------");
				System.out.println("주문번호 : " + arr.get(i).getOidx());
				System.out.println("주문코드 : " + arr.get(i).getOrdercode());
				System.out.println("상품번호 : " + arr.get(i).getIcode());
				System.out.println("회원번호 : " + arr.get(i).getIdx());
				System.out.println("주문날짜 : " + arr.get(i).getOrderdate());
				System.out.println("구매갯수 : " + arr.get(i).getCount());
				System.out.println("구매가격 : " + arr.get(i).getOprice());
				System.out.println("----------------------------------------------------------------");

				//					break;
				//				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//	void delOrder() {
	//
	//		Connection conn = null;
	//
	//		try {
	//			conn = DriverManager.getConnection(jdbcUrl, user, pw);
	//
	//			orderList();
	//			System.out.println("삭제 원하시는 메뉴번호를 선택해주세요.");
	//			int order = Integer.parseInt(sc.nextLine());
	//
	//			int result = odao.deleteProduct(conn, order);
	//
	//			if (result > 0) {
	//				System.out.println("삭제되었습니다.");
	//			} else {
	//				System.out.println("삭제실패!");
	//			}
	//
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		}
	//	}

	public void menu() {
		System.out.println("주문을 시작합니다. ");
		while (true) {
			//			p.productList();

			//			System.out.println("원하시는 상품을 골라주세요  ( 그만하시려면 0번 )");
			//			int input = sc.nextInt();
			//			
						System.out.println("[1]주문하기 [2]주문한 내용 결제하기 [3]주문취소 [0]돌아가기");
			System.out.println("[1]주문하기   [0]돌아가기");
			int input = sc.nextInt();
			switch (input) {
			case 1:

				orderinsert();
				break;
							case 2:
								orderList();
								break;
				//			case 3:
				////				delOrder();
				//				break;
			case 0:
				return;
			}
		}
	}
}

