package ch11;

public class FootballPlayer implements Comparable<FootballPlayer> {

	private String name;
	private int number;
	private String team;
	private int age;

	FootballPlayer(String name, int number, String team, int age) {
		this.name=name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return age%10;
	}
	@Override
	public boolean equals(Object obj) { //팀과 이름 나이가 같으면 같은 선수라 판단
		boolean result = false;
		if(obj!=null && obj instanceof FootballPlayer) {
			FootballPlayer f = (FootballPlayer)obj;
			if(this.name.equals(f.name) && this.name.equals(f.name) && this.age==f.age) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public int compareTo(FootballPlayer o) { //TreeSet을 사용하기 위해 구현.
		//팀이름순으로 정렬
		int result = this.team.compareTo(o.getTeam()); //->음수, 양수, 0
		if(result ==0) { //팀 이름이 같다면, 이름순으로 저장
			result = this.name.compareTo(o.getName());
			if(result ==0) { //선수 이름이 같다면, 번호순으로 저장
				result = this.number-o.getNumber();
			}
		}
		return result;

	}




}
