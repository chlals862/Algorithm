package javaStudy.ch11_컬렉션프레임웍;

import java.util.TreeSet;

public class TreeSetEx2 {
	/*
	 * TreeSet -> 범위 검색과 정렬에 유리 & HashSet보다 데이터 추가,삭제에 시간이 더 걸림
	 * headSet() -> 지정된 객체보다 작은값의 객체 반환
	 * tailSet() -> 지정된 객체보다 큰값의 객체 반환
	 * */
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		int[] scores = {80,95,50,35,45,65,10,100};
		
		for(int i=0; i< scores.length; i++) 
			set.add(new Integer(scores[i]));

			System.out.println("50보다 작은 값 = " + set.headSet(new Integer(50)));
			System.out.println("50보다 큰 값 = " + set.tailSet(new Integer(50)));
	}
}
