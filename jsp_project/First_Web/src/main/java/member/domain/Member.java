package member.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class Member {

	//변수는 모두 private처리
	private int idx;
	private String id;
	private String pw;
	private String name;
	private Timestamp joinDate;
	
	public Member(){}

	public Member(int idx, String id, String pw, String name, Timestamp joinDate) {
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.joinDate = joinDate;
	}

	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void setId(String id) {
		this.id = id;
	}
	
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

	public Timestamp getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}

	//java.sql.TimeStamp -> java.util.Date
	public Date getDate() {
		return new Date(getJoinDate().getTime());
	}
	
	
	
}
