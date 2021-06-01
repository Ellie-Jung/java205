package ch11;

import java.util.*;

public class TreeSetTest {

	public static void main(String[] args) {
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

		//데이터 출력
		Iterator<FootballPlayer> itr = tset.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}

	}

}
