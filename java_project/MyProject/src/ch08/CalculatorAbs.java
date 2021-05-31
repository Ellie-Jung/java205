package ch08;

abstract class CalculatorAbs implements Calculator {

	@Override
	public long add(long n1, long n2) {
		return n1+n2;
	}

}
