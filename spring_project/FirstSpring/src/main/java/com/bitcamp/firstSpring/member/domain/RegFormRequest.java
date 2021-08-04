package com.bitcamp.firstSpring.member.domain;

import java.io.File;

public class RegFormRequest {
	
	private String memberid;
	private String password;
	private String membername;
	private File photo;
	
	public RegFormRequest() {
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
	
	
	
}
