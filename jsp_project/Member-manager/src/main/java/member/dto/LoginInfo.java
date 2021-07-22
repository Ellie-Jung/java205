package member.dto;

public class LoginInfo {

	private int idx;
	private String memberid;
	private String memberName;
	
	public LoginInfo(int idx, String memberid, String memberName) {
		this.idx = idx;
		this.memberid = memberid;
		this.memberName = memberName;
	}

	//겟터만 만든다. 로그인된 상태에서 얘네 값이 변경되면 안된다. 세터 필요없음
	public int getIdx() {
		return idx;
	}

	public String getMemberid() {
		return memberid;
	}

	public String getMemberName() {
		return memberName;
	}

	@Override
	public String toString() {
		return "LoginInfo [idx=" + idx + ", memberid=" + memberid + ", memberName=" + memberName + "]";
	}
	
	
	
}
