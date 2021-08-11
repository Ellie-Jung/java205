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
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.RegFormRequest;


@Service
public class MemberRegService {
	
	/*
	 * @Autowired MemberDao dao;
	 */
	
	@Autowired
	private JdbcTemplateMemberDao dao;
	
	final String UPLOAD_URI = "/uploadfile";

	public int regMember(RegFormRequest regFormRequest,HttpServletRequest request) {
		int resultCnt= 0;
	//	Connection conn=null;
		File newFile= null;
		
		
		try {
			// 1. 파일 저장
			
			// 시스템 경로
			String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
			// 새로운 저장 폴더 : File
			File newDir = new File(path);
			
			// 폴더가 존재하지 않으면 폴더 생성
			if(!newDir.exists()) {
				newDir.mkdir();
				System.out.println("저장 폴더를 생성했습니다.");
			}
			// 파일 저장시에 파일 이름이 같으면 덮어쓴다 -> 회원별 고유한 파일 이름을 만들자!!
			String newFileName = regFormRequest.getMemberid()+System.currentTimeMillis(); 
			//   cool123128936798123987

			// 새로운 File 객체
			newFile = new File(newDir, newFileName);
			
			// 파일 저장
			if(regFormRequest.getMemberphoto() != null && !regFormRequest.getMemberphoto().isEmpty()) {
				regFormRequest.getMemberphoto().transferTo(newFile);
			}
			
			// 2. dao 저장
//			conn = ConnectionProvider.getConnection();
			
			// Member 객체 생성 -> 저장된 파일의 이름을 set
			Member member = regFormRequest.toMember();
			member.setMemberphoto(newFileName);
			/*
			 * conn = ConnectionProvider.getConnection();
			 * 
			 * System.out.println(regFormRequest);
			 * 
			 * member.setMemberid(regFormRequest.getMemberid());
			 * member.setPassword(regFormRequest.getPassword());
			 * member.setMembername(regFormRequest.getMembername());
			 * 
			 * if(regFormRequest.getMemberphoto()!=null) {
			 * member.setMemberphoto(regFormRequest.getMemberphoto().getOriginalFilename());
			 * saveFile(request, regFormRequest.getMemberphoto()); }
			 */
			resultCnt =dao.insertMember(member);
			
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
	
		
		
		return resultCnt; //정상적으로 처리되면 결과1나온다.
	}
	
	
	/*
	 * // 사용자가 업로드한 파일을 저장하는 메서드 private void saveFile(HttpServletRequest request,
	 * MultipartFile file) throws IllegalStateException, IOException {
	 * 
	 * // 저장 경로 : 시스템 경로 String saveDir =
	 * request.getSession().getServletContext().getRealPath(UPLOAD_URI); // 새롭게 저장할
	 * 파일 File newFile = new File(saveDir ,file.getOriginalFilename() );
	 * 
	 * // 파일 저장 file.transferTo(newFile);
	 * 
	 * }
	 */
	
}
