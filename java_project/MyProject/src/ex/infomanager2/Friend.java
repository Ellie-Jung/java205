package ex.infomanager2;
//상속을 목적으로 하는 클래스
public class Friend {

	//이름, 전화번호, 주소 
	String name;
	String phonNumber;
	String address;
	
	public Friend(String name, String phonNumber, String address) {
	
		this.name = name;
		this.phonNumber = phonNumber;
		this.address = address;
	}

	

	public void showData() {
		System.out.println("이   름 : "+name);
		System.out.println("전화번호 : "+phonNumber);
		System.out.println("주   소 : "+address);
		
	}
	
	public void showBasicInfo() {} //상속을해서 오버라이딩하라고 틀 제시.
	
	
}
