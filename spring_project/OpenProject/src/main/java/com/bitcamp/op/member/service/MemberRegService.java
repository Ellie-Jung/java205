package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.RegFormRequest;


@Service
public class MemberRegService {
	
	@Autowired
	MemberDao dao;
	
	final String UPLOAD_URI = "/uploadfile";

	public int regMember(RegFormRequest regFormRequest,HttpServletRequest request) {
		int resultCnt= 0;
		Member member=new Member();
		Connection conn=null;
		File newFile= null;
		
		
		try {
				
	
			conn = ConnectionProvider.getConnection();
			
			System.out.println(regFormRequest);
			
			member.setMemberid(regFormRequest.getMemberid());
			member.setPassword(regFormRequest.getPassword());
			member.setMembername(regFormRequest.getMembername());

			if(regFormRequest.getMemberphoto()!=null) {
				member.setMemberphoto(regFormRequest.getMemberphoto().getOriginalFilename());
				saveFile(request, regFormRequest.getMemberphoto());
			}
			
			resultCnt =dao.insertMember(conn, member);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			if (newFile !=null && newFile.exists()) {
				//파일을삭제
				newFile.delete();
				System.out.println("파일삭제");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
		
		request.setAttribute("result", resultCnt);
		
		
		
		return resultCnt; //정상적으로 처리되면 결과1나온다.
	}
	
	
	// 사용자가 업로드한 파일을 저장하는 메서드
		private void saveFile(HttpServletRequest request, MultipartFile file) throws IllegalStateException, IOException {
			
			// 저장 경로 : 시스템 경로
			String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
			// 새롭게 저장할 파일
			File newFile = new File(saveDir ,file.getOriginalFilename() );
			
			// 파일 저장
			file.transferTo(newFile);		
			
		}
	
}
