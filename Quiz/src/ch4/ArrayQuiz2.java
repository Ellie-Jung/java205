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
		int [][] arr = new int[3][5]; //�迭 ����

		//�迭 �ʱ�ȭ		
		for(int i = 0; i< arr.length;i++)  
			for(int j=0; j<arr[i].length;j++)
				arr[i][j] = (int)(Math.random()*10); //���� ������ �ʱ�ȭ�ϱ�
		for(int[] tmp : arr) {  //������ �迭 ���
			for(int e : tmp) {
				System.out.print(e + " ");
			}System.out.println();
		}
		System.out.println("==================");
		addOnDArr(arr, 6); //�޼ҵ� �̿��ؼ� �� ������Ű��

		//for-each���� �̿��Ͽ� ����ϱ�
		for (int[] tmp: arr) { //�̷��Ե� ��� ����
			for(int e: tmp) {
				System.out.print(e);
			}
			System.out.println();
		}

		/// for���� �̿��� ���
		for(int i =0; i<arr.length;i++) { //�ٲ� �� ���
			for(int j=0;j <arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
	}
}



