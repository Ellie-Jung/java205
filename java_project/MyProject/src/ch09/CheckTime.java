package ch09;

public class CheckTime {

	public static void main(String[] args) {

		long currentTime = System.currentTimeMillis();
		
		int sum=0;
		for(int i=1 ; i<=100000000;i++) {
			sum +=i;
		}
		
		long finishTime = System.currentTimeMillis();
		
		long takeTime = finishTime - currentTime;
		System.out.println("소요시간 : " +takeTime +" milliseconds");
		System.out.println("시작시간 : "+ currentTime);
		System.out.println("종료시간 : "+ finishTime);
	
	}

}
