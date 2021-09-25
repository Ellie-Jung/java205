package com.bitcamp.orl.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.member.dao.Dao;

@Service
public class MemberDeleteService {

    //멤버의 Dao
    private Dao dao;

    @Autowired
    private SqlSessionTemplate template;

    //멤버 삭제하기
    public int deleteMember(int memberIdx) {
        return template.getMapper(Dao.class).deleteMember(memberIdx);

    }

}