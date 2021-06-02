package ex.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class StringWriter {

	public static void main(String[] args) {
		
		try {
			
			BufferedWriter out = new BufferedWriter(new FileWriter("String.txt"));
			
			System.out.println("쓰기 시작");
			//문자열 입력
			out.write("손흥민 - 안녕하세요 !!!!");
			out.newLine(); // 줄바꿈 해주는것
			out.write("반갑습니다.");
			out.newLine(); // 줄바꿈 해주는것
			out.write("2021.06.2");
			out.newLine(); // 줄바꿈 해주는것
			out.write("손흥민 작성");
			
			out.close();
			
			System.out.println("작성 완료");
			

			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
