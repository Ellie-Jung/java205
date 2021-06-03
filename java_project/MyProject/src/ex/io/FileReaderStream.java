package ex.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class FileReaderStream {

	public static void main(String[] args) {
		
		try {
			
			// 문자 단위로 읽어올 스트림 생성
			// Reader - FileReader
			Reader in = new FileReader("hyper.txt");
			
			char[] cbuf = new char[10];
			int readLen =0;
			
			//파일 읽어오기
			readLen = in.read(cbuf,0,cbuf.length);
			
			//출력1
//			for(int i = 0; i<readLen ; i++) {
//				System.out.println(cbuf[i]);
//			}
			
			//출력 2
			System.out.println(new String (cbuf)); // toString()호출
			
			in.close();
			System.out.println("읽기 완료");
			
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}