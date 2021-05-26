package ch07;

public class Female extends Person{
	float height;
	public Female() {
		super();
	}
	public Female(String name, String residentNum,float height) {
		super(name, residentNum);
		this.height = height;
	}

	@Override
	void sayHi() {
		System.out.println("안녕하세요. 저는 "+getName()+" 입니다. "+age()+ "살 여자입니다. 키는 "+height+"cm 입니다.");
	}
	void sleeping() {
		System.out.println(getName() + "는 잠을 잡니다.");
	}
}
