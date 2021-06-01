package ch07;

public class Main {

	public static void main(String[] args) {

		Person f = new Female("이영자","881017-2045789",170.6f);
		Person m= new Male("홍명보","024871-3451785",70.5f);

		f.sayHi();
		((Female) f).sleeping();
		m.sayHi();
		((Male) m).dancing();
	}

}
