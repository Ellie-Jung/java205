package ex;
//상속. 생성자 만들기 실습
public class Car {
	int gasolinegauge;
	Car(int gas){
		this.gasolinegauge = gas;
	}
}
class HybridCar extends Car {
	int electronicGauge;
	HybridCar(int gas) {
		super(gas);
	}
	HybridCar(int gas, int eg) {
		super(gas);
		electronicGauge =eg;
	}
}
class HybridWaterCar extends HybridCar {
	int waterGauge;
	HybridWaterCar(int gas) {
		super(gas);
	}
	HybridWaterCar(int gas,int eg) {
		super(gas, eg);
	}
	HybridWaterCar(int gas,int eg, int wg) {
		super(gas, eg);
		waterGauge =wg;
	}
	
	public void showCurrentGauge() {
		System.out.println("잔여 가솔린 : " + gasolinegauge);
		System.out.println("잔여 가솔린 : " + electronicGauge);
		System.out.println("잔여 가솔린 : " + waterGauge);
	}
}

