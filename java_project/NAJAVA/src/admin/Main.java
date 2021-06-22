package admin;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		AdminMenu am = new AdminMenu();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			am.AdminMenu();
//			ad.orderList();

//			ad.salseManagement();
			
//			ad.salseManagementMonth();
			
//			ad.salseManagementDaily();
			
//			ad.inventory();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}




	}
}
