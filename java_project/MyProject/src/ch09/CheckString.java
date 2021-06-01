package ch09;

import java.util.Scanner;

public class CheckString {
	static boolean checkName(String name) {

		boolean result = true;
		for(int i=0;i<name.length();i++) {
			char ch = name.charAt(i);
			if(!(ch>='a'&&ch<='z'|| ch>='A'&&ch<='Z')) {
				result =false;
				break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		//사용자에게 이름을 입력받아 입력 받은 문자열을 정상적인 문자열의 이름으로 표현하는지 판별하고, 공백으로 입력되었는지 판별하는 프로그램
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 영어로 입력해 주세요 >>");
		String chk = sc.nextLine();

		if(chk.trim().length() !=0) {
			if(checkName(chk)) {
				System.out.println(chk+"이/가 입력되었습니다.");
			}
			else {
				System.out.println("잘못입력되었습니다.");
			}
		}else {
			System.out.println("공백이 입력되었습니다.");
		}
	}
}


