package com.bitcamp.op.member.domain;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class RegFormRequest {
	
	private String memberid;
	private String password;
	private String memberName;
	private MultipartFile memberPhoto;
	
	public RegFormRequest() {
		// TODO Auto-generated constructor stub
	}

	public RegFormRequest(String memberid, String password, String memberName, MultipartFile memberPhoto) {
		this.memberid = memberid;
		this.password = password;
		this.memberName = memberName;
		this.memberPhoto = memberPhoto;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public MultipartFile getMemberPhoto() {
		return memberPhoto;
	}

	public void setMemberPhoto(MultipartFile memberPhoto) {
		this.memberPhoto = memberPhoto;
	}

	@Override
	public String toString() {
		return "RegFormRequest [memberid=" + memberid + ", password=" + password + ", memberName=" + memberName
				+ ", memberPhoto=" + memberPhoto + "]";
	}
	
	
	
	
}
