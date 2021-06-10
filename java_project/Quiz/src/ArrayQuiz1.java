import java.util.Scanner;

//int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값, 
//그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
//int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는 임의로 결정
		
public class ArrayQuiz1 {
	public static int minValue(int[] arr) { //최소값 반환
		int min=arr[0] ;
		for(int i =0; i<arr.length ; i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		return min;
	}
	public static int maxValue(int[] arr) { //최댓값 반환
		int max = arr[0];
		for(int i = 0; i<arr.length ; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int[5];
		
		for(int i = 0; i<5 ; i++) {
			System.out.println("숫자를 입력해주세요");
			arr[i] = sc.nextInt();
			
		}
		
		System.out.println("입력하신 값중 최댓값은 : "+maxValue(arr));
		System.out.println("입력하신 값중 최소값은 : "+minValue(arr));
		
	}
	
	
	
}
