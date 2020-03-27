package javaStudy.practice;

import java.util.function.Function;

public class andThen_composeTest {
	/*
	 * Ex)함수 f,g가 있을 때 
	 * f.andThen(g) -> 함수 f를 먼저 적용하고, 그 다음에 함수 g를 적용
	 * f.compose(g) -> 함수 g를 먼저 적용하고, 그 다음에 함수 f를 적용
	 * p809
	 * */
	
	public static void main(String[] args) {
		Function<String, Integer> f = (s) -> Integer.parseInt(s,16);
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
		//함수 h의 제네릭 타입이<String,String>이다. 즉 String을 입력받아서 String을 결과로 반환
		//ex) 함수 h에 문자열 "FF"를 입력하면 결과 -> "11111111"반환
		Function<String, String> h = f.andThen(g);
		System.out.println(h.apply("FF"));
		
		//compose()이용
		Function<Integer,String> g2 = (i) -> Integer.toBinaryString(i);
		Function<String,Integer> f2 = (s) -> Integer.parseInt(s);
		Function<Integer,Integer> h2 = f.compose(g2);
		//이전과 달리 함수 h2의 제네릭 타입이 <Integer,Integer>이다.
		//함수 h2에 숫자 2를 입력하면 결과로 16을 얻음 
		System.out.println(h2.apply(2)); //2 -> "10" -> 16
	}
}
