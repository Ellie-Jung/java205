package ex;
public class InstanceOfMain {
	public static void main(String[] args) {
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
	}

	public static void wrapBox(Box box) {
		//형변환 여부 확인
		if(box instanceof GoldPaperBox) {
			((GoldPaperBox)box).GolePaperWrap();
		}else if(box instanceof PaperBox) {
			((PaperBox) box).paperWrap();
		}else {
			box.simpleWrap();
		}
		//위에 대신 밑에처럼 메서드 오버라이딩을 통해 가능.
		//위의 경우보다 밑처럼 작성하는게 훨씬 좋다 (위에꺼는 박스가 늘어나면 늘때마다 추가해야함)
		box.wrap();
	}
}

class Box{
	public void simpleWrap() {
		System.out.println("SimpleWrap");
	}
	public void wrap() {
		System.out.println("SimpleWrap");
	}
}
class PaperBox extends Box{
	public void paperWrap() {
		System.out.println("PaperBox");
	}
	public void wrap() {
		System.out.println("PaperBox");
	}
}
class GoldPaperBox extends PaperBox{
	public void GolePaperWrap() {
		System.out.println("GoldPaperWrap");
	}
	public void wrap() {
		System.out.println("GoldPaperWrap");
	}
}