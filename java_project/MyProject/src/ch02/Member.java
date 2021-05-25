package ch02;
//ch02.Member
public class Member {
	
	public static void main(String[] args) {
		//변수선언 -> 데이터의타입 식별이름;
		//데이터 타입 -> 내가 다루어야 하는 데이터의 특징에 의해서 결정
		//기본형 타입 8가지 -> 정수형, 실수형, boolean, 문자
		String name= "손흥민";
		int age = 20;
		double height = 180.2; //키
		float weight = 65.5f;  //실수는 double이 기본
		boolean hasBook = true;
		
		System.out.println("저의 이름은 "+ name); //String + String
		System.out.println("키는 "+ height+ "cm 입니다.");//String +double ->String
		System.out.println("저의 나이는 "+age+"살 입니다.");// String + int = String
		//String + any Type -> String이 된다.
		System.out.println("책의 보유 여부 : "+ hasBook); //String + boolean -> String
		
		if (hasBook) { //(조건식)
			System.out.println("책을 보유하고 있습니다.");
		}else {
			System.out.println("책을 보유하고 있지 않습니다.");
		}
	}

}
