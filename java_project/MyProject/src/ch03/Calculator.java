package ch03;
import java.util.Scanner;
public class Calculator {
	long plus(int x, int y) {
		return (long)x+y; //두개를 합친반환값이 int 범위를 넘어서는 경우를 고려해야한다. (받을때는 long으로 받던지 해서 해결)
	}
	long minus(int x, int y) { //마이너스도 int범위를 넘어설수 있음 (-22억 이상) 
		return(long)x-y; //하나만처리하면 자동형변환
	}
	long multi(int x, int y){
		return(long)x*y;
	}
	float div(int x, int y) {
		return (float)x/y;
	}
	
//	double pi1 = 3.14;
//	float pi2 = 3.14f;
//	final float PI = 3.14f;  //상수. 바뀌면 안되는 것들 (한번 대입한 후), 상수이름은 대문자로 쓴다.
	
	double circumference(double r) {
		return  2*Math.PI*r;
	}
	double circleArea(double r) {
		return Math.PI*r*r;
	}
	void printResult (int num1, int num2) {
		System.out.println("두 값의 합 : "+ plus(num1, num2));
		System.out.println("두 값의 차 : "+minus(num1, num2));
		System.out.println("두 값의 곱 : "+multi(num1, num2));
		System.out.println("두 값의 나누기: "+div(num1, num2));
	}
	void printCircle (int r) {
		System.out.println("원의 둘레 : "+circumference(r));
		System.out.println("원의 넓이 : "+circleArea(r));
	}
	public static void main(String[] args) {
		
		Calculator c = new Calculator();
		// Scanner : 자원을 프로그램으로 받아오는 역할
		Scanner sc = new Scanner(System.in); //System.in -> InputStream 타입을 참조변수로 받는다. 
		System.out.println("첫번째 숫자를 입력해주세요");
		int num1 = sc.nextInt();
		System.out.println("두번째 숫자를 입력해주세요");
		int num2 = sc.nextInt();
		
		c.printResult(num1, num2);

		System.out.println("원의 반지름을 입력하세요");
		int r = sc.nextInt();
		
		c.printCircle(r);
	}

}
