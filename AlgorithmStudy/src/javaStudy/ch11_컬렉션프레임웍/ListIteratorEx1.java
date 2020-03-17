package javaStudy.ch11_컬렉션프레임웍;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorEx1 {
	/*
	 * iterator -> 컬렉션에 저장된 각 요소에 접근하는 기능을 가진 Iterator인터페이스를 정의하고, 
	 * 컬렉션 인터페이스에서는 이터레이터를 반환하는 이터레이터()를 정의함
	 * */
	public static void main(String[] args) {
		/*
		 * ListIterator의 사용방법을 보여주는 예제
		 * Iterator은 단방향으로만 이동하기 떄문에, 컬렉션의 마지막 요소에 다다르면 더 이상 사용할 수 없음
		 * ListIterator는 양방향으로 이동하기 떄문에 각 요소간의 이동이 자유로움
		 * 다만 이동하기 전에 반드시 hasNext()나 hasPrevious()를 호출해서 이동할 수 있는지 확인해야 함
		 * */
		ArrayList list = new ArrayList();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		ListIterator it = list.listIterator();
		
		while(it.hasNext()) {
			System.out.print(it.next());//순방향
		}
		System.out.println();
		
		while(it.hasPrevious()) { //역방향
			System.out.print(it.previous());
		}
		System.out.println();
	}
}
