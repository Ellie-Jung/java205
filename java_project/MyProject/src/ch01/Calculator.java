package ch01;

public class Calculator {
	void plus(int x, int y) {
		System.out.println(x+y);
	}
	void minus(int x, int y) {
		System.out.println(x-y);
	}
	void multi(int x, int y){
		System.out.println(x*y);
	}
	void div(int x, int y) {
		System.out.println(x/y);
	}
	public static void main(String[] args) {
		//인스턴스 생성 -> 클래스의정의가 필요하다 (필요한 변수, 필요한 메소드)
		Calculator c = new Calculator(); //메모리에 메소드 코드를 저장
		c.plus(2, 5);
		c.minus(9, 3);
		c.multi(3, 5);
		c.div(7, 3);
		
	}
}
