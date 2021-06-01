package ch09;

public class CheckTime {
	//1~100000000 까지 더하기하는 연산의 실행 시간을 측정하는 프로그램 만들기.
	public static void main(String[] args) {

		long currentTime = System.currentTimeMillis(); //현재시간 //1970.01.01 00:00:00 부터 현재시간까지 계산한 결과 받아옴
		//System.nanoTime(); 도 이용 가능.나노초단위로 출력가능.밀리초보다 세세하게 체크시 사용
		
		long sum=0; 
		for(int i=1 ; i<=100000000;i++) { //더하기실행
			sum +=i;
		}
		
		long finishTime = System.currentTimeMillis();//작업 끝난 후 시간
		
		long takeTime = finishTime - currentTime;
		
		System.out.println("소요시간 : " +takeTime +" milliseconds");
		System.out.println("시작시간 : "+ currentTime+"ms");
		System.out.println("종료시간 : "+ finishTime+"ms");
	
	}

}
