package member.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService2 {

	//@Autowired
	//@Qualifier("member1")
	@Resource(name="guestDao")
	private Dao dao ; 
	//Autowired 사용시 생성자. 세터 필요 없음
	//Qualifier로 별칭 찾는다
	
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
