



public class CustomerContact extends Contact {

	private String accountName;
	private String item;
	private String rank;

	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	
	
	public CustomerContact(String name, String phoneNum, String email, String address, String birthday, String group,String accountName, String item, String rank) {
		super(name, phoneNum, email, address, birthday, group);
		this.accountName = accountName;
		this.item = item;
		this.rank=rank;
	}
	
	

	public void showData() {
		System.out.println("이름 : "+getName());
		System.out.println("전화번호 : "+getPhoneNum());
		System.out.println("이메일 : "+getEmail());
		System.out.println("주소 : "+getAddress());
		System.out.println("생일 : "+getBirthday());
		System.out.println("그룹 : "+getGroup());
		System.out.println("거래처 회사 이름 :"+getAccountName());
		System.out.println("거래 품목 : "+getItem());
		System.out.println("직급 : "+getRank());
	}
	
}
