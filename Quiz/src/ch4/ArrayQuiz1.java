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
		int[] arr = new int[10];  //����ڷ� ���� �Է¹��� ���� �����ϴ� �迭.
		for(;;) {
			System.out.println("���ڸ� �Է����ּ���. (�׸� �Է��ϽǷ��� 0, �ִ�10��)");
			int num = sc.nextInt();
			if(num ==0) {
				break;
			}
			arr[i++]= num;
		}
		System.out.println("�Է��Ͻ� �� �߿� �ִ밪�� ? "+ArrayQuiz1.maxValue(arr));
		System.out.println("�Է��Ͻ� �� �߿� �ּҰ���? "+ArrayQuiz1.miniValue(arr));
	}

}
