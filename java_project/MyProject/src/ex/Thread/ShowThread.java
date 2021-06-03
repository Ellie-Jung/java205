package ex.Thread;
public class ShowThread extends Thread {

	String tName;
	public ShowThread(String name) {
		tName = name;
	}

	@Override
	public void run() {
		for(int i =0; i<100; i++) {
			System.out.println("안녕하세요"+ tName + "입니다.");

			try {
				sleep(100);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
