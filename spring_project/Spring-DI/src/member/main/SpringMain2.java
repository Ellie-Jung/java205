package member.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import member.dao.Dao;
import member.dao.MemberDao;
import member.domain.RegRequest;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class SpringMain2 {
	
	static ApplicationContext ctx;
	
	public static void main(String[] args) {
		
		
		ctx= new GenericXmlApplicationContext("classpath:appCtx4.xml");
		
		// MemberRegService  객체를 컨테이너로부터 받아온다. 
		System.out.println("==================================");
		Dao dao1 = ctx.getBean("memberDao",Dao.class);
		Dao dao2 = ctx.getBean("memberDao",Dao.class);
		System.out.println("-----------------------------------");
		System.out.println("dao1==dao2 : "+ (dao1==dao2));
		//위에꺼는 실행시 미리 객체 만들어둔다.
		
		System.out.println("==================================");
		// 프로토타입은 미리 만들지않고, 요청할때 객체를 생성한다. 
		MemberRegService regService1= ctx.getBean("regService",MemberRegService.class);
		MemberRegService regService2= ctx.getBean("regService",MemberRegService.class);
		System.out.println("----------------------------------");
		System.out.println("regService1==regService2 : "+ (regService1==regService2));
		
		System.out.println("==================================");
		ChangePasswordService passwordService1 =  ctx.getBean("chagePwService", ChangePasswordService.class);
		ChangePasswordService passwordService2 =  ctx.getBean("chagePwService", ChangePasswordService.class);
		System.out.println("----------------------------------");
		System.out.println("passwordService1==passwordService2 : "+ (passwordService1==passwordService2));
		//싱글톤은 인스턴스 하나로 쓴다. 
		
	}
	
}
