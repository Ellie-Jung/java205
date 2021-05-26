package ch06;
import java.util.Arrays;
public class Student {
	// 배열 -> 변수의 집합. 변수를 묶음으로 사용. 같은 "타입"의 변수들을 묶는다.
	//class 도 타입이다 !! ->참조형 타입
	//배열은 묶음이다. 배열도 인스턴스다 !
	private String name; //학생이름, 국어점수, 영어점수, 수학점수 저장하는 변수를 정의
	private int kor;
	private int eng;
	private int math;
	 
	Student() {}
	Student(String name, int kor, int eng,int math){
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	public String getName() { //변수를 캡슐화 해서 getter/setter 정의. 이름을 읽어올때
		return name;
	}
	public void setName(String name) { //이름을 세팅할때. 
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}

	int getSum() { //총점을 반환하는 메소드
		return this.kor+this.eng+this.math;
	}
	float getAvg() { //평균을 반환하는 메소드
		return getSum()/3f; //인티저를 나누니까 인티져가 나옴. f필요
	}
}
