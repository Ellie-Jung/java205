package ch06;
import java.util.Arrays;
public class ScoreManager {
	public static void main(String[] args) {
		//1. 국어,영어,수학 점수 10개씩 저장하는 배열을 정의하고 점수를 입력.
		// 점수를 모두 출력하고 평균점수를 출력하는 프로그램작성
		
		int[] korScore = new int[10]; //국어점수 저장하는 배열
		int[] engScore = new int[10]; //영어점수 저장하는 배열
		int[] mathScore = new int[10]; //수학 점수 저장하는 배열
		
		//점수를 입력 
		korScore[0] = 100;
		korScore[1] = 70;
		korScore[2] = 52;
		korScore[3] = 40;
		korScore[4] = 31;
		korScore[5] = 72;
		korScore[6] = 14;
		korScore[7] = 97;
		korScore[8] = 80;
		korScore[9] = 41;
		
		//점수 모두를 출력하기 //배열의 모든 요소를 출력. 배열 -> 일괄처리 -> 반복문 이용, 공통된 작업을 일괄처리
		for(int idx =0; idx< korScore.length; idx++) {
			System.out.println(korScore[idx]);
		}
//			System.out.println(Arrays.toString(korScore)); // -> 배열의 내용을 문자열로 바꿔줌. 배열 읽을 때 사용
		//점수의 총합 구하고 평균 구하기 // sum = sum+i 
		int sum=0;
		for(int i = 0; i < korScore.length; i++) {
			sum += korScore[i];
		}
		System.out.println("국어 점수의 합 : "+sum);
		
		//평균구하기 ->총합/배열의 개수 //length는 int로 받음, 명시적 형변환이 필요
		float avg = (float)sum/korScore.length;
		System.out.println("국어 점수의 평균 : "+avg);
		
	}

}
