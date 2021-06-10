
public class ArrayQuiz3 {
	static void shiftArr(int [][]arr) {
		for(int i =arr.length-1; i>0 ; i--) {
			int [] tmp = arr[i]; 
			arr[i] = arr[i-1];
			arr[i-1] = tmp;
		}
	}
	public static void main(String[] args) {

		int [][] arr = {{1,2,3}, {4,5,6},{7,8,9}};
		// 다음 형태의 2차원 배열을 메소드를 이용해서 한칸식 쉬프트 시킨다 ( 789, 123,456이 출력되도록)

		ArrayQuiz3.shiftArr(arr);
		for (int[] is : arr) {
			for (int is2 : is) {
				System.out.print(is2);
			}System.out.println();
		}
	}

}
