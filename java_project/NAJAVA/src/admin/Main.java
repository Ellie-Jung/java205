package admin;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		AdminServiceImpl ad = new AdminServiceImpl(AdminDaoImpl.getInstance());

		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			ad.orderList();

			ad.salseManagement();
			
			ad.salseManagementMonth();
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}




	}
}
