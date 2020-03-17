package javaStudy.ch11_컬렉션프레임웍;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx1 {
	/*
	 * HashSet -> Set인터페이스를 구현한 가장 대표적인 컬렉션
	 * Set인터페이스의 특징대로 중복된 요소를 저장하지 않음
	 * 새로운 요소를 추가할 때는 add메서드나 addAll메서드를 사용함
	 * */
	public static void main(String[] args) {
		Object[] objArr = {"1",new Integer(1),"2","2","3","3","4","4","4"};
		Set set = new HashSet();
		
		for(int i=0; i<objArr.length;i++) {
			set.add(objArr[i]); //HashSet에 objArr의 요소들을 저장한다.
		}//end of for
		//HashSet에 저장된 요소들을 출력한다.
		System.out.println(set); //결과값 : [1,1,2,3,4]
		//'1'이 두 번 출력되었는데 둘 다 '1'로 보이기 떄문에 구별이 되지 않지만
		//하나는 String인스턴스이고 다른 하나는 Integer인스턴스로 서로 다른객체이므로 중복으로 간주하지 않음
	}
}
