package javaStudy.ch11_컬렉션프레임웍;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetLotto {
	/*
	 * 중복된 값은 저장되지 않는 HashSet의 성질을 이용해서 로또번호를 만드는 예제
	 * 
	 * 번호를 크기순으로 정렬하기 위해서 Collections클래스의 sort(List list)를 사용
	 * 이 메서드는 인자로 List인터페이스 타입을 필요로 하기 떄문에 LinkedList클래스의 생성자 LinkedList(Collection c)를 이용해서
	 * HashSet에 저장된 객체들을 LinkedList에 담아서 처리함
	 * 
	 * 실행결과의 정렬기준은, 컬렉션에 저장된 객체가 Integer이기 때문에 Integer클래스에 정의된 기본정렬이 사용됨
	 * */
	public static void main(String[] args) {
		Set set = new HashSet();
		
		for(int i=0;set.size()<6;i++) {
			int num = (int)(Math.random() * 45) +1;
			set.add(new Integer(num));
		}//end of for
		
		List list = new LinkedList(set); //LinkedList(Collection c)
		Collections.sort(list);//Collections.sort(List list)
		System.out.println(list);
		
	}
}
