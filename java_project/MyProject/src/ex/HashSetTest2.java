package ex;

import java.util.*;

public class HashSetTest2 {

	public static void main(String[] args) {

		//HashSet 저장공간 생성 : 인스턴스 저장, 중복 저장을 허용하지 않는다. 저장 순서를 가지지않는다.
		Set<SimpleNumber> hashSet = new HashSet<>(); //상위 인터페이스 타입Set 사용

		//데이터저장
		hashSet.add(new SimpleNumber(10));
		hashSet.add(new SimpleNumber(20));
		hashSet.add(new SimpleNumber(20));


		//데이터의 일괄처리
		Iterator<SimpleNumber> itr = hashSet.iterator(); //상위타입 Iterator 

		while(itr.hasNext()) {
			System.out.println(itr.next());
		}


	}

}

class SimpleNumber{ //hashcode와 equals를 적절하게 오버라이딩 해야한다.
	
	int num;
	SimpleNumber(int num) {
		this.num = num;
	}
	
	public String toString() {
		return String.valueOf(num);//숫자를 문자열로 바꿔줌
	}
	
	
}