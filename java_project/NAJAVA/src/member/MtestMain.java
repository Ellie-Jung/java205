package member;

public class MtestMain {

	public static void main(String[] args) {

		MemberManager m = new MemberManager(MemberDao.getInstance());
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			m.MemberJoin();
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
