package ex;
import java.util.*;

public class IteratorTest {
	public static void main(String[] args) {
		
//		ArrayList<String> list = new ArrayList<String>();
		List<String> list = new ArrayList<String>();// -> 다형성. 이렇게도 선언가능 (이렇게쓰면 어레이리스트, 리스트 둘다 받을수 있다)
		
		//요소 저장 : add(T t)
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Fourth");
		
		for(int i =0; i<list.size();i++) {//정렬하기1.
			System.out.println(list.get(i)); //요소를 가져올때 사용
		}
		System.out.println("=====================");
		for(String str : list) { //정렬하기 2
			System.out.println(str);
		}
		
		System.out.println("---------------------");
		Iterator<String> itr = list.iterator(); // 정렬하기 3
		while(itr.hasNext()) {
			String currentStr = itr.next();
			System.out.println(currentStr);
		}
		
		
		
	}
	
	
}
