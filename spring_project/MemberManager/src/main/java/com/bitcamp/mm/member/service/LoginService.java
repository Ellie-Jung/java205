package com.bitcamp.mm.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.member.dao.MemberDao;

@Service
public class LoginService {
	
	@Autowired
	MemberDao dao;
	
	
}
