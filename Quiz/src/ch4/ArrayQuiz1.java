package ch4;
import java.util.Scanner;
public class ArrayQuiz1 {
	public static int minValue(int[] arr) {
		int min = arr[0];
		for(int i = 1; i<arr.length;i++) {
			if(arr[i]<min) {
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
		int []arr = new int[5];//����ڿ��� ���� ���� �迭
		for(int i=0;i<arr.length;i++) {
			System.out.println("���ڸ� �Է��ϼ���.");
			arr[i]= sc.nextInt();
		}
		System.out.println("�Է��Ͻ� �����߿� �ִ밪 : "+ maxValue(arr));
		System.out.println("�Է��Ͻ� �����߿� �ּҰ� : "+minValue(arr));
		
	}

}
