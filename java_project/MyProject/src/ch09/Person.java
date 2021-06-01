package ch09;

public class Person {

	String name;
	String personNumber;
	Person(String personNumber) {
		this.personNumber = personNumber;
	}
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj !=null && obj instanceof Person) {
			Person p = (Person)obj;
			if(p.personNumber ==this.personNumber)
			result =true;
		}
		return result;
	}

		public static void main(String[] args) {
			Person person = new Person("1111");
			Person person2 = new Person("1111");
			System.out.println(person.equals(person2));
		}
	
}
