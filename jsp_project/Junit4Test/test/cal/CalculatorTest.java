package cal;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	//Calculator cal = new Calculator();
	Calculator cal ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//클래스에 공통적으로 사용될때 여기서 처리
		System.out.println("@BeforeClass");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
		cal = new Calculator(); // 테스트 시작할떄마다 이게 실행된다. 보통 여기서 초기화해서 사용함 
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void testAdd() {
		System.out.println("testAdd()");
		
		
		
		assertEquals("add() 메서드 테스트", 12,cal.add(10, 2)); //jUnit으로 확인시 성공/실패 확인가능
		
		//System.out.println(cal.add(10, 2));
		//fail("Not yet implemented"); //이건 그냥 다실패로 찍는다.
	}

	@Test
	public void testSubstract() {
		System.out.println("testSubstract()");
		
		assertEquals("substract() 메서드 테스트", 8,cal.substract(10, 2));
		
		//fail("Not yet implemented");
	}

	@Test
	public void testMultiply() {
		System.out.println("testMultiply()");
		
		assertEquals("multiply() 메서드 테스트", 20,cal.multiply(10, 2));
		
		//fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		System.out.println("testDivide()");
		
		assertEquals("divide() 메서드 테스트", 5,cal.divide(10, 2));
		//fail("Not yet implemented");
	}
	
	//예외 타입을 비교해서 테스트
	@Test(expected = ArithmeticException.class)
	public void test1(){
		
		System.out.println("@Test 실행 중 예외타입을 테스트");
		//throw new ArithmeticException();
		int a =10/0;
		//throw new ArithmeticException();
		//기대했던 예외가 발생하지않으면 에러가됨.
	}
	
	@Test(timeout = 100)  // 100/1000초 (0.1초) -> 이 시간안에 실행되는지 테스트
	public void test2(){
		System.out.println("@Test 테스트중 허용시간 ms 안에 실행이 완료 되는지 테스트 ");
		cal.add(100, 200);
		cal.substract(100, 200);
	}
	
	@Test
	public void test3() {
		//fail("테스트 미실행");
		//assertTrue("메서드의 반환값이 boolean인 경우 사용", true);//false하면 에러
		//assertNull(null);
		//assertNull("메서드의 실행값이 null이 예상되는 경우", new Object()); //에러
		//assertNotNull("메서드의 실행값이 not null이 예상되는 경우", new Object());
		//assertNotNull("메서드의 실행값이 not null이 예상되는 경우", null); //에러
		//assertSame("같은 값일 경우 ", 1, 1); //같은값일경우 true
		//assertNotSame("다른 값일 경우 ", 1, 2); //다른값일경우 true
		assertTrue("메서드의 반환값이 true 예상할때",true);
	}
	
	

}
