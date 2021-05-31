package ex.infomanager3;

public class HighFriend extends Friend {
	
	//고교친구는 직장정보를 추가적으로 가진다.
	String work;
	
	public HighFriend(String name, String phonNumber, String address,String work) {
		super(name, phonNumber, address);
		this.work = work;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("직   업 : "+ work);
	}

	@Override
	public void showBasicInfo() {  //추상메서드 구현하기.(완성)
		System.out.println("이름 : "+name);
		System.out.println("전화 : "+phonNumber);
	}

	
}
