package ex;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {

		//HashSet 저장공간 생성 : 인스턴스 저장, 중복 저장을 허용하지 않는다. 저장 순서를 가지지않는다.
		//		HashSet<String> hashSet = new HashSet<String>();
		HashSet<Integer> hashSet = new HashSet<Integer>();

		//데이터저장
		//		hashSet.add("First");
		//		hashSet.add("Second");
		//		hashSet.add("Third");
		//		hashSet.add("First");
		hashSet.add(1); // autoboxing됨
		hashSet.add(2);
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);



		//데이터의 일괄처리
		//	Iterator<String> itr = hashSet.iterator(); //상위타입 Iterator 
		Iterator<Integer> itr = hashSet.iterator(); //상위타입 Iterator 

		while(itr.hasNext()) {
			System.out.println(itr.next());
		}


	}

}
