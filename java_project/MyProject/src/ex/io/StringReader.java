package ex.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringReader {

	public static void main(String[] args) {
		
		//줄단위로 문자열 읽어오기
		
		try {
		
			BufferedReader in = new BufferedReader(new FileReader("String.txt"));
			//임시변수 
			String str = null;
		
			
			while(true) {
				str = in.readLine(); //라인단위로 읽어오기
				
				if(str == null) {
					break;
				}
				System.out.println(str);//콘솔에 출력
			}
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
