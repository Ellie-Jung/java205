package ch10;
import java.util.*;
public class GetYearCheck {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("태어난 연도를 입력해 주세요 >>");
		try {
			int year = sc.nextInt();
			if(year<1900 || year>2021) {
				throw new Exception("잘못 입력하셨습니다.");
			}
			
		}catch (InputMismatchException e) {
			System.out.println("에러메세지 : 숫자를 넣어주세요.");
		}
		catch (Exception e) {
			
			System.out.println("에러메세지 : "+e.getMessage());
		}
		
	}

}
