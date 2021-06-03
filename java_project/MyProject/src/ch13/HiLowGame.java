package ch13;

public class HiLowGame {
	
	public static void main(String[] args) {

		CountingThread t1 = new CountingThread(); //10초카운팅 스레드 생성
		Question t2 = new Question(); //문제 스레드 생성
		t1.start(); //10초 카운팅스레드 실행
		t2.start(); // 실행

	}

}



