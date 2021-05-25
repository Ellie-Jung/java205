package ch05;

public class Member {
	//변수의 기능 1. 데이터를 메모리에 저장 2. 주소의기능
	String name;
	String phonNum;
	String major;
	int grade;
	String emailadd;
	String birthday;
	String address;
	
	void printInfo() {
		System.out.println("이름 : "+name);
		System.out.println("휴대폰번호 : "+phonNum);
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+grade);
		System.out.println("email : "+emailadd);
		System.out.println("생일 : "+birthday);
		System.out.println("주소 : "+address);
		
	}
	Member(String name, String phonNum,String major,int grade, String emailadd) {

		this(name,phonNum,major,grade,emailadd,"1월1일","서울시");
		
	}
	Member(String name, String phonNum,String major,int grade, String emailadd, String birthday, String address) {
		this.name= name;
		this.phonNum = phonNum;
		this.major=major;
		this.grade = grade;
		this.emailadd = emailadd;
		this.birthday = birthday;
		this.address = address;
	}
	
	
	public static void main(String[] args) {
		Member m = new Member("김자바", "01012341234", "경영학", 1, "fhdjdj");
		Member m1 = new Member("이자바", "456123456", "전산학", 3, "sdhfsjkd", "10월 1일", "서울시 강남구");
		m.printInfo();
		System.out.println();
		m1.printInfo();
	}
}
