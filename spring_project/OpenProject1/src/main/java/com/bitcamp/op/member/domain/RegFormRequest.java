package com.bitcamp.op.member.domain;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class RegFormRequest {
	
	private String memberid;
	private String password;
	private String membername;
	private MultipartFile memberphoto;
	
	public RegFormRequest() {
		// TODO Auto-generated constructor stub
	}

	public RegFormRequest(String memberid, String password, String membername, MultipartFile memberphoto) {
		this.memberid = memberid;
		this.password = password;
		this.membername = membername;
		this.memberphoto = memberphoto;
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

	public MultipartFile getMemberphoto() {
		return memberphoto;
	}

	public void setMemberphoto(MultipartFile memberphoto) {
		this.memberphoto = memberphoto;
	}

	@Override
	public String toString() {
		return "RegFormRequest [memberid=" + memberid + ", password=" + password + ", memberName=" + membername
				+ ", memberphoto=" + memberphoto.getOriginalFilename() + "]";
	}
	
	public Member toMember() {
		if (memberphoto.getOriginalFilename()==null) {
			System.out.println("ddddd");
			
		}
		System.out.println(memberphoto.getOriginalFilename());
		return new Member(0, memberid, password,membername,memberphoto.getOriginalFilename(),null);
	}
	
	
	
}
