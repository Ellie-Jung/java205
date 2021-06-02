package ex.io;

import java.io.File;

public class FileMove {

	public static void main(String[] args) {
		
//		File myFile = new File("D:\\myjava", "origin.pdf");
		File myFile = new File("D:\\myjava\\origin.pdf");// 위와 아래 동일함.
//		File myFile = new File("D:"+File.separator+"myjava"+File.separator+"origin.pdf");// 위와 동일함.
		
		System.out.println(myFile); //경로 출력
		
		if(!myFile.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		
		// 새로운 폴더 생성 : 경로 생성 -> 생성
		File newDir = new File("d:\\yourjava");//경로를 하나 만듬
		System.out.println("1. exist  ?? --> "+ newDir.exists());	//해당 경로가 존재하는지 여부 확인	
		
		if(!newDir.exists()) {
			//폴더생성
			newDir.mkdir();//make directory
			System.out.println("2. exist  ?? --> "+ newDir.exists());	//해당 경로가 존재하는지 여부 확인	
		}
		
		
		//이동할 경로와 파일 이름
		File newFile = new File(newDir, myFile.getName());//myFile.getName()파일의 이름을 동일하게 할때(원래이름을 쓸때)
		//이동
		myFile.renameTo(newFile);
		
		if(newFile.exists()) {
			System.out.println("파일 이동 성공");
		}else {
			System.out.println("파일 이동 실패");
		}
		
	}

}
