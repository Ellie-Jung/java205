package ch09;

import java.util.Scanner;

public class CheckString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력해 주세요 >>");
		String chk = sc.nextLine();

		if(chk.trim().length() ==0) {
			System.out.println("공백이 입력되었습니다.");
		}else 
			System.out.println(chk+"이/가 입력되었습니다.");

	}

}


