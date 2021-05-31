package ch09;

public class Person {

	String name;
	String personNumber;
	Person(String personNumber) {
		this.personNumber = personNumber;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person)obj;
			return personNumber== p.personNumber ;
		}
		else return false;
	}

		public static void main(String[] args) {
			Person person = new Person("1111");
			Person person2 = new Person("1111");
			System.out.println(person.equals(person2));
		}
	
}
