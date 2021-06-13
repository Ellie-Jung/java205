package ch03;

import ch01.Contact;

public class CompanyContact extends Contact {
	
	private String companyName;
	private String deptName;
	private String rank;
	
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}


	public CompanyContact(String name, String phoneNum, String email, String address, String birthday, String group) {
		super(name, phoneNum, email, address, birthday, group);
		this.companyName= companyName;
		this.deptName= deptName;
		this.rank = rank;
		
	}
	public void printInfo() {
		super.printInfo();
		System.out.println("회사 이름 : "+getCompanyName() );
		System.out.println("부서 이름 : "+getDeptName());
		System.out.println("직급 : "+ getRank());
	}
	
}
