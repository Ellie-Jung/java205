package ch05;

public class MemberMain {

	public static void main(String[] args) {
		Member member = new Member("김자바", "01012341234", "경영학", 1, "fhdjdj@naver.com");
		member.setName("영희");  //->이름을 새로 설정하고 싶을때 , 
		member.printInfo();
		System.out.println(member.getName());  // -> 읽어오고싶을때

	}

}
