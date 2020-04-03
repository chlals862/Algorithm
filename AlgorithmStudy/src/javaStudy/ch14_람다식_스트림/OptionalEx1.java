package javaStudy.ch14_람다식_스트림;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalEx1 {
	/*
	 * Optional<T> -> 제네릭 클래스로 "T타입의 객체"를 감싸는 래퍼 클래스
	 * Optional타입의 객체에는 모든 타입의 참조변수를 담을 수 있음
	 * 최종 연산의 결과를 그냥 반환하는게 아닌 Optional객체에 담아서 반환함
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		Optional<String> optStr = Optional.of("abcde");
		Optional<Integer> optInt = optStr.map(String::length);
		System.out.println("optStr = " + optStr.get()); //abcde
		System.out.println("optInt = " + optInt.get()); //5
		
		int result1  = Optional.of("123").filter(x -> x.length() > 0).map(Integer::parseInt).get();
		System.out.println("result1 = " + result1); //123 -> x.length < 0일땐 NoSuchElementException발생
		
		//orElse() -> null일때 -1 반환
		int result2 = Optional.of("").filter(x -> x.length() > 0).map(Integer::parseInt).orElse(-1);
		System.out.println("result2 = " + result2); //-1
		
		Optional.of("456").map(Integer::parseInt).ifPresent(x -> System.out.printf("result3 = %d%n", x)); //456
		
		OptionalInt optInt1 = OptionalInt.of(0); //0을 저장
		OptionalInt optInt2 = OptionalInt.empty(); //빈 객체를 생성
		
		//isPresent() -> Optional객체의 값이 null이면 false, null이 아니면 true를 반환
		System.out.println(optInt1.isPresent()); //true  || "456"이 있으므로 not null -> true
		System.out.println(optInt2.isPresent()); //false || 비어있으므로 null -> false
		
		//getAsInt() -> 값을 반환하는 메서드
		System.out.println(optInt1.getAsInt()); //0
		//System.out.println(optInt2.getAsInt()); -> NoSuchElementException
		System.out.println("optInt1 = " + optInt1); //OptionalInt[0]
		System.out.println("optInt2 = " + optInt2); //OptionalInt.empty
		
		System.out.println("optInt1.equals(optInt2) = " + optInt1.equals(optInt2)); //false
		System.out.println("-------------------------------");
		
		//ofNullable() -> 참조변수의 값이 null일 가능성이 있으면 of()대신 ofNullable()을 사용
		//of()는 매개변수의 값이 null이면 NullPointerException을 발생하기 때문
		Optional<String> opt = Optional.ofNullable(null); //null을 저장
		Optional<String> opt2 = Optional.empty();
		
		System.out.println("opt = " + opt); //Optional.empty
		System.out.println("opt2 = " + opt2); //Optional.empty
		System.out.println("opt.equals(opt2) = " + opt.equals(opt2)); //true
		
		int result3 = optStrToInt(Optional.of("123"), 0);
		int result4 = optStrToInt(Optional.of(""), 0);
		
		System.out.println("result3 = " + result3); //123
		System.out.println("result4 = " + result4); //0
	
	}
	
	static int optStrToInt(Optional<String> optStr, int defaultValue) {
		try {
			return optStr.map(Integer::parseInt).get();
		} catch (Exception e) {
			return defaultValue;
		}
	}
}
