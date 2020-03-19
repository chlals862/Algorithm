package javaStudy.ch11_컬렉션프레임웍;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx2 {
	/*
	 * HashMap의 기본적인 메서드 예제
	 * entrySet()을 이용해서 키와 값을 함께 읽어 올 수 있음
	 * keySet() 이나 values()를 이용해서 키와 값을 따로 읽어 올 수 있음
	 * */
	public static void main(String[] args) {
		
		HashMap map = new HashMap();
		
		map.put("김자바",new Integer(90));
		map.put("김자바",new Integer(100));
		map.put("이자바",new Integer(100));
		map.put("강자바",new Integer(80));
		map.put("안자바",new Integer(90));
		//entrySet -> HashMap에 저장된 키와 값을 엔트리(키와 값의 결합)의 형태로 Set에 저장해서 반환
		Set set = map.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
		}//end of while
		
		//keySet -> HashMap에 저장된 모든 키가 저장된 Set을 반환
		set = map.keySet();
		System.out.println("참가자 명단 : " + set);
	
		Collection values = map.values();
		it = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()) {
			Integer i = (Integer)it.next();
			//intValue() -> Integer객체의 int형 값 빼오기
			//parseInt() -> String객체의 int형 값 뺴오기
			total += i.intValue();
		}//end of while
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
		
	}
}
