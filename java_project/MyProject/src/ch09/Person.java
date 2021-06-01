package ch09;

public class Person {
	// 주민등록번호가 같으면 같은인스턴스로 판별하는 프로그램 만들어보자.		
	
	String name;
	String personNumber;
	Person(String name,String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj !=null && obj instanceof Person) {
			Person p = (Person)obj;
			if(p.personNumber.equals(personNumber))
			result =true;
		}
		return result;
	}

		public static void main(String[] args) {
			Person person = new Person("김씨","1111");
			Person person2 = new Person("박씨","1111");
			System.out.println(person.equals(person2));
		}
	
}
