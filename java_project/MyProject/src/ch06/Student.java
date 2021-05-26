package ch06;

import java.util.Arrays;

public class Student {
	// 배열 -> 변수의 집합. 변수를 묶음으로 사용. 같은 "타입"의 변수들을 묶는다.
	//class 도 타입이다 !! ->참조형 타입
	//배열은 묶음이다. 배열도 인스턴스다 !
	private String name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
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

	int sum() {
		return kor+eng+math;
	}
	double avg() {
		return sum()/3;
	}

	void printInfo() {
		System.out.println(getName() +" "+ getKor() +" "+ getEng() +" "+ getMath() +" "+ sum() +" "+ avg());

	}

	public static void main(String[] args) {
	
		int sumKor=0;
		int sumEng=0;
		int sumMath=0;
		Student [] stu = new Student[10];

		stu[0]= new Student("김사랑",80,90,54);
		stu[1]= new Student("송은이",77,98,81);
		stu[2]= new Student("유재석",44,72,91);
		stu[3]= new Student("박명수",24,56,71);
		stu[4]= new Student("강호동",99,53,12);
		stu[5]= new Student("김민희",74,94,55);
		stu[6]= new Student("이승기",80,32,57);
		stu[7]= new Student("유희열",81,60,88);
		stu[8]= new Student("성동일",84,72,91);
		stu[9]= new Student("신동엽",49,20,54);

		System.out.println("이름 국어 영어 수학 총점 평균");
		for(int i = 0;i <stu.length; i++) {
			stu[i].printInfo();
		}
		for (int i=0; i<stu.length;i++) {
			sumKor+= stu[i].getKor();
			sumEng+= stu[i].getEng();
			sumMath+=stu[i].getMath();
		}
		System.out.println("국어총점 " +sumKor+"국어평균 "+ sumKor/stu.length);
		System.out.println("영어총점 " +sumEng+"영어평균 "+ sumEng/stu.length);
		System.out.println("수학총점 " +sumMath+"수학평균 "+ sumMath/stu.length);
	}

}
