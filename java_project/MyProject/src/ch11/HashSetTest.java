package ch11;
import java.util.*;
public class HashSetTest {

	public static void main(String[] args) {
		//2.축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라고 판단하고 입력이 되지않도록 Set<E> 컬렉션이용해서 축구선수인스턴스 저장,출력
		//hashCode와 equals 오버라이딩 해야함.
		
		//HashSet 저장공간 생성
		Set<FootballPlayer> set = new HashSet<FootballPlayer>();
		
		//데이터저장
		set.add(new FootballPlayer("손흥민", 5, "대한팀", 30));
		set.add(new FootballPlayer("메시", 7, "민국팀", 37));
		set.add(new FootballPlayer("이동국", 8, "대한팀", 35));
		set.add(new FootballPlayer("안정환", 10, "민국팀", 40));
		set.add(new FootballPlayer("박지성", 9, "대한팀", 30));
		set.add(new FootballPlayer("박지성", 10, "대한팀", 30));
		set.add(new FootballPlayer("이강인", 2, "민국팀", 20));
		set.add(new FootballPlayer("이강인", 2, "민국팀", 21));
		
		//데이터 출력
		Iterator<FootballPlayer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
