package ex.io;
import java.io.*;
public class BufferFileCopy { 
	public static void main(String[] args) {
		
		//속도가 그냥 byte단위로 받는것보다 훠월씬 빠르다.(바이트 배열이용)
		//카피 성능 개선 
		
		try {
			
			// 1. 파일의 바이너리 데이터를 읽어올 스트림 생성 : FileInputStream
//			FileInputStream in = new FileInputStream("origin.pdf");
			InputStream in = new FileInputStream("origin.pdf"); //다형성
			
			//2.파일을 쓰기위한 스트림 생성 : FileOutputStream
			FileOutputStream out = new FileOutputStream("copy2.pdf"); //내가원하는 위치에 설정
			
			//카피한 데이터의 크기
			int copyByte = 0;
			//파일에서 읽어올 바이트 데이터 배열
			byte [] buf = new byte[1024]; //1kb 사이즈의 배열
			//읽어온 데이터 배열의 개수
			int readLen = 0;
			
			while(true) {
				//파일 읽기
				readLen= in.read(buf); //완료시점에는 -1반환하는것 동일.
				
				//탈출의 조건 : 파일의 모든 데이터를 읽은 경우
				if(readLen==-1) {
					break;
				}
				
				//출력: 파일에 데이터를 쓴다.
				out.write(buf,0,readLen);
				copyByte+= readLen;
				
			}
			
			//스트림 닫기
			in.close(); 
			out.close();
			
			System.out.println("복사완료!! 복사된 바이트 사이즈 : "+ copyByte+"byte");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}


	}

}
