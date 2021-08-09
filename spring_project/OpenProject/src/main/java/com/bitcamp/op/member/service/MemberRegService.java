package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
			
			
			/*
			 * // 1. multipart 여부 확인 boolean isMultipart =
			 * ServletFileUpload.isMultipartContent(request);
			 * 
			 * if(isMultipart){
			 * 
			 * // 2. 파일을 저장할 Factory 객체 생성 DiskFileItemFactory factory = new
			 * DiskFileItemFactory();
			 * 
			 * // 3. 요청 처리를(form 안에 있는 input들을 분리) 위해서 ServletFileUpload 생성
			 * ServletFileUpload upload = new ServletFileUpload(factory);
			 * 
			 * // 4. 사용자 요청을 파싱(분리 : 원하는 형태로 분리 -> input = FileItem) // FileItem -> input
			 * 데이터를 저장하고 있는 객체 List<FileItem> items= upload.parseRequest(request);// 예외 던짐
			 * 
			 * Iterator<FileItem> itr= items.iterator(); //파일 아이템으로 다 짤라서 가져온다.
			 * 
			 * while(itr.hasNext()){
			 * 
			 * FileItem item = itr.next(); // text, checkbox, hidden, password, file =>
			 * formfield(text, checkbox, hidden, passwords)는 문자열 가져옴. file은 파일이름 사이즈쓰기
			 * 
			 * // file과 file이외의 폼을 구분 if(item.isFormField()){ //파일데이터 처리 //회원의 아이디, 회원이름,
			 * 비밀번호 구해서 저장 String paramName=item.getFieldName();
			 * 
			 * if(paramName.equals("memberid")) { //String value= item.getString("utf-8");
			 * member.setMemberid(item.getString("utf-8"));
			 * 
			 * }else if(paramName.equals("password")) {
			 * 
			 * member.setPassword(item.getString("utf-8"));
			 * 
			 * }else if(paramName.equals("membername")) {
			 * member.setMembername(item.getString("utf-8")); } }else{ //사진 데이터 처리 String
			 * uploadUri = "upload"; String dir=
			 * request.getSession().getServletContext().getRealPath(uploadUri);
			 * 
			 * File saveDir = new File(dir);
			 * 
			 * if(!saveDir.exists()) { saveDir.mkdir(); }
			 * 
			 * String paramName = item.getFieldName(); if(paramName.equals("photo")) {
			 * 
			 * // 파일이름, 사이즈 여기서 구할수있음 if(item.getName()!=null && item.getSize()>0) { //저장
			 * newFile=new File(saveDir,item.getName()); item.write(newFile); // DB에 저장할 파일의
			 * 이름 member.setMemberphoto(item.getName()); System.out.println("파일 저장!!!"); }
			 * 
			 * }
			 * 
			 * }
			 * 
			 * }
			 * 
			 * 
			 * 
			 * 
			 * }else { throw new Exception("multipart  타입이 아닙니다!! ");
			 * 
			 * }
			 */
			
		////////////////////////////////////////////////////////////////
		// DB insert
		//Connection, MemberDao
	
			conn = ConnectionProvider.getConnection();
			
			System.out.println(regFormRequest);
			
			member.setMemberid(regFormRequest.getMemberid());
			member.setPassword(regFormRequest.getPassword());
			member.setMembername(regFormRequest.getMemberName());

			if(regFormRequest.getMemberPhoto()!=null) {
				member.setMemberphoto(regFormRequest.getMemberPhoto().getOriginalFilename());
				saveFile(request, regFormRequest.getMemberPhoto());
			}
			
			resultCnt =dao.insertMember(conn, member);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			if (newFile !=null && newFile.exists()) {
				//파일을삭제
				newFile.delete();
				System.out.println("파일삭제");
			}
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
