package ch02;

import java.util.Scanner;

import ch01.Contact;

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

	}
	void deleteInfo() {//배열의 요소를 삭제
		System.out.print("삭제하실 연락처의 이름을 적어주세요 >>");
		String name = sc.nextLine().trim();
		for(int i=0; i<con.length;i++) {
			if(name.equals(con[i].getName())){
				for(int j=i;j<con.length-1;j++) {
					Contact temp = con[i];
					con[i] =con[i+1];
					con[i+1] = new Contact();
				}
			}
		}System.out.println(name+" 삭제완료.");
	}
	void printInfo() {
		for( Contact e: con) {
			System.out.println("이름 : "+e.getName());
			System.out.println("전화번호 : "+e.getPhoneNum());
			System.out.println("이메일 : "+e.getEmail());
			System.out.println("주소 : "+e.getAddress());
			System.out.println("생일 : "+e.getBirthday());
			System.out.println("그룹 : "+e.getGroup());
			System.out.println("--------------------------------");
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

			Contact c = new Contact(name,phoneNum,email,address,birthday,group); //사용자로부터 받은 값으로 인스턴스생성
			smartPhone.addInfo(c); //인스턴스를 배열에 추가

		}

		smartPhone.printInfo(); //배열의 모든 요소 출력

		smartPhone.deleteInfo(); // 배열의 요소를 삭제
		smartPhone.printInfo(); // 삭제 확인하기

	}

}
