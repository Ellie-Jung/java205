package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDao {
	
	
	// 싱글톤
	private MemberDao() {
	}
	static private MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}
	
	public ArrayList<Member> getMemberList(Connection con){
		
		ArrayList<Member> list = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}                                        
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(stmt != null) {

			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int inserMemberDTO(Connection con, Member mem) {
	    
		int result = 0;
		
		PreparedStatement pstmt = null;
		
	    try {
	    	String sql = "INSERT INTO MEMBER VALUES (member_idx_seq.nextval, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPassword());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getPhonenum());
			pstmt.setString(5, mem.getEmail());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// 내일 팀원들이랑 같이 수정
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			
			String sql = "update member set pw=?, name=?, phonenum=?, email=? where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPhonenum());
			pstmt.setString(4, member.getEmail());
			pstmt.setInt(5, member.getIdx());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// 회원삭제 가능한지 팀원상의후 결정
	public int deleteMember(Connection conn, int order) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from member where oidx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
}



//public class MemberDao {
//
//	// 1. 외부 클래스 또는 인스턴스에서 해당 클래스로 인스턴스를 생성하지 못하도록 처리.
//	private MemberDao(){   //생성자에 프라이빗 붙인다. 외부에서 생성자 호출 불가능.외부에서 인스턴스 호출이 불가능해진다.
//	}
//	// 2. 클래스 내부에서 인스턴스를 만들고 
//	static private MemberDao dao= new MemberDao() ;  //스테틱붙여줌. 생성자호출이 가능하다. 수정하지못하도록 private 사용// 스테틱은 프로그램 시작할때 메모리에 올라가기때문에 바로 인스턴스생성됨.
//
//
//	// 3. 메소드를 통해서 반환하도록 처리 
//	public static MemberDao getInstance() { // 요것도 스테틱. // 클래스 내부에서 만든 인스턴스를 반환함. //외부에서 DeptDao 인스턴스를 쓰고 싶으면 이 메소드를 통해서만 사용가능하다. 새로 만들진 못한다. 하나만 생성
//		return dao;
//	}
//
//public ArrayList<Member> getMemberList(Connection con){
//		
//		ArrayList<Member> list = null;
//		
//		Statement stmt = null;
//		ResultSet rs = null;
//		String sql = "select * from member";
//		
//		try {
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//			
//			list = new ArrayList<>();
//			
//			while(rs.next()) {
//				list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
//			}                                         
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		if(stmt != null) {
//
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return list;
//	}
//	
//	
//	
//	//회원가입
//public int insertMember(Connection con, Member member) {
//	    
//		int result = 0;
//		
//		PreparedStatement pstmt = null;
//		
//	    try {
//	    	String sql = "INSERT INTO MEMBER VALUES (member_idx_seq.nextval, ?, ?, ?, ?, ?)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, member.getId());
//			pstmt.setString(2, member.getPassword());
//			pstmt.setString(3, member.getName());
//			pstmt.setString(4, member.getPhonenum());
//			pstmt.setString(5, member.getEmail());
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
//
//	// 내일 팀원들이랑 같이 수정
//		public int updateMember(Connection conn, Member member) {
//			int result = 0;
//			PreparedStatement pstmt = null;
//
//			try {
//				
//				String sql = "update member set pw=?, name=?, phonenum=?, email=? where idx=?";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, member.getPassword());
//				pstmt.setString(2, member.getName());
//				pstmt.setString(3, member.getPhonenum());
//				pstmt.setString(4, member.getEmail());
//				pstmt.setInt(5, member.getIdx());
//
//				result = pstmt.executeUpdate();
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//
//				if(pstmt != null) {
//					try {
//						pstmt.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			return result;
//		}
//	
//	
//	
//	
//	
//
//}
//
