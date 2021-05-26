package ch06;
public class StudentMain {
	public static void main(String[] args) {
		//Student  타입의 배열을 선언하고, 요소 10개를 저장할수 있는 배열 인스턴스를 생성
		//참조변수 배열 -> 참조변수(객체)들을 묶어서 배열로 만든것. 
		
		Student [] stu = new Student[10]; //변수 10개를 저장할수 있는 Student배열 만들기.
		
		stu[0]= new Student("김사랑",80,90,54); //Student타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의.
		stu[1]= new Student("송은이",77,98,81); //Student s2 = new Student(); 와 같은것임. 
		stu[2]= new Student("유재석",44,72,91);
		stu[3]= new Student("박명수",24,56,71);
		stu[4]= new Student("강호동",99,53,12);
		stu[5]= new Student("김민희",74,94,55);
		stu[6]= new Student("이승기",80,32,57);
		stu[7]= new Student("유희열",81,60,88);
		stu[8]= new Student("성동일",84,72,91);
		stu[9]= new Student("신동엽",49,20,54);
		
		//배열에 저장된 Student 타입의 인스턴스 메소드를 이용해서 모든 데이터를 출력해보자.
//		System.out.println(stu[0]; 하면 students[0] 참조변수의 주소가나옴. stu[i].변수(메서드) 사용
		
		int sumKor=0;
		int sumEng=0;
		int sumMath=0;
		
		System.out.println("이름 \t국어 \t영어 \t수학\t총점\t 평균"); //"\t" 는 탭만큼 띄울때
		for( int i = 0; i< stu.length;i++) {
			System.out.print(stu[i].getName()+ "\t"); 
			System.out.print(stu[i].getKor()+ "\t"); 
			System.out.print(stu[i].getEng()+ "\t"); 
			System.out.print(stu[i].getMath()+ "\t"); 
			System.out.print(stu[i].getSum()+ "\t"); 
			System.out.println(stu[i].getAvg()+ "\t"); 
			sumKor+= stu[i].getKor();
			sumEng+= stu[i].getEng();
			sumMath+=stu[i].getMath();
		}
		
		System.out.println("국어총점 : " +sumKor+" 국어평균 : "+ (float)sumKor/stu.length);
		System.out.println("영어총점 : " +sumEng+" 영어평균 : "+ (float)sumEng/stu.length);
		System.out.println("수학총점 : " +sumMath+" 수학평균 : "+ (float)sumMath/stu.length);
	

	}

}
