package ch10;

import java.util.Scanner;

public class GetIdCheck {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요 (영문 또는 숫자만 허용)");
		String id = sc.nextLine();
		id = id.trim();

		try {
			if(!(id.length()==0)){
				char chk = 0;
				for(int i =0; i<id.length(); i++) {
					chk = id.toLowerCase().charAt(i);
				}
				if(!(chk>='a'&&chk<='z'  || chk>='A'&&chk<='Z'|| chk>='0' && chk<='9')){
					throw new BadIdInputException("아이디는 숫자나 영문만 가능합니다.");
				}else {
					System.out.println("아이디는 "+ id+"입니다.");
				}
			}else 
				System.out.println("빈칸을 입력하셨습니다.");
			
		} catch (BadIdInputException e) {
			System.out.println(e.getMessage());
		}

	}

}

