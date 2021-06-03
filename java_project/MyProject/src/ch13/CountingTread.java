package ch13;

class CountingThread extends Thread{

	// 10초 카운팅 스레드 만들기
	@Override
	public void run() {
		for(int i=10; i>0; i--) {
			if(HiLowGame.check) {
				break;
			}
			System.out.println(i);

			try {
				Thread.sleep(1000); //1초마다 출력
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println("입력시간이 지났습니다. 종료합니다.");
		System.exit(0); //종료

	}
}