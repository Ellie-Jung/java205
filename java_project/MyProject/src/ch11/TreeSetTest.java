package ch11;

import java.util.*;

public class TreeSetTest {

	public static void main(String[] args) {
		//3.TreeSet<E>을 이용해서 팀이름순으로 정렬하고, 같은 팀의 선수들은 이름순으로 정렬하고, 같은 이름의 선수는 번호순으로 저장.
		//comparable 인터페이스 구현해서 compareTo메서드로 정렬기준 완성해야함
		
		//TressSet 저장공간 생성
		Set<FootballPlayer> tset = new TreeSet<FootballPlayer>();

		//데이터저장
		tset.add(new FootballPlayer("손흥민", 5, "대한팀", 30));
		tset.add(new FootballPlayer("메시", 7, "민국팀", 37));
		tset.add(new FootballPlayer("이동국", 8, "대한팀", 35));
		tset.add(new FootballPlayer("안정환", 10, "민국팀", 40));
		tset.add(new FootballPlayer("박지성", 9, "대한팀", 30));
		tset.add(new FootballPlayer("박지성", 8, "대한팀", 30));
		tset.add(new FootballPlayer("이강인", 2, "민국팀", 20));
		tset.add(new FootballPlayer("이강인", 2, "민국팀", 20));

		//데이터 출력
		Iterator<FootballPlayer> itr = tset.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
