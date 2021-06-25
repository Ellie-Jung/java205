package member;

public class Member {

	

	private int idx;
	private String id;
	private String password;
	private String name;
	private String phonenum;
	private String email;
	
	public Member() {}
	public Member(int idx) {
		this.idx = idx;
	}
	public Member(String password, String name, String phonenum, String email) {
		this.password = password;
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
	}
	
	public Member(String id, String password, String name, String phonenum, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
	}
	
	public Member(int idx, String password, String name, String phonenum, String email) {
		this.idx = idx;
		this.password = password;
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
	}
	
	public Member(int idx, String id, String password, String name, String phonenum, String email) {
		this.idx = idx;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
	}
//
//	public Member(String id, String password, String name, String email, String phonenum) {
//		this.id = id;
//		this.password = password;
//		this.name = name;
//		this.email = email;
//		this.phonenum = phonenum;
//	}
//	public Member(int idx, String password, String name, String email, String phonenum,String id ) {
//		this.idx = idx;
//		this.id = id;
//		this.password = password;
//		this.name = name;
//		this.email = email;
//		this.phonenum = phonenum;
//		
//	}
//	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	
	
	@Override
	public String toString() {
		return "Member [idx=" + idx + ", id=" + id + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", phonenum=" + phonenum + "]";
	}
}