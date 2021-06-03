package ch13;

import java.io.*;

public class DataClone extends Thread {
	//데이터의 복사를 처리하는 스레드 

	private String path;
	private String clonePath;

	DataClone(String path, String clonePath) {
		this.path = path;
		this.clonePath = clonePath;
	}

	
	@Override
	public void run() {
		
		try {
			//파일의 데이터 읽어올 스트림 생성
			InputStream in = new BufferedInputStream(new FileInputStream(path));
			//파일을 쓰기위한 스트림 생성
			OutputStream out = new BufferedOutputStream(new FileOutputStream(clonePath));
			
			int copyByte=0; //데이터 크기체크
			
			//파일 읽기
			while (true) {
				
				in.read();
				copyByte++;
				if(in.read()==-1) {
					break;
				}
			}
			
			//파일 쓰기
			out.write(in.read());
			
			//스트림 닫기
			in.close();
			out.close();
			
			System.out.println(copyByte+" 바이트 복사가 완료되었습니다." );
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
 
	
}
