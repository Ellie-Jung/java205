package ch07;

public class Main {

	public static void main(String[] args) {

		Female f = new Female("이영자","881017-2045789",170.6f);
		Male m= new Male("홍명보","024871-3451785",70.5f);

		f.sayHi();
		f.sleeping();
		m.sayHi();
		m.dancing();
	}

}
