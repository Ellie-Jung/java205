package ch09;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DayCount {

	public static void main(String[] args) {
	//생일을 기준으로 오늘가지 몇 일을 살았는지 출력하는 프로그램 만들기.
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("태어난 년도를 입력하세요");
		int year = scanner.nextInt();
		System.out.println("태어난 달을 입력하세요");
		int month = scanner.nextInt();
		System.out.println("태어난 날짜를 입력하세요");
		int date = scanner.nextInt();

		LocalDate birthDay = LocalDate.of(year, month, date);
		LocalDate now = LocalDate.now();
		
		long days = birthDay.until(now, ChronoUnit.DAYS);
		System.out.println("birth day : "+birthDay );
		System.out.println("today : "+now );
		System.out.println("days : "+days );
		
	
	}

}
