import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SmartPhone smartPhone= new SmartPhone(10);
		
		for(;;) {
			
			System.out.println("===============================");
			System.out.println(" 1. 연락처 입력 ");
			System.out.println(" 2. 연락처 검색 ");
			System.out.println(" 3. 연락처 수정 ");
			System.out.println(" 4. 연락처 삭제 ");
			System.out.println(" 5. 연락처 전체 리스트 보기 ");
			System.out.println(" 6. 종료 ");
			System.out.println("===============================");
			
			System.out.print("번호를 선택해주세요 >>");
			int num = sc.nextInt();
			
			switch (num) {
			
			case 1:
				smartPhone.insertData();
				break;
			
			case 2 : 
				smartPhone.selectInfo();
				break;
			
			case 3 : 
				smartPhone.editInfo();
				break;
				
			case 4 : 
				smartPhone.deleteInfo();
				break;
				
			case 5 :
				smartPhone.showData();
				break;
				
			case 6 :
				System.out.println("시스템을 종료합니다.");
				return;
			
			}
		}
	}
}
