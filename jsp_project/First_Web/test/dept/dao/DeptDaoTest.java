package dept.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dept.domain.Dept;
import jdbc.util.ConnectionProvider;

public class DeptDaoTest {

	DeptDao dao;
	Connection conn;
	Dept dept;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao=DeptDao.getInstance();
		conn = ConnectionProvider.getConnection();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDeptList() throws SQLException {
		//fail("Not yet implemented");
		assertEquals("GetdeptList() 메서드 테스트",3,dao.getDeptList(conn).get(1).getDeptno());
		assertNotNull("메서드의 실행값이 not null이 예상되는 경우",dao.getDeptList(conn).isEmpty());
		assertSame("같은 값일 경우 ",1 ,dao.getDeptList(conn).get(0).getDeptno());
		assertTrue("메서드의 반환값이 true 예상할때", dao.getDeptList(conn).size()>0);
	}
	
	
	@Test (expected = SQLIntegrityConstraintViolationException.class)
	public void testInsertDept() throws SQLException {
		//fail("Not yet implemented");
		assertEquals("insertDept() 메서드 테스트", 1,dao.insertDept(conn, new Dept(3,"design","seoul")));
		assertEquals("insertDept() 메서드 테스트", 1,dao.insertDept(conn, new Dept(2,"sales","jeju")));
		dao.insertDept(conn, new Dept(10,"design","seoul"));
		
	}

	
	
	@Test
	public void testDeleteDept() {
		//fail("Not yet implemented");
		
		assertEquals("deleteDept() 메서드 테스트", 1,dao.deleteDept(conn, 1));
		assertEquals("deleteDept() 메서드 테스트", 0,dao.deleteDept(conn, 2));
		assertEquals("deleteDept() 메서드 테스트", 0,dao.deleteDept(conn, 11));
	}

	@Test
	public void testSelectByDeptno()  {
		//fail("Not yet implemented");
		assertEquals("selectByDeptno() 메서드 테스트", "ACCOUNTING",dao.selectByDeptno(conn, 10).getDname());
		assertNotNull("메서드의 실행값이 not null이 예상되는 경우",dao.selectByDeptno(conn, 20).getDeptno());
		assertSame("같은 값일 경우 ",20,dao.selectByDeptno(conn, 20).getDeptno());
		assertTrue("메서드의 반환값이 true 예상할때", dao.selectByDeptno(conn, 30).getDname().equals("SALES"));
		assertNotNull("메서드의 실행값이 not null이 예상되는 경우", dao.selectByDeptno(conn, 1));
	}

	@Test 
	public void testUpdateDept()  {
		//fail("Not yet implemented");
		assertEquals("updateDept() 메서드 테스트", 1,dao.updateDept(conn, new Dept(1,"account","ulsan")));
		assertEquals("updateDept() 메서드 테스트", 1,dao.updateDept(conn, new Dept(1,"design","ulsan")));
		assertEquals("updateDept() 메서드 테스트", 0,dao.updateDept(conn, new Dept(0,"design","ulsan")));
		
	}

	
	
}
