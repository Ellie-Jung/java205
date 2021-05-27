package ch4;
public class ArrayQuiz3 {
	static void change(int[][]arr) {
		for(int i =arr.length-1; i>=0;i--) {
			for(int j = 0; j<arr[i].length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		change(arr);

	}

}