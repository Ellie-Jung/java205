package ch4;

public class ArrayQuiz2 {
	public static void addOneDArr(int[] arr, int add) {
		for(int i = 0; i <arr.length;i++) {
			arr[i] += add;
			System.out.print(arr[i]+"");
		}

	}
	public static void addOnDArr(int[][]arr, int add) {
		for(int i= 0; i <arr.length;i++) {
			for(int j =0; j< arr[i].length;j++)
				arr[i][j] += add;
		}
		for(int i= 0; i <arr.length;i++) {
			for(int j =0; j< arr[i].length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();			
		}
	}
	public static void main(String[] args) {
		int [][] arr = new int[3][5];
		addOnDArr(arr, 6);


	}

}
