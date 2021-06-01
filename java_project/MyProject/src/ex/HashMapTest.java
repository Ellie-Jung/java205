package ex;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		
		//Map : key-value 형식으로 저장. key는 저장한 데이터를 식별하기 위한값. 중복허용x// value는 저장하고자하는 데이터
		HashMap <Integer,String> map = new HashMap<Integer,String>(); //상위인터페이스 Map을 써도가능
		
		//데이터저장 : put(e)
		map.put(new Integer(1), "일번");
		map.put(5, "오번"); //오토박싱
		map.put(new Integer(8), "팔번");
		
		//데이터 탐색
		System.out.println(map.get(new Integer(5)));
		System.out.println(map.get(1));
		System.out.println(map.get(8));
		System.out.println(map.get(10));
	}

}
