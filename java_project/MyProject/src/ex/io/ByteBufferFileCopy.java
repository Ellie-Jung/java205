package ex.io;
import java.io.*;
public class ByteBufferFileCopy { 
	public static void main(String[] args) {
		// 필터 스트림 생성시에는 기본 스트림이 필요하다.

		try {

			// 1. 파일의 바이너리 데이터를 읽어올 스트림 생성 : FileInputStream
			InputStream in = new FileInputStream("origin.pdf"); //다형성
			//2.파일을 쓰기위한 스트림 생성 : FileOutputStream
			FileOutputStream out = new FileOutputStream("copy3.pdf"); //내가원하는 위치에 설정

			//3. 필터스트림 생성 -> 기본스트림이 필요
			BufferedInputStream fin = new BufferedInputStream(in);
			BufferedOutputStream fout =  new BufferedOutputStream(out);


			//카피한 데이터의 크기
			int copyByte = 0;
			//파일에서 읽어올 바이트 데이터
			int bData = -1; //초기화

			while(true) { //파일 읽기
				bData = fin.read();

				//탈출의 조건 : 파일의 모든 데이터를 읽은 경우
				if(bData==-1) {
					break;
				}

				//출력: 파일에 데이터를 쓴다.
				fout.write(bData);
				copyByte++;
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
