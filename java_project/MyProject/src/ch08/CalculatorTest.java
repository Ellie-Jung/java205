package ch08;

public class CalculatorTest {

	public static void main(String[] args) {

		Calculator calcI = new CalculatorImpl();
		
		System.out.println(calcI.add(3, 5));
		System.out.println(calcI.substract(7, 2));
		System.out.println(calcI.divide(10, 3));
		System.out.println(calcI.multiply(6, 7));
	}

}
