package ch12;

import java.io.*;
import java.util.Scanner;


public class Memo {
	
	public static void main(String[] args) {
		//File 클래스를 이용해서 저장 폴더 생성
		File newDir = new File("d:\\new");
		if(!newDir.exists()) {
			newDir.mkdir();
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("날짜를 입력하세요");
		String date = scanner.nextLine();
		System.out.println("제목을 입력하세요");
		String text = scanner.nextLine();
		System.out.println("메모를 입력하세요");
		String memo = scanner.nextLine();
		
		
		try {
			//문자 기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장
			FileWriter Fout = new FileWriter("d:\\new\\"+date+text+".txt"); //파일의 이름은 날짜와 메모의 제목을 이용해서 생성
			BufferedWriter out = new BufferedWriter(Fout);
			//파일에 저장 
			out.write(date);
			out.newLine();
			out.write(text);
			out.newLine();
			out.write(memo);
			out.newLine();
			out.close();
			
			//파일 읽기
			BufferedReader in = new BufferedReader(new FileReader("d:\\new\\"+date+text+".txt"));
			//임시변수
			String str = null;
			while(true) {
				str = in.readLine();
				if(str == null) {
					break;
				}
				System.out.println(str);
			}
			

		} catch (IOException e) {

			e.printStackTrace();
		}


	}



}
