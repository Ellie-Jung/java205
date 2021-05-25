package ch01;

public class Person {
	String memberName;
	String memberTel;
	String memberId;
public static void main(String[] args) {
	Person p =new Person();
	p.memberName= "홍길순";
	p.memberTel= "010-1234-1234";
	p.memberId = "001020-2211855";
	 
	System.out.println(p.memberName);
	System.out.println(p.memberTel);
	System.out.println(p.memberId);
}
}
