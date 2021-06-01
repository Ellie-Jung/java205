package ch11;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {

		//Map 저장공간 생성
		//번호를 키값으로 하고 value는 축구선수의 인스턴스를 저장.
		Map <Integer,FootballPlayer> map = new HashMap<Integer, FootballPlayer>();
		
		//데이터 저장
		map.put(5,(new FootballPlayer("손흥민", 5, "대한팀", 30)));
		map.put(7,(new FootballPlayer("메시", 7, "대한팀", 37)));
		map.put(8,(new FootballPlayer("이동국", 8, "대한팀", 35)));
		map.put(10,(new FootballPlayer("안정환", 10, "대한팀", 40)));
		map.put(9,(new FootballPlayer("호나우딩요", 9, "대한팀", 50)));
		map.put(9,(new FootballPlayer("박지성", 9, "대한팀", 30)));
		map.put(2,(new FootballPlayer("이강인", 2, "대한팀", 20)));
		
		//데이터탐색
		map.get(5).showData();
		map.get(7).showData();
		map.get(8).showData();
		map.get(10).showData();
		map.get(9).showData();
		map.get(2).showData();
		

	}

}
