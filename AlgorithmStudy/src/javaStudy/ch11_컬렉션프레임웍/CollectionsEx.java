package javaStudy.ch11_컬렉션프레임웍;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import jdk.internal.vm.annotation.ReservedStackAccess;

import static java.util.Collections.*;

public class CollectionsEx {
	/*
	 * Collections -> 컬렉션과 관련된 메서드를 제공
	 * fill(),copy(),sort(),binarySearch() 등 
	 * */
	public static void main(String[] args) {
		
		List list = new ArrayList();
		System.out.println(list);

		addAll(list, 1,2,3,4,5);
		System.out.println(list); // 1 2 3 4 5
		
		rotate(list, 2); //rotate -> list의 값들을 오른쪽으로 2칸 이동
		System.out.println(list);// 4 5 1 2 3
		
		swap(list, 0, 2);//swap -> 첫번쨰와 세번째를 교환(swap)
		System.out.println(list);// 1 5 4 2 3 
		
		shuffle(list); //shuffle -> list의 값들을 임의로 변경 
		System.out.println(list); // 실행마다 다름
		
		sort(list); //sort -> 정렬(오름차순)
		System.out.println(list); // 1 2 3 4 5
		
		sort(list, reverseOrder()); // reverseOrder -> 역순 정렬 reverse(list);와 동일
		System.out.println(list); // 5 4 3 2 1 
		
		int index = binarySearch(list, 3); // 3이 저장된 위치(index)를 반환
		System.out.println("index of 3 = " + index); // 2
		
		System.out.println("max =" + max(list));//최대값
		System.out.println("min = " + min(list)); //최소값
		System.out.println("min = " + max(list,reverseOrder()));
		
		fill(list,9); //fill -> list를 9로 채움
		System.out.println("list = " + list);
		
		//list와 같은 크기의 list를 생성하고 2로 채움, 단결 과는 변경불가
		List newList = nCopies(list.size(), 2);
		System.out.println("newList = " + newList);
		
		System.out.println(disjoint(list, newList));//list와 newList가 공통요속 없으면 true
	
		copy(list, newList);//list를 newList와 같은 값으로 복사
		System.out.println("newList = " + newList);
		System.out.println("list = " + list);
		System.out.println();
		replaceAll(list, 2, 1);//list의 '2'값을 '1'로 전부(All)변경
		System.out.println("list = " + list);
		
		Enumeration e = enumeration(list); //iterator 하위호환 -> 사용 거의 안함
		ArrayList list2 = list(e);
		
		System.out.println("list2 =" + list2);
	
	}
}
