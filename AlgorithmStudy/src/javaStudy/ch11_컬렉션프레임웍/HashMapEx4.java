package javaStudy.ch11_컬렉션프레임웍;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapEx4 {
	/*
	 * 문자열 배열에 담긴 문자열을 하나씩 읽어서 HashMap에 키로 저장하고 값으로 1을저장
	 * HashMap에 같은 문자열이 키로 저장되어 있는지 containsKey()로 확인하여 이미 저장되어 있는 문자열이면 값을 1증가 
	 * 그리고 그 결과를 printBar()를 이용해서 그래프로 표현
	 * */
	public static void main(String[] args) {
		String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","D"};
		
		HashMap map = new HashMap();  //HashMap(String,Integer)
		
		for(int i=0;i<data.length;i++) {
			
			//map.containsKey() -> HashMap에 지정된 키가 포함되어 있는지 알려줌 (포함되면 true)
			if(map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], new Integer(value.intValue() + 1));
				
			} else {
				map.put(data[i], new Integer(1));
			}
		}//end of for
		
		//entrySet -> HashMap에 저장된 키와 값을 엔트리(키와 값의 결합)의 형태로 Set에 저장해서 반환
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}//end of while
	}
	
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for(int i=0;i< bar.length;i++) 
			bar[i] = ch;
		
		return new String(bar); //String(char[] chArr)
	}
	
	
}
