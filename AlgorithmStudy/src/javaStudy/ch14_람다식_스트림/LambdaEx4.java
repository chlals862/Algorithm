package javaStudy.ch14_람다식_스트림;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
	 * Map인터페이스에 있는 'compute'로 시작하는 메서드는 Map의 value를 반환하는 일을 함
	 * merge()는 Map을 병합하는 일을 함
	 * */
public class LambdaEx4 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) 
			list.add(i);
			
			//list의 모든 요소 출력
			list.forEach(i->System.out.print(i+""));
			System.out.println();
			//list에서 2 || 3의 배수를 제거
			list.removeIf(x-> x%2==0 || x%3==0);
			System.out.println(list);
			
			Map<String, String> map = new HashMap<>();
			map.put("1", "1");
			map.put("2", "2");
			map.put("3", "3");
			map.put("4", "4");
			
			//map의 모든 요소를 {k,v}의 형식으로 출력
			map.forEach((k,v) -> System.out.print("{" + k + "," + v + "}"));
		System.out.println();
	}
}
