package ch4;
public class ArrayQuiz2 {
	public static void addOneDArr(int[] arr, int add) {
		for(int i = 0; i <arr.length;i++) {
			arr[i] += add;
		}
	}
	public static void addOnDArr(int[][]arr, int add) {
		for (int i=0; i<arr.length; i++) {
			ArrayQuiz2.addOneDArr(arr[i], add);
		}
	}
	public static void main(String[] args) {
		int [][] arr = new int[3][5]; //배열 생성

		//배열 초기화		
		for(int i = 0; i< arr.length;i++)  
			for(int j=0; j<arr[i].length;j++)
				arr[i][j] = (int)(Math.random()*10); //랜덤 값으로 초기화하기
		for(int[] tmp : arr) {  //원래의 배열 출력
			for(int e : tmp) {
				System.out.print(e + " ");
			}System.out.println();
		}
		System.out.println("==================");
		addOnDArr(arr, 6); //메소드 이용해서 값 증가시키기

		//for-each문을 이용하여 출력하기
		for (int[] tmp: arr) { //이렇게도 출력 가능
			for(int e: tmp) {
				System.out.print(e);
			}
			System.out.println();
		}

		/// for문을 이용한 출력
		for(int i =0; i<arr.length;i++) { //바뀐 값 출력
			for(int j=0;j <arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
	}
}



