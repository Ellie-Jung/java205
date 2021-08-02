package member.service;

import java.util.Date;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService {

	//Dao dao = new MemberDao(); 이렇게 하면 의존성 높아짐 
	Dao dao ; //이거 인터페이스다. Dao가 아직 구현안되어도 오류 안생김 (문제없이 컴파일됨). 인스턴스 생성시 오류발생
	
	public MemberRegService(Dao dao) {
		this.dao = dao;
		System.out.println("MemberRegService 인스턴스 생성");
	}
	
	
	public void regMember(RegRequest request) throws Exception {
		
		// 중복 이메일을 체크 
		Member member = dao.selectByEmail(request.getEmail());
		
		if(member !=null) {
			throw new Exception("중복 이메일!!");
		}
		
		Member newMember = new Member(0, request.getEmail(), request.getPassword(), request.getName(), new Date());
		
		dao.insert(newMember);
	}
	
	
	
}
