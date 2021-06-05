package ex.network;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionTest {

	public static void main(String[] args) {
		
		String urlStr = "https://sports.news.naver.com/news.nhn?oid=421&aid=0005392894";
		
		try {
			URL url = new URL(urlStr);
			
			//HttpURLConnection : url.openConnection()
			HttpURLConnection hcon = (HttpURLConnection) url.openConnection(); //형변환, IO예외처리
			
			for(int i =1; i<= 8; i++) {
				System.out.print(hcon.getHeaderFieldKey(i));
				System.out.println(" : " + hcon.getHeaderField(i));
			}
			
			hcon.disconnect(); //통신 다 끝나면 연결 끊어주기.
			
			//출력시 referrer : 이전페이지의 정보를 가지고있다. 
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
