package ch01;

import java.util.Scanner;

public class Contact { //변수 캡슐화처리
	private String name;
	private String phoneNum;
	private String email;
	private String address;
	private String birthday;
	private String group;
	
	public Contact() {}
	public Contact(String name, String phoneNum, String email, String address, String birthday, String group) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}

	void printInfo() {
		System.out.println("이름 : "+getName());
		System.out.println("전화번호 : "+getPhoneNum());
		System.out.println("이메일 : "+getEmail());
		System.out.println("주소 : "+getAddress());
		System.out.println("생일 : "+getBirthday());
		System.out.println("그룹 : "+getGroup());
	}
	
	public static void main(String[] args) {
		
		
		Contact c = new Contact();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력해주세요>>");
		c.setName(sc.nextLine());
		System.out.print("전화번호를 입력해주세요>>");
		c.setPhoneNum(sc.nextLine());
		System.out.print("이메일을 입력해주세요>>");
		c.setEmail(sc.nextLine());
		System.out.print("주소를 입력해주세요>>");
		c.setAddress(sc.nextLine());
		System.out.print("생일을 입력해주세요>>");
		c.setBirthday(sc.nextLine());
		System.out.print("그룹을 입력해주세요>>");
		c.setGroup(sc.nextLine());


		System.out.println(c.getName());
		System.out.println(c.getPhoneNum());
		System.out.println(c.getEmail());
		System.out.println(c.getAddress());
		System.out.println(c.getBirthday());
		System.out.println(c.getGroup());
		
		System.out.println("--------------------------------");
		
		c.printInfo();
		
		System.out.println("이름을 다시 입력해 주세요");
		c.setName(sc.nextLine());
		
		c.printInfo();
		
	}

}
