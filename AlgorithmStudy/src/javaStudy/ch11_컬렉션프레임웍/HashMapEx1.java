package javaStudy.ch11_컬렉션프레임웍;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx1 {
	/*
	 * HashMap -> Map을 구현했으므로 Map의 특징인 키와 값을 묶어서 하나의 데이터로 저장하는 특징을 가지고 있음
	 * 해싱(hashing)을 사용하기 때문에 많은 양의 데이터를 검색하는데 있어서 뛰어난 성능을 보임
	 * */
	public static void main(String[] args) {
		
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234"); //중복된 키가 있기 떄문에 하나만 적용됨, 비밀번호는 1234
		
		Scanner sc = new Scanner(System.in); //화면으로부터 라인단위로 받기
		
		while(true) {
			System.out.println("id와 password 입력");
			System.out.print("id = ");
			String id = sc.nextLine().trim();
			
			System.out.print("password = ");
			String password = sc.nextLine().trim();
			System.out.println();
			
			//map.containsKey() -> HashMap에 지정된 키가 포함되어 있는지 알려줌 (포함되면 true)
			if(!map.containsKey(id)) {
				System.out.println("입력한 id는 존재하지 않음 " + "다시 입력 바람.");
				continue;
				
			} else {
				
				if(!(map.get(id)).equals(password)) {
					System.out.println("비밀번호가 일치하지 않음 " + "다시 입력 바람");
				} else {
					System.out.println("id와 password가 일치!");
					break;
				}
			}
		}//end of while
	}
}
