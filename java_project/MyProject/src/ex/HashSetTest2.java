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
	
	@Override
	public int hashCode() { //적절하게 오버라이딩 해야한다.
		return num%3; // 0,1,2로 그룹화됨
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false; //변수 선언, 초기화
		//obj는 null이 아니고, obj는 SimpleNumber 타입으로 형변환이 가능해야함.
		if(obj!= null && obj instanceof SimpleNumber ) {
			SimpleNumber s = (SimpleNumber)obj;
			if(this.num == s.num) {
				result = true;
			}
		}
	
		return  result;
	}

	public String toString() {
		return String.valueOf(num);//숫자를 문자열로 바꿔줌
	}
	
	
}