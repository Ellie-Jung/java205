package ch11;
import java.util.*;

public class MapTest {

	public static void main(String[] args) {
		//4.축구선수 번호를 key로하고 축구선수의 인스턴스를 저장하는 Map<k,v> 인스턴스를 이용해서 프로그램을 만들어보자

		//Map 저장공간 생성
		//번호를 키값으로 하고 value는 축구선수의 인스턴스를 저장.
		Map <Integer,FootballPlayer> map = new HashMap<Integer, FootballPlayer>();
		
		
		//데이터 저장 //Map은 저장시 Put사용
		map.put(5,(new FootballPlayer("손흥민", 5, "대한팀", 30)));
		map.put(7,(new FootballPlayer("메시", 7, "대한팀", 37)));
		map.put(8,(new FootballPlayer("이동국", 8, "대한팀", 35)));
		map.put(10,(new FootballPlayer("안정환", 10, "대한팀", 40)));
		map.put(9,(new FootballPlayer("호나우딩요", 9, "대한팀", 50)));
		map.put(9,(new FootballPlayer("박지성", 9, "대한팀", 30)));
		map.put(2,(new FootballPlayer("이강인", 2, "대한팀", 20)));
		
		
		//데이터 탐색
		Set<Integer> set = map.keySet(); //key를 이용
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next())); //키값을 먼저 정렬하고 맵을 통해서 데이터 가져옴
		}
	

	}

}
