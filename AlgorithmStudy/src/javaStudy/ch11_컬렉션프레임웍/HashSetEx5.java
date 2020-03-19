package javaStudy.ch11_컬렉션프레임웍;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx5 {
	/*
	 * 두 개의 HashSet에 저장된 객체들을 비교해서 합,교,차집합을 구하는 방법을 보여주는 예제
	 * HashCode() -> 같은 객체 여부확인
	 * contains -> 지정된 객체가 있는지 확인
	 * */
	public static void main(String[] args) {
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHab = new HashSet();
		HashSet setGyo = new HashSet();
		HashSet setCha = new HashSet();
		
		//setA.add("1");setA.add("2");setA.add("3");setA.add("4");setA.add("5");
		for(int i=1; i<=5;i++) {
			setA.add(i);
		}
		
		System.out.println("A = " + setA);
		
		//setB.add("4");setB.add("5");setB.add("6");setB.add("7");setB.add("8");
		for(int i=4; i<=8;i++) {
			setB.add(i);
		}
		System.out.println("B = " + setB);
		
		Iterator it = setB.iterator();
		
		while(it.hasNext()) {
			Object tmp = it.next(); 
			if(setA.contains(tmp)) //setA에 tmp가 없으면
				setGyo.add(tmp);
		}///end of while
		
		it = setA.iterator(); //iterator은 재사용 안됨
		
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!setB.contains(tmp))
				setCha.add(tmp);
		}//end of while
	
		it = setA.iterator();
		while(it.hasNext())
			setHab.add(it.next());
		
		it = setB.iterator();
		while(it.hasNext()) 
			setHab.add(it.next());
		
		System.out.println("A ∩ B = " + setGyo);
		System.out.println("A ∪ B = " + setHab);
		System.out.println("A - B = " + setCha);
		
		/*
		 * 합집합(addAll) , 교집합(retainAll), 차집합(removeAll)도 가능
		 * */
	}
}
