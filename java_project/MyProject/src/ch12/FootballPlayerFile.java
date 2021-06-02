package ch12;

import java.io.*;
import java.util.*;

import ch11.FootballPlayer;

public class FootballPlayerFile  {//직렬화를 하기 위해 해당 클래스에 Serializable 구현 !!!!! 
	//축구선수 정보 인스턴스를 List<E>에 저장하는 프로그램을 만들어봅시다.
	//이 인스턴스들을 파일로 저장하는 기능을 만들어봅시다.
	//저장된 파일을 객체로 만드는 기능을 만들어 봅시다.
	public static void main(String[] args) {
		
		
		try {
			//인스턴스를저장
			ObjectOutputStream  out = new ObjectOutputStream(new FileOutputStream("objectFb.txt"));
			
			//리스트에 저장
			ArrayList <FootballPlayer> list = new ArrayList<>();
			list.add(new FootballPlayer("손흥민", 5, "대한팀", 30));
			list.add(new FootballPlayer("메시", 7, "민국팀", 37));
			list.add(new FootballPlayer("이동국", 8, "대한팀", 35));
			list.add(new FootballPlayer("안정환", 10, "민국팀", 40));
			list.add(new FootballPlayer("박지성", 9, "대한팀", 30));
			list.add(new FootballPlayer("박지성", 9, "대한팀", 30));
			list.add(new FootballPlayer("이강인", 2, "민국팀", 20));
			out.writeObject(list);
			
			out.close();
			
			//인스턴스 복원
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("ObjectFb.txt"));
			//출력
			ArrayList <FootballPlayer> list2 = (ArrayList<FootballPlayer>) in.readObject();
			for(FootballPlayer f : list2) {
				System.out.println(f);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
