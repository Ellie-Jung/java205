
public class ArrayQuiz2 {
	public static void addOneDArr(int[] arr, int add){ //다음 메서드는 int형 1차원 배열에 저장된 값을 두 번째 매개변수로 전달될 값의 크기만큼 전부 증가시킨다.
		for (int i=0; i<arr.length; i++) {
			arr[i] +=add;
		}
	}
	//이 메서드를 기반으로(이 메서들르 호출하는 형태로)int형 2차원 배열에 저장된 값 전부를 증가시키는 메서드를 다음의 형태로 정의하자.
	public static void addOneDArr(int[][] arr, int add) {
		
			for(int i = 0; i<arr.length ; i++) { // 위의 메서드를 호출하는 형태로 정의.
				addOneDArr(arr[i], add);
			}
		
//		for(int i = 0; i<arr.length ; i++) {
//			for( int j = 0; j<arr[i].length;j++) {
//				arr[i][j] += add;
//			}
//		}
//		
		
	}
	public static void main(String[] args) {
		
		// 배열 임의로 채우기
		int [][] arr = new int[5][5];
		for(int i = 0; i<arr.length ; i++) {
			for (int j =0; j <arr[i].length; j++) {
				int n = (int)(Math.random()*10);
				int tmp = arr [i][j];
				arr[i][j] = n;
				n = tmp;
			}
		}
		
		for (int[] is : arr) {
			for (int is2 : is) {
				System.out.print(is2+" ");
			}System.out.println();
		}
		
		System.out.println("=================="); 
		ArrayQuiz2.addOneDArr(arr, 3); //함수 이용해서 특정 값만큼 증가 시킨다.
		for (int[] is : arr) {
			for (int is2 : is) {
				System.out.print(is2+" ");
			}System.out.println();
		}
		
	}

}
