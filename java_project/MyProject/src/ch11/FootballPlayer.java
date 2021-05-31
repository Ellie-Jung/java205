package ch11;

import java.util.*;

public class FootballPlayer {

	String name;
	int number;
	String team;
	int age;
	
	FootballPlayer(String name, int number, String team, int age) {
		this.name=name;
		this.number = number;
		this.team = team;
		this.age = age;
	}
	
	
	public static void main(String[] args) {
		List<FootballPlayer> list = new ArrayList<FootballPlayer>();
		list.add(new FootballPlayer("손흥민", 5, "대한팀", 30));
		list.add(new FootballPlayer("메시", 7, "민국팀", 37));
		list.add(new FootballPlayer("이동국", 8, "대한팀", 35));
		list.add(new FootballPlayer("안정환", 10, "민국팀", 40));
		
		for(int i =0; i<list.size();i++) {
			System.out.println(list.get(i).age);
		}
		
		Iterator<FootballPlayer> itr =list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().name);
		}

		
	}
}
