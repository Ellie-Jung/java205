package ch13;

import java.io.*;
import java.util.Scanner;

public class CloneMain {

	
	public static void main(String[] args) {
		//복사할 대상파일의 경로와 복사해올 위치 경로를 받는 메인스레드는 멈춤없이 실행.
		Scanner sc = new Scanner(System.in);
		CloneMain c = new CloneMain();
		
		System.out.println("복사할 대상의 파일 경로를 포함한 파일이름을 입력하세요.");
		String path = sc.nextLine();
		File f = new File(path);
		if(!f.exists()) {
			System.out.println("파일이 없습니다.");
			return;
		}
			
		System.out.println("복사해 올 위치 경로를 입력하세요.");
		String clonePath = sc.nextLine();
		File f2= new File(clonePath);
		if(!f2.exists()) {
			System.out.println("복사할 경로를 잘못 입력하셨습니다..");
			return;
		}
		
		//데이터 복사하는 스레드 생성
		DataClone t = new DataClone(path, clonePath);
		t.start();


		





	}

}
