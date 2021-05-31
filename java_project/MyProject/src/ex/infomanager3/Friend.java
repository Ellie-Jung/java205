package ex.infomanager3;
//상속을 목적으로 하는 클래스
public abstract class Friend implements ShowData{// 추상클래스로 변경하기. ->인스턴스를 생성할수 없다. (완성을 시켜야함) 

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
	
//	public void showBasicInfo() {}
//	public abstract void showBasicInfo();//추상메서드로 변경하기
	
	
}
