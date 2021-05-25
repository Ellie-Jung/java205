package ch04;
import java.util.Calendar;
import java.util.Scanner;


public class Member {

	Calendar calendar = Calendar.getInstance(); //싱글톤.//캘린더 클래스는 메소드만 존재. 캘린더 클래스의인스턴스를 가져온다 바로 (getInstance)
	int thisYear = calendar.get(Calendar.YEAR); //줄여서 int thisYear = Calendar.getInstance().get(Calendar.YEAR)

	int ageCal(int year) { //
		// ->캘린더 객체안에 있는메소드를 가져올 준비가 된것이다. 
		return thisYear - year-1; // ->return Calendar.getInstance().get(Calendar.YEAR)-year-1;
	}

	void vaccine(int year) {
	
		// boolean check1 = age<15 || age>= 65;
		// boolean check2 = !(age>=15 && age<65); -> 반대의 조건도 생각해보자
		if (ageCal(year) < 15 || ageCal(year) >= 65) {
			System.out.println("무료 예방 접종이 가능합니다.");
		} else {
			System.out.println("무료 접종 대상이 아닙니다.");
		}
	}

	void checkup(int year) {
		
		//boolean check1 =(year%2==0 && thisyear%2==0)|| (year%2==1 && thisyear%2==1)
		boolean check2 = year%2 ==thisYear%2; //이게 더 간단한 조건식이다. (홀수면 둘다 1, 짝수면 둘다 0)
		if (ageCal(year) >= 20 &&check2) {
			System.out.println("무료로 2년마다 건강검진을 받을 수 있습니다.");
			System.out.println("올해가 검사 대상입니다.");

			if (ageCal(year) >= 40) {
				System.out.println("암검사도 무료로 할 수 있습니다.");
			}
		} else
			System.out.println("검사대상이 아닙니다.");
	}



	public static void main(String[] args) {
		Member member = new Member();
		Scanner sc = new Scanner(System.in);
		System.out.print("태어난 년도를 입력해 주세요 : ");
		int year = sc.nextInt();
		member.vaccine(year);
		member.checkup(year);


	}

}
