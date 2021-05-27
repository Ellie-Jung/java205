package ch4;
public class ArrayQuiz3 {
	static void changeDown(int[][] arr) {

		int[]tmp = arr[arr.length-1];
		for(int i = arr.length-1;i>0;i--) {
			arr[i] = arr[i-1];
		}
		arr[0]= tmp;
	}
	static void changeUp(int [][] arr) {
		int[] tmp = arr[arr.length-1];
		for(int i=0 ; i<arr.length-1;i++) {
			tmp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1]=tmp;
		}
	}
	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3},
				{4,5,6,4},
				{7,8,9},
				{2,3,4},
				{5,2,3}
		};
		//한칸씩 내리기
		changeDown(arr);
		for( int[] tmp: arr) {
			for( int e : tmp) {
				System.out.print(e+" ");
			}System.out.println();
		}
		System.out.println("=================");
		//한칸씩 올리기
		changeUp(arr);
		changeUp(arr);
		for(int[] tmp : arr) {
			for(int e : tmp) {
				System.out.print(e+" ");
			}System.out.println();
		}
		
	}
}