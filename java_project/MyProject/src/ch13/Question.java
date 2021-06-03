package ch13;

import javax.swing.JOptionPane;

class Question extends Thread{

	@Override
	public void run() {
		//1~100사이의 랜덤 한 숫자 추출 
		int answer = (int)(Math.random()*100);
		
		//정답 받아서 비교하기
		while(true) {
			String input= JOptionPane.showInputDialog("숫자맞추기 게임입니다. 1~100사이의 숫자를 맞춰주세요") ;
			int num = Integer.parseInt(input);

			if(answer<num) {
				System.out.println("더 작은 숫자 입니다.");
			}else if(answer > num){
				System.out.println("더 큰 숫자 입니다.");
			}else {
				System.out.println("정답입니다. !!");
			
				break;
			}
		}
		HiLowGame.check = true;
		System.exit(0);
	}
}