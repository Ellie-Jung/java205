import java.util.Scanner;



public class SmartPhone {
	static Scanner sc = new Scanner(System.in);



	//① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의
	Contact [] con; //= new CompanyContact[10];
	int numOfFriend;

	public SmartPhone(int num) { //num은 배열의 사이즈 -> 배열 인스턴스를 생성
		this.con= new Contact[num];
		this.numOfFriend = 0;
	}


	//② 배열에 인스턴스를 저장하고, 수정하고, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다
	void addInfo(Contact c) { //배열에 인스턴스 저장
		con[numOfFriend++] = c;
		System.out.println("정보가 저장되었습니다.");
	}

	void insertData() {

		Scanner sc = new Scanner(System.in);

		System.out.println("-----------------------");
		System.out.println("1. 회사 연락처 입력하기");
		System.out.println("2. 거래처 연락처 입력하기");
		System.out.print("입력하실 연락처를 선택해주세요. >>");
		int n = Integer.parseInt(sc.nextLine());

		System.out.println("["+(numOfFriend+1)+"]");
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

		if(n==1) {

			System.out.print("회사 이름을 입력해 주세요 >>");
			String companyName = sc.nextLine();
			System.out.print("부서 이름을 입력해 주세요 >>");
			String deptName = sc.nextLine();
			System.out.print("직급을 입력해 주세요 >>");
			String rank = sc.nextLine();

			addInfo(new CompanyContact(name, phoneNum,email,address,birthday,group,companyName,deptName,rank));

		}else if(n==2) {
			System.out.print("거래처 회사 이름을 입력해 주세요 >>");
			String accountName = sc.nextLine();
			System.out.print("거래품목을 입력해 주세요 >>");
			String item = sc.nextLine();
			System.out.print("직급을 입력해 주세요 >>");
			String rank = sc.nextLine();

			addInfo(new CustomerContact(name, phoneNum,email,address,birthday,group,accountName,item,rank));

		}

	}


	void selectInfo() {

		System.out.print("검색하실 연락처의 이름을 적어주세요 >>");
		String name = sc.nextLine().trim();

		for(int i= 0; i<con.length; i++) {
			if(name.equals(con[i].getName())){
				con[i].showData();
				return;
			}else {
				System.out.println("해당하는 연락처가 없습니다.");
				return;
			}
		}
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
			} System.out.println("수정완료");
			return;

		}
	}

	void deleteInfo() {//배열의 요소를 삭제
		System.out.print("삭제하실 연락처의 이름을 적어주세요 >>");
		String name = sc.nextLine().trim();
		for(int i =0; i<numOfFriend;i++) {
			if(name.equals(con[i].getName())){
				System.arraycopy(con, i+1, con, i, numOfFriend-i-1);
				con[numOfFriend-1] = new CompanyContact();  //new CustomerContact();
			}System.out.println(name+" 삭제완료.");
			return;
		}
	}

	void showData() {
		System.out.println("입력된 연락처를 출력합니다. ");
		System.out.println("----------------------------");
		if(numOfFriend >0) {

			for(int i=0; i<numOfFriend;i++) {
				con[i].showData();
				System.out.println("--------------------------");
			}
		}
		else {
			System.out.println( "입력된 정보가 없습니다. ");
		}
		System.out.println("-----------------------");
		return;
	}
}
