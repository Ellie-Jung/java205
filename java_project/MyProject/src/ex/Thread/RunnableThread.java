package ex.Thread;

public class RunnableThread {

	public static void main(String[] args) {
		
		//Runnable  타입의 인스턴스 생성
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		
		//Thread 인스턴스 생성
		//new Thread(Runnable target)
		Thread t1 = new Thread(at1); 
		Thread t2 = new Thread(at2); 
		
		//Thread start();
		t1.start();
		t2.start();
		
		try {
			t1.join(); // join메서드를 호출하지 않는다면, 추가로 생성된 두 쓰레드가 작업을 완료하기전에 메인쓰레드가 값을 참조하여 쓰레기 값이 출력될수 있다.
			t2.join(); // join() 해당 쓰레드가 종료될때까지 (메인쓰레드의)실행을 멈출때 사용
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~100까지의 숫자 합 : "+(at1.getNum()+at2.getNum())); //문자열과 at1.getNum이 먼저 덧셈되면 안됨!! 괄호로 숫자계산끼리 묶어주기
		

	}

}
class AdderThread extends Sum implements Runnable{
	int startNum;
	int endNum;
	
	public AdderThread(int startNum, int endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
	}

	@Override
	public void run() {
		
		for(int i = startNum; i<=endNum;i++) {
			addNum(i);
		}
		
	}
}


class Sum{
	int num;
	
	public void addNum(int n) {
		num += n;
	}
	
	public int getNum() {
		return num;
	}
}

