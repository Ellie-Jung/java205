package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.exception.InvalidPasswordException;
import guest.exception.MessageNotFoundException;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class DeleteMessageService {

	//싱글톤 처리
	private DeleteMessageService(){}
	private static DeleteMessageService service= new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return service;
	}
	
	public int deleteMessage(int mid, String pw) throws SQLException, MessageNotFoundException, InvalidPasswordException{
		
		int resultCnt = 0;
		
		Connection conn = null;
		MessageDao dao = null;
		
		try {
			
			conn = ConnectionProvider.getConnection(); 
			dao=MessageDao.getInstance();
			
			//트랜잭션 시작
			conn.setAutoCommit(false);
			
			//전달 받은 mid로 게시물을 검색
			Message message = dao.selectByMid(conn, mid);
			
			if(message==null) {
				throw new MessageNotFoundException(mid);
			}else {
				
				if(message.getPassword().equals(pw)) {
					//삭제
					resultCnt = dao.deleteMessage(conn,mid);
					//트랜잭션 성공.
					conn.commit(); //트랜잭션 완료
				}else {
					//비밀번호가 일치하지 않음으로 예외 발생!
					throw new InvalidPasswordException();
					
				}
			}
			
			//예외 여기서 처리한다. 다던저벼리면 트랜잭션 롤백에 문제..그래서 여기서 처리한다.
		}catch(SQLException e ){
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		} catch (MessageNotFoundException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
			
		}
		
		
		return resultCnt;
	}
	
	
}
