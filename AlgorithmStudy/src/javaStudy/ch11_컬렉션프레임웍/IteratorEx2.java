package javaStudy.ch11_컬렉션프레임웍;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx2 {
	/*
	 * Iterator -> 컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스
	 * */
	public static void main(String[] args) {
		ArrayList original = new ArrayList(10);
		ArrayList copy1 = new ArrayList(10);
		ArrayList copy2 = new ArrayList(10);
	
		for(int i=0;i<10;i++) 
			original.add(i+"");
		Iterator it = original.iterator();
	
		while(it.hasNext()) //남아 있는지 여부 확인
			copy1.add(it.next()); //남아 있다면 다음요소를 읽어옴
		
		System.out.println("= Original에서 copy1로 복사 (copy) =");
		System.out.println("original: "+original);
		System.out.println("copy1 : " + copy1);
		System.out.println();
		
		it = original.iterator(); //Iterator는 재사용이 안되므로, 다시 얻어와야 함
		
		while(it.hasNext()) {
			copy2.add(it.next());
			it.remove();
		}
		
		System.out.println("= Original에서 copy2로 이동 (move) =");
		System.out.println("Original :" + original);
		System.out.println("copy2 : " + copy2);
		
		
	}
}
