package member;

//빈즈 클래스 생성
public class Member {

	//변수는 모두 private처리
	private String id;
	private String pw;
	private String name;
	
	//beans 클래스는 기본생성자 필수!
	public Member(){}
	
	public Member(String name){} //디폴트 생성자가 없는 상태해서 실행해보면 오류생긴다. 
	
	//setter
	public void setId(String id) {
		this.id = id;
	}
	
	//getter
	public String getId() {
		return this.id;
	}
	
	public void setPw(String pw) {
		this.pw=pw;
	}
	public String getPw() {
		return this.pw;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
}
