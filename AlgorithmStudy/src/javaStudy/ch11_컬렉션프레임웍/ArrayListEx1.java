package javaStudy.ch11_컬렉션프레임웍;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {
	/* List -> 데이터의 저장순서가 유지되고, 중복을 허용
	 * ArrayList -> 기존의 Vector를 개선한 것, Object배열을 이용해서 데이터를 순차적으로 저장
	 * */
	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		System.out.println(list1);//결과값: 5,4,2,0,1,3 [index 0부터5까지]
		//subList -> List SubList(int fromIndex, int toIndex) -> fromIndex부터 toIndex사이에 저장된 객체를 반환
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		
		System.out.println(list2); //결과값 : 4,2,0 
		
		//오름차순
		Collections.sort(list1); //list1과 list2를 정렬
		Collections.sort(list2); //Collections.sort(List 1)
		
		System.out.println(list1 + " " + list2); //list1 결과값 : 0,1,2,3,4,5  list2 결과값: 0,2,4 
		
		list2.add("B");
		list2.add("C");
		list2.add(3,"A"); //인덱스 3의 위치에 'A'삽입
		System.out.println(list1 + " " + list2);//list2 결과값 : 0,2,4,A,B,C
		
		list2.set(3, "AA"); //list2 3번쨰 위치에 "AA"를 삽입
		System.out.println(list2); //list2 결과값 : 0,2,4,AA,B,C
			
		//list1에서 list2와 겹치는 부분만 남기고 나머지 삭제 -> list1과 list2는 0,2,4만 겹침
		//list1이 list2의 모든 요소를 포함하고 있을 때만 true
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));//true
		System.out.println(list1 + " " + list2);//list1 결과값 : 0,2,4  list2 결과값: 0,2,4,AA,B,C 
	
		//list2에서 list1에 포함된 객체들을 삭제
		for(int i=list2.size()-1; i>= 0; i--) {
			if(list1.contains(list2.get(i))) //세미콜론 없어야함
				list2.remove(i);
		}//end of for
		System.out.println(list1 + " " + list2); //list1 결과값 : 0,2,4   list2 결과값 : []
		
		
	}
}
