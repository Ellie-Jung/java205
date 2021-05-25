package ch03;
import java.util.Scanner;
public class Calculator {
	int plus(int x, int y) {
		return (x+y);
	}
	int minus(int x, int y) {
		return(x-y);
	}
	int multi(int x, int y){
		return(x*y);
	}
	int div(int x, int y) {
		return(x/y);
	}
	double circumference(int r) {
		return 2*Math.PI*r;
	}
	double circleArea(int r) {
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
		
		Scanner sc = new Scanner(System.in);
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
