package ch4;
public class ArrayQuiz3 {
	static void change(int[][] arr) {

		int[]tmp = arr[arr.length-1];
		for(int i = arr.length-1;i>0;i--) {
			arr[i] = arr[i-1];
		}
		arr[0]= tmp;

		for(int i =0; i<arr.length;i++) {
			for(int j=0;j <arr[i].length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3},
				{4,5,6,4},
				{7,8,9},
				{2,3,4},
				{5,2,3}
		};
		change(arr);
	}
}