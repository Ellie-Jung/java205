package ch13;

import java.io.*;
import java.util.Scanner;

public class CloneMain {

	
	public static void main(String[] args) {
		//복사할 대상파일의 경로와 복사해올 위치 경로를 받는 메인스레드는 멈춤없이 실행.
		Scanner sc = new Scanner(System.in);
		CloneMain c = new CloneMain();

		String path;
		String clonePath;
		
		System.out.println("복사할 대상의 파일 경로를 입력하세요.");
		path = sc.nextLine();
		System.out.println("복사해올 위치경로를 입력하세요");
		clonePath = sc.nextLine();

		
		//데이터 복사하는 스레드 생성
		DataClone t = new DataClone(path, clonePath);
		t.start();


		





	}

}
