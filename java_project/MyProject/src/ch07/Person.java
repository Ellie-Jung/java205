package ch07;
import java.util.Calendar;
public class Person {
	//상속 : 물려받는것. 중요한것 1.메소드 오버라이딩(구현부 재정의) 2. 다형성
	//클래스간의 상속 -> 조상이 가이드를 제시하고 자손이 새로운 클래스를 완성.
	
	private String name;
	private String residentNum= "000000-0000000";
	
	public Person() {}
	public Person(String name, String residentNum) {
		this.name = name;
		this.residentNum = residentNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResidentNum() {
		return residentNum;
	}
	public void setResidentNum(String residentNum) {
		this.residentNum = residentNum;
	}
	
	int age () {
		int birth = Integer.parseInt(getResidentNum().substring(0,2));
		int birthYear = 0;
		char chk = getResidentNum().charAt(7);
		if (chk=='1'||chk=='2'){
			birthYear = 1900+birth;
		}else if(chk=='3'||chk=='4'){
			birthYear = 2000+birth;
		}
		return Calendar.getInstance().get(Calendar.YEAR)-birthYear-1;
	}

	void sayHi(){
		System.out.println("안녕하세요. 저는 "+getName()+" 입니다. "+age()+ "살 입니다.");
	}
}
