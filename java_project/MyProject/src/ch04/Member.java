package ch04;

import java.time.Year;
import java.util.Calendar;
import java.util.Scanner;

public class Member {

	Calendar calendar = Calendar.getInstance();
	int thisYear = calendar.get(Calendar.YEAR);
	int year;

	void vaccine(int year) {
		if ((thisYear - year) < 15 || thisYear - year >= 65) {
			System.out.println("무료 예방 접종이 가능합니다.");
		} else {
			System.out.println("무료 접종 대상이 아닙니다.");
		}
	}

	void check(int year) {
		if ((thisYear - year) >= 20) {
			System.out.println("무료로 2년마다 건강검진을 받을 수 있습니다.");
			if (year % 2 == 0 && thisYear % 2 == 0) {
				System.out.println("올해가 검사 대상입니다.");
			} else if (year % 2 == 1 && thisYear % 2 == 1) {
				System.out.println("올해가 검사 대상입니다.");
			}
			if ((thisYear - year) >= 40) {
				System.out.println("암검사도 무료로 할 수 있습니다.");
			}
		} else
			System.out.println("검사대상이 아닙니다.");
	}

	public static void main(String[] args) {
		Member member = new Member();
		Scanner sc = new Scanner(System.in);
		System.out.print("태어난 연도를 입력해 주세요 : ");
		int year = sc.nextInt();
		member.vaccine(year);
		member.check(year);

	}

}
