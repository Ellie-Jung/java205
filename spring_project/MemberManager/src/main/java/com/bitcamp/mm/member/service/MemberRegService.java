package com.bitcamp.mm.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.domain.Member;
import com.bitcamp.mm.member.domain.RegFormRequest;
import com.bitcamp.mm.util.ConnectionProvider;
import com.bitcamp.mm.util.JdbcUtil;

@Service
public class MemberRegService {
	
	@Autowired
	MemberDao dao;
	
	final String UPLOAD_URI = "/uploadfile";

	public int regMember(RegFormRequest regFormRequest,HttpServletRequest request) {
		int resultCnt= 0;
		Connection conn=null;
		File newFile=null;
		
		try {
			
			// 1. 파일 저장
			
			// 시스템 경로
			String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI) ;
			// 새로운 저장 폴더 file
			File newDir=new File(path);
			
			// 폴더가 존재하지 않으면 폴더 생성
			if(!newDir.exists()) {
				newDir.mkdir();
				System.out.println("저장 폴더를 생성했습니다.");
			}
			// 파일 저장시에 파일 이름이 같으면 덮어쓴다. ->  회원별 고유한 파일 이름을 만들자 !
			String newFileName= regFormRequest.getMemberid()+System.currentTimeMillis();
			
			// 새로운 File 객체
			newFile= new File(newDir, newFileName);
			
			//파일 저장
			if(regFormRequest.getMemberphoto()!=null && !regFormRequest.getMemberphoto().isEmpty()) {
				regFormRequest.getMemberphoto().transferTo(newFile);
			}
			
			// 2. dao 저장
			conn = ConnectionProvider.getConnection();
			
			// Member 객체 생성 -> 저장된 파일의 이름을 set
			Member member= regFormRequest.toMember();
			member.setMemberphoto(newFileName);
			
			resultCnt = dao.insertMember(conn, member);
				
			
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			// DB 예외 발생시 -> 저장된 파일을 삭제
			if(newFile!= null&& newFile.exists()) {
				newFile.delete();
			}
			
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		
		return resultCnt;
	}
	
}