package ch05;
public class Member {
	//변수의 기능 1. 데이터를 메모리에 저장 2. 주소의기능
	//생성자 -> 초기화 메서드, 인스턴스를 생성할 때 단 한번, 인스턴스 변수를 초기화 한다.
	//생성자는 반드시 하나 이상이 있어야한다.

	private String name;
	final String phonNum; //상수처리 ->생성자의 초기화는 허용해준다. (한번 정의되면 변경불가)
	private String major;
	private int grade;
	private String emailadd;
	private String birthday;
	private String address;
	//접근제어자 지시자 private을 쓰는 이유
	//클래스 내부의 멤버들만 참조가 가능 : 정보은닉, 변수의 데이터를 보호 (메소드를 통해서만 접근하능하도록 한다)
	//값을 바꾸려고 하면 변수를 변경할수 있는 메서드를 만든다
	
	public void setName(String name) { //제어자를 public으로 해줘야함. 외부에서 접근가능하도록
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	Member(){
		this.phonNum ="000-000-0000"; //-> 상수처리 되어있기때문에 초기화를 해주어야한다.
	}
	Member(String name, String phonNum,String major,int grade, String emailadd) {
		this(name,phonNum,major,grade,emailadd,"1월 1일","서울시");
	}//생성자에 private붙이기도 함 (싱글톤 패턴) 
	Member(String name, String phonNum,String major,int grade, String emailadd, String birthday, String address) {
		this.name= name;
		this.phonNum = phonNum;
		this.major=major;
		this.grade = grade;
		this.emailadd = emailadd;
		this.birthday = birthday;
		this.address = address;
	}
	void printInfo() {
		System.out.println("이름 : "+name); //this.name -> 자기 자신의 참조값을 가지는 참조변수 (지역변수가 있다면 정확하게 표시해주는게 좋음)
		System.out.println("휴대폰번호 : "+phonNum); //파란색 나오는거 인스턴스변수 //해당변수누르고 ctrl누르면 위에변수 보여줌
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+grade);
		System.out.println("email : "+emailadd);
		System.out.println("생일 : "+birthday);
		System.out.println("주소 : "+address);
	}

	public static void main(String[] args) {
		Member m = new Member("김자바", "01012341234", "경영학", 1, "fhdjdj@naver.com");
		Member m1 = new Member("이자바", "01045612345", "전산학", 3, "sdhfsjkd@gmail.com", "10월 1일", "서울시 강남구");
		m.printInfo();
		System.out.println();
		m1.printInfo();
//		m.phonNum = "000"; ->상수이기때문에 값을 변경할 수 없다.
	}
}
