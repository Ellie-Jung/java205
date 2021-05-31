package ch09;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Scanner;

public class DayCount {

	public static void main(String[] args) {
		
		Calendar date1= Calendar.getInstance(); //사용자에게 입력받을값
		Calendar date2= Calendar.getInstance();//오늘날짜 저장
		
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
		
		 
//		 date1.set(year,month-1,date);
//		 date2.set(Calendar.getInstance().YEAR, Calendar.getInstance().MONTH,Calendar.getInstance().DATE);
//		 
//		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		 System.out.println("birth day = "+df.format(new Date(date1.getTimeInMillis())));
//		 System.out.println("today = "+df.format(new Date(date2.getTimeInMillis())));
//		 
//		 long difference =
//				 (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
//				 System.out.println(difference/(24*60*60)
//				 +" days"); // 1 = 24 * 60 * 60
	}

}
