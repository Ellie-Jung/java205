package ch4;
import java.util.Scanner;
public class ArrayQuiz1 {
	public static int miniValue(int[] arr) {
		int min = arr[0];
		for(int i = 1; i<arr.length;i++) {
			if(arr[i]>min) {
				min = arr[i];
			}
		}
		return min;
	}
	public static int maxValue(int[] arr) {
		int max = arr[0];
		for(int i = 1; i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int[] arr = new int[10];  //사용자로 부터 입력받은 값을 저장하는 배열.
		for(;;) {
			System.out.println("숫자를 입력해주세요. (그만 입력하실려면 0, 최대10개)");
			int num = sc.nextInt();
			if(num ==0) {
				break;
			}
			arr[i++]= num;
		}
		System.out.println("입력하신 값 중에 최대값은 ? "+ArrayQuiz1.maxValue(arr));
		System.out.println("입력하신 값 중에 최소값은? "+ArrayQuiz1.miniValue(arr));
	}

}
