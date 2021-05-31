package ex.infomanager3;

import java.util.Scanner;

public class FriendBook  {

	public static void main(String[] args) {

		FriendInfoHandler handler = new FriendInfoHandler(100);
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("** 메뉴 선택 **************");
			System.out.println(Menu.HIGH_FRI +". 고교 친구 정보 입력"); //이 클래스가 implements로 메뉴를 구현하면, Menu.없이 바로 사용가능
			System.out.println(Menu.UNIV_FRI + ". 대학 친구 정보 입력");
			System.out.println(Menu.SHOW_ALL +". 전체 정보 출력 ");
			System.out.println(Menu.SHOW_BASIC +". 기본 정보 출력");
			System.out.println(Menu.EXIT +". 프로그램 종료");
			System.out.println("************************");

			System.out.print("메뉴를 선택하세요 >> ");
			int choice = Integer.parseInt(sc.nextLine());

			switch(choice){
			case Menu.HIGH_FRI : 
			case Menu.UNIV_FRI : 
				handler.addFriend(choice); 
				break;	 //break를 써주지 않으면 밑의 내용들까지 다 실행된다. -> 스위치의 블럭을 벗어나기 위해 꼭 필요
			case Menu.SHOW_ALL : 
				handler.showAllData();
				break;
			case Menu.SHOW_BASIC :
				handler.showAllBasicData();
				break;
			case Menu.EXIT :
				System.out.println("프로그램을 종료합니다. ");
				return;
			}

		}
	}
}

interface Menu{ //메뉴가 바뀔수도 있다면 이렇게 따로 빼서 인터페이스로 사용.
	 int HIGH_FRI = 1; //public static final 생략가능
	 int UNIV_FRI = 2;
	 int SHOW_ALL =3;
	 int SHOW_BASIC = 4;
	 int EXIT = 5;
}
