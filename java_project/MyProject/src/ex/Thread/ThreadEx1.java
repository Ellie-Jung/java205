package ex.Thread;
import javax.swing.JOptionPane;

public class ThreadEx1 { 
	
	public static boolean chk = false;

	public static void main(String[] args) { //메인스레드
		//멀티쓰레드 구현하기

		CountDownThread ct = new CountDownThread(); //스레드1
		InputThread it = new InputThread(); //스레드2
		it.start();
		ct.start();
	}

}
class InputThread extends Thread{
	public void run() {
		//스레드2
		String name = JOptionPane.showInputDialog("이름을 입력해주세요") ;
		ThreadEx1.chk = true;
		System.out.println("안녕하세요. "+name+ "님");
	}
}

class CountDownThread extends Thread{
	//스레드1
	@Override
	public void run() {
		for (int i =10; i>0;i--) {
			if(ThreadEx1.chk) return;
			System.out.println(i);
			try {
				sleep(1000); //1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
		}
		System.out.println("입력시간이 지나 프로그램을 종료합니다.");
		System.exit(0);;
	}
}