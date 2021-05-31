package ch08;

public class CalculatorTest {

	public static void main(String[] args) {

		Calculator calcI = new CalculatorImpl();
		CalculatorImpl calcImpl = new CalculatorImpl();
		CalculatorAbs calculatorAbs = new CalculatorImpl();
		
		
		
		System.out.println(calcI.add(3, 5));
		System.out.println(calcI.substract(7, 2));
		System.out.println(calcImpl.divide(10, 3));
		System.out.println(calculatorAbs.multiply(6, 7));
	}

}
