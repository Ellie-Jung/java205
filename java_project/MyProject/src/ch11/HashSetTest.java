package ch11;
import java.util.*;
public class HashSetTest {

	public static void main(String[] args) {
		
		//HashSet 저장공간 생성
		Set<FootballPlayer> set = new HashSet<FootballPlayer>();
		
		//데이터저장
		set.add(new FootballPlayer("손흥민", 5, "대한팀", 30));
		set.add(new FootballPlayer("메시", 7, "민국팀", 37));
		set.add(new FootballPlayer("이동국", 8, "대한팀", 35));
		set.add(new FootballPlayer("안정환", 10, "민국팀", 40));
		set.add(new FootballPlayer("박지성", 9, "대한팀", 30));
		set.add(new FootballPlayer("박지성", 9, "대한팀", 30));
		set.add(new FootballPlayer("이강인", 2, "민국팀", 20));
		
		//데이터 출력
		Iterator<FootballPlayer> itr = set.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}
	}

}
