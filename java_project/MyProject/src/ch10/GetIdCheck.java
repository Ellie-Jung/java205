package ch10;

import java.util.Scanner;

public class GetIdCheck {
	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 >>");
		String userId = sc.nextLine();

		userId = userId.trim().toUpperCase();
		char[] ch = userId.toCharArray();
		char chk = 0;
		for(int i = 0; i<userId.length();i++) {
			 chk=ch [i];
		}
		try {
			if(userId.length()==0 || !(chk >=65&& chk<=90 ) && !(chk>=48 &&chk<=57)) {
				throw new BadIdInputException("잘못입력하셨습니다.");
			}
		}catch (BadIdInputException e) {
			
			System.out.println(e.getMessage());
		}

	}
}

