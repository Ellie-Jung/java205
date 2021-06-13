package ch02;

import java.util.Scanner;
import ch01.Contact;
import ch03.CompanyContact;
import ch03.CustomerContact;

public class SmartPhone {
	static Scanner sc = new Scanner(System.in);

	int i = 0;

	//① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의
	Contact [] con = new Contact[10];

	//② 배열에 인스턴스를 저장하고, 수정하고, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다
	void addInfo(Contact c) { //배열에 인스턴스 저장
		con[i++] = c;
	}
	void editInfo(){ //배열 수정
		System.out.print("수정하실 연락처의 이름을 적어주세요 >>");
		String name = sc.nextLine().trim();
		for (int i = 0; i<con.length;i++) {
			if(name.equals(con[i].getName())){
				System.out.println("어떤 정보를 수정하시겠습니까?");
				System.out.print("1. 이름 2.전화번호 3.이메일 4.주소 5.생일 6.그룹 7.전체>>");
				String num = sc.nextLine().trim();
				System.out.println("변경하실 내용을 입력해주세요.");
				switch (num) {
				case "1":
					con[i].setName(sc.nextLine());
					break;
				case "2":
					con[i].setPhoneNum(sc.nextLine());
					break;
				case "3":
					con[i].setEmail(sc.nextLine());
					break;
				case "4":
					con[i].setAddress(sc.nextLine());
					break;
				case "5":
					con[i].setBirthday(sc.nextLine());
					break;
				case "6":
					con[i].setGroup(sc.nextLine());
					break;
				case "7":
					System.out.println("이름을 입력하세요");
					con[i].setName(sc.nextLine());
					System.out.println("전화번호를 입력하세요");
					con[i].setPhoneNum(sc.nextLine());
					System.out.println("메일을 입력하세요");
					con[i].setEmail(sc.nextLine());
					System.out.println("주소를 입력하세요");
					con[i].setAddress(sc.nextLine());
					System.out.println("생일을 입력하세요");
					con[i].setBirthday(sc.nextLine());
					System.out.println("그룹을 입력하세요");
					con[i].setGroup(sc.nextLine());
					break;
				}
			}
		} System.out.println("수정완료");

	}
	
	void deleteInfo() {//배열의 요소를 삭제
		System.out.print("삭제하실 연락처의 이름을 적어주세요 >>");
		String name = sc.nextLine().trim();
		for(int i =0; i<con.length;i++) {
			if(name.equals(con[i].getName())){
				System.arraycopy(con, i+1, con, i, con.length-i-1);
				con[con.length-1] = new Contact();
			}
		}System.out.println(name+" 삭제완료.");
	}
	
	void printInfo() {
		for(int i=0; i<con.length;i++) {
			con[i].printInfo();
			System.out.println("--------------------------");
		}


	}

	public static void main(String[] args) {



		SmartPhone smartPhone = new SmartPhone();

		for(int i =0 ; i< smartPhone.con.length;i++) {

			System.out.println("["+(i+1)+"]");
			System.out.print( "이름을 입력해주세요>>");
			String name = sc.nextLine();
			System.out.print("전화번호를 입력해주세요>>");
			String phoneNum = sc.nextLine();
			System.out.print("이메일을 입력해주세요>>");
			String email = sc.nextLine();
			System.out.print("주소를 입력해주세요>>");
			String address = sc.nextLine();
			System.out.print("생일을 입력해주세요>>");
			String birthday = sc.nextLine();
			System.out.print("그룹을 입력해주세요>>");
			String group = sc.nextLine();
			System.out.println("-----------------------");

//			Contact c = new Contact(name,phoneNum,email,address,birthday,group); //사용자로부터 받은 값으로 인스턴스생성
//			smartPhone.addInfo(c); //인스턴스를 배열에 추가
			
//			Contact c1 = new CustomerContact(name,phoneNum,email,address,birthday,group);
//			smartPhone.addInfo(c1);
			Contact c2 = new CompanyContact(name,phoneNum,email,address,birthday,group);
			smartPhone.addInfo(c2);
			
		}

		smartPhone.printInfo(); //배열의 모든 요소 출력

		smartPhone.deleteInfo(); // 배열의 요소를 삭제
		smartPhone.printInfo(); // 삭제 확인하기

		smartPhone.editInfo(); //배열의 요소를 수정
		smartPhone.printInfo(); // 수정 확인
		
		
		
	}

}
