package javaStudy.ch11_컬렉션프레임웍;

import java.util.Arrays;
import java.util.Comparator;


public class ComparatorEx {
	/*
	 * Comparable -> 기본 정렬기준을 구현하는데 사용
	 * Comparator -> 기본 정렬기준 외에 다른 기준으로 정렬하고할 떄 사용
	 * */
	public static void main(String[] args) {
		
		String[] strArr = {"cat","Dog","lion","tiger"};
		
		Arrays.sort(strArr);//String의 Comparable구현에 의한 정렬
		System.out.println("strArr = " + Arrays.toString(strArr));
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); //대소문자 구분안함
		System.out.println("strArr = " + Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending());
		System.out.println("strArr = " + Arrays.toString(strArr));
	}
}

	class Descending implements Comparator {
		public int compare(Object obj1, Object obj2) {
			if(obj1 instanceof Comparable && obj2 instanceof Comparable) {
				Comparable c1 = (Comparable)obj1;
				Comparable c2 = (Comparable)obj2;
				return c1.compareTo(c2) * -1; //1을 곱해서 기본 정렬방식의 역으로 변경함
											  //또는 c2.compareTo(c1)와 같이 순서를 바꿔도 됨
			}
			return -1;
		}
	}
