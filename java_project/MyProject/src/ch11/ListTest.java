package ch11;

import java.util.*;

public class ListTest {
	public static void main(String[] args) { 
		//1. 축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서 인스턴스를 저장,출력하기

		//List<E> 컬렉션 인스턴스 생성하기
		List<FootballPlayer> list = new ArrayList<FootballPlayer>();

		//데이터 저장
		list.add(new FootballPlayer("손흥민", 5, "대한팀", 30));
		list.add(new FootballPlayer("메시", 7, "민국팀", 37));
		list.add(new FootballPlayer("이동국", 8, "대한팀", 35));
		list.add(new FootballPlayer("안정환", 10, "민국팀", 40));
		list.add(new FootballPlayer("박지성", 9, "대한팀", 30));
		list.add(new FootballPlayer("박지성", 9, "대한팀", 30));
		list.add(new FootballPlayer("이강인", 2, "민국팀", 20));

	
		//데이터 출력
		Iterator<FootballPlayer> itr =list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next()); //toString이용한 출력
		}

	}
	
	
}
