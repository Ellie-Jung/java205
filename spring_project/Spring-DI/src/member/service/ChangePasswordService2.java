package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;
import member.domain.Member;

public class ChangePasswordService2 {

	@Autowired
	@Qualifier("member")
	private Dao dao;
	//Autowired 사용시 생성자. 세터 필요 없음
	
	public void changePassword(String email, String oldPw, String newPw) throws Exception {
		
		Member member = dao.selectByEmail(email);
		
		if(member == null) {
			throw new Exception("존재하지 않는 회원!");
		}
		
		member.changePassword(oldPw, newPw);
		
		dao.update(member);
		
		
	}
	
}
