package javaStudy.ch11_컬렉션프레임웍;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetLotto {
	/*
	 * 이진검색트리(TreeSet)
	 * 모든 노드는 최대 두 개의 자식노드를 가질 수 있음
	 * 왼쪽 자식노드의 값은 부모노드의 값보다 작고 오른쪽 자식노드의 값은 부모노드의 값보다 커야함
	 * 노드의 추가 삭제에 시간이 걸림 (순차적으로 저장하지 않음)
	 * 검색(범위검색)과 정렬에 유리함
	 * 중복된 값을 저장하지 못함
	 * 638p 참고
	 * */
	public static void main(String[] args) {
		Set set = new TreeSet();
		
		for(int i = 0; set.size() < 6; i++) {
			int num = (int)(Math.random()*45) + 1;
			
			set.add(num); //set.add(new Integer(num));
		}//end of for
		System.out.println(set);
		//TreeSet은 저장할 떄 이미 정렬하기 떄문에 읽어올 때 따로 정렬할 필요가 없음★★★★★
	}
}
