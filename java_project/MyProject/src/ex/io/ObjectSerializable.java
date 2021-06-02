package ex.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ObjectSerializable  {

	public static void main(String[] args) {
		
		try {
			//인스턴스를 저장
			ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("Object.ser"));
			
			out.writeObject(new Circle(1, 2, 3.4));
			out.writeObject(new Circle(3, 5, 7.0));
			out.writeObject("Hello");
			
			//저장
			ArrayList<Circle> list = new ArrayList<>();
			list.add(new Circle(1, 2, 3.4));
			list.add(new Circle(5, 6, 7.8));
			list.add(new Circle(9, 12, 13.4));
			list.add(new Circle(21, 22, 3.4));
			list.add(new Circle(31, 32, 23.4));
			list.add(new Circle(41, 42, 33.4));
			out.writeObject(list);
			
			out.close();
			
			System.out.println("인스턴스 저장 완료");
			
			//인스턴스 복원 //읽어올때 순서대로 해야함 (저장한 순서)//Circle클래스가 동일하게 있어야함 (ex.io.Circle)
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
			//복원 순서는 저장 순서에 맞게 복원
			Circle c1 = (Circle) in.readObject();
			Circle c2 = (Circle) in.readObject();
			String str = (String) in.readObject();
			
			System.out.println("복원된 인스턴스의 데이트를 출력");
			
			ArrayList<Circle> list2 = (ArrayList<Circle>) in.readObject();
			for(Circle circle : list2) {
				System.out.println(circle);
			}
			
			
			c1.showData();
			c2.showData();
			System.out.println(str);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
class Circle implements Serializable{ //직렬화대상임을 의미한다. (Serializable 구현해야함) 규칙. 
	
	int x;
	int y;
	double r;
	
	public Circle(int x, int y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public void showData() {
		System.out.println("원점 ["+x+","+y+"]");
		System.out.println("반지름 : "+r);
	}

	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", r=" + r + "]";
	}
	
	
}