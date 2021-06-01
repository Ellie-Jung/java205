package ch11;

public class FootballPlayer implements Comparable<FootballPlayer> {

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
	public void showData() {
		System.out.printf("%s, %d, %s, %d\n",this.name, this.number, this.team, this.age);
	}
	
	@Override
	public int hashCode() {
		return age/10;
	}
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj!=null && obj instanceof FootballPlayer) {
			FootballPlayer f = (FootballPlayer)obj;
			if(f.name ==name&& f.number==number &&f.team==team && f.age==age) {
				result = true;
			}
		}
		return result;
	}
	@Override
	public int compareTo(FootballPlayer o) {
		//팀이름순으로 정렬
		if(this.team.compareTo(o.team)>0) return 1;
		else if(this.team.compareTo(o.team)<0) return -1;
		else { //같은팀 선수들은 이름순으로 정렬
			if(this.name.compareTo(o.name)>0) return 1;
			else if (this.name.compareTo(o.name)<0) return -1;
			else { //같은이름의 선수는 번호순으로 저장
				return this.number-o.number;
			}
		} 
	}
	
	
}
