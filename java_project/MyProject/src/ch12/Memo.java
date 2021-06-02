package ch12;

import java.io.*;
import java.time.*;
import java.util.Scanner;


public class Memo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LocalDate date = LocalDate.now();
		//File 클래스를 이용해서 저장 폴더 생성
		File newDir = new File("d:\\MEMO");
		if(!newDir.exists()) {
			newDir.mkdir();
		}

		while(true) {

			System.out.println("=========메모장========");
			System.out.println("1. 메모 작성");
			System.out.println("2. 종료 ");
			System.out.println("메뉴를 선택하세요");
			System.out.println("===================");
			int select = scanner.nextInt();

			if(select ==2) break;
			try {
				if(select ==1) {
					while(true) {

						System.out.println("제목을 입력하세요(그만하시려면 0)");
						String text = scanner.nextLine();
						if(text.equals("0")) {
							break;
						}
						System.out.println();
						System.out.println("메모를 입력하세요");
						String memo = scanner.nextLine();


						//문자 기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장
						FileWriter Fout = new FileWriter("d:\\MEMO\\"+date+text+".txt"); //파일의 이름은 날짜와 메모의 제목을 이용해서 생성
						BufferedWriter out = new BufferedWriter(Fout);

						//파일에 저장 

						out.write(""+date);
						out.newLine();
						
						out.write(text);
						out.newLine();
						out.write(memo);
						out.newLine();
						out.close();

						System.out.println("메모를 읽으시겠습니까 ? >>1. 네. 2.아니요");
						int a = scanner.nextInt();
						if(a ==1) {
							//파일 읽기
							BufferedReader in = new BufferedReader(new FileReader("d:\\MEMO\\"+date+text+".txt"));
							//임시변수
							String str = null;
							while(true) {
								str = in.readLine();
								if(str == null) {
									break;
								}
								System.out.println(str);
							}

						}

					}

				}

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}
}

