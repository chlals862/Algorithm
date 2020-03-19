package javaStudy.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapPractice {

	public static void main(String[] args) {
		HashMap<String, Integer>fruitMap = new HashMap();
		fruitMap.put("사과", 1000);
		fruitMap.put("배", 2000);
		fruitMap.put("자두", 3000);
		fruitMap.put("수박", 4000	);
	
		//get() -> Key에 해당하는 Value를 출력한다.
		System.out.println(fruitMap.get("자두")); //value => 3000
	
		//HashMap에 넣은 Key와 Value를 Set에 넣고 iterator에 값으로 Set정보를 담에 준다.
		//iterator it = fruitMap.entrySet().iterator();과 같다
		Set<Entry<String,Integer>>set = fruitMap.entrySet();
		Iterator<Entry<String,Integer>>it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)it.next();
			System.out.println("이름  : " + e.getKey() + ", 가격 : " + e.getValue() + "원");
		}//end of while
	}
}
