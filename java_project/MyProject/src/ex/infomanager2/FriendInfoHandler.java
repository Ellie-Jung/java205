package ex.infomanager2;

import java.util.Scanner;

public class FriendInfoHandler {

	//저장데이터 (객체)를 배열로 저장하고 관리하는 기능을 가지는 클래스
	Friend[] friends; //입력받은 친구를 저장할 배열
	int numOfFriend; //배열의 입력 index역할, 정보의 개수

	//생성자에서 배열 

	public FriendInfoHandler(int num) { //num은 배열의 사이즈 -> 배열 인스턴스를 생성
		this.friends = new Friend[num];
		this.numOfFriend = 0;
	}

	//데이터의 입력처리
	//사용자로부터 친구의 정보를 입력 받아서 -> 인스턴스를 생성 -> 배열에 저장
	public void addFriend(int choice) { //choice-> 1(고교친구) or 2(대학친구) 

		Scanner s = new Scanner(System.in);

		System.out.println("이름을 입력해주세요 >>");
		String name = s.nextLine();
		System.out.println("전화번호를 입력해주세요 >>");
		String phonNumber = s.nextLine();
		System.out.println("주소를 입력해주세요 >>");
		String address = s.nextLine();

		if(choice ==1) {
			System.out.println("직업을 입력해주세요 >>");
			String work = s.nextLine();

			//인스턴스 생성
			//			HighFriend hFriend = new HighFriend(name, phonNumber, address, work);
			addFriendInfo(new HighFriend(name, phonNumber, address, work));
			//			friends[numOfFriend] = hFriend; //배열에 요소추가
			//			numOfFriend++; //친구의 수 하나씩 증가

		}else  {   //2.대학친구           //else if(choice ==2)생략가능.(두가지선택지)
			System.out.println("전공을 입력해주세요 >>");
			String major = s.nextLine();

			//인스턴스 생성
			//			UnivFriend uFriend = new UnivFriend(name, phonNumber, address, major);
			//			addFriendInfo(uFriend);
			addFriendInfo(new UnivFriend(name, phonNumber, address, major)); //위에 두줄을 이렇게 줄이기가능.//
			//			friends [numOfFriend]= uFriend; //배열에 요소 추가
			//			numOfFriend++; //위에 코드와 중복. 메소드로 따로만들어서 중복을 줄이자 ! 
		}
	}

	//Friend 클래스를 상속하는 타입의 인스턴스를 받아 배열에 저장
	public void addFriendInfo(Friend f) {
		friends [numOfFriend++]= f; //배열에 요소 추가
		System.out.println("정보가 저장되었습니다. ");
	}

	// 모든 데이터를 출력하는 메소드		
	public void showAllData() {
		System.out.println("친구의 모든 정보를 출력합니다. ");
		System.out.println("------------------------");
		if(numOfFriend>0) {
			for(int i = 0; i<numOfFriend;i++) {
				friends[i].showData();
				System.out.println("------------------------");
			}
		}else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println("---------------------------");
	}

	public void showAllBasicData() {
		System.out.println("친구의 모든 기본 정보를 출력합니다. ");
		System.out.println("------------------------");
		if(numOfFriend>0) {
			for(int i = 0; i<numOfFriend;i++) {
				friends[i].showBasicInfo();
				System.out.println("------------------------");
			}
		}else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println("---------------------------");
	}
}