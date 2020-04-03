package javaStudy.ch14_람다식_스트림;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx5_reduce {

	/*
	 * 리듀싱(reduce()) -> 스트림의 요소를 줄여나가면서 연산을 수행하고 최종결과를 반환
	 * 그래서 매개변수의 타입이 BinaryOperator<T>임
	 * 처음 두 요소를 가지고 연산한 결과를 가지고 그 다음 요소와 연산
	 * 
	 * max()와 min()의 경우, 초기값이 필요없으므로 Optional<T>를 반환하는 매개변수 하나짜리 reduce()를 사용하는 것이 좋음
	 * intStream의 타입이 IntStream인 경우 OptionalInt를 사용해야함★★★
	 * Stream<T>와 달리 IntStream에 정의된 reduce()의 반환 타입이 OptionalInt임
	 * 
	 * OptionalInt max = intStream.reduce(Integer::max); -> int max(int a, int b)
	 * OptionalInt min = intStream.reduce(Integer::min); -> int min(int a, int b)
	 * 
	 * OptionalInt에 저장된 값을 꺼낼 때는
	 * int maxValue = max.getAsInt(); -> OptionalInt에 저장된 값을 maxValue에 저장
	 * */
	
	public static void main(String[] args) {
		String[] strArr = {"Inheritance", "Java", "Lambda", "stream", "OptionalDouble", "IntStream", "count", "sum"};
		
		Stream.of(strArr).forEach(System.out::println); //strArr출력
		
		//noneMatch() -> 스트림의 요소에 대해 지정된 조건에 어떤 요소도 일치하지 않는지 확인하는데 사용
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0); //strArr중에 길이가 0인것이 있으면 false, 0인것이 없으면 true
		System.out.println("noEmptyStr = " + noEmptyStr); //true
		
		//findFirst() -> 스트림의 요소 중에 조건에 일치하는 첫 번째 것을 반환
		Optional<String> sWord = Stream.of(strArr).filter(s -> s.charAt(0) == 's').findFirst(); //첫번째 단어가 's'로 시작하는 요소중에 첫번째꺼 반환
		System.out.println("sWord = " + sWord.get()); //stream 
		System.out.println("--------------------------");
		//Stream<String[]>을 IntStream으로 반환
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
		
		int count = intStream1.reduce(0, (a,b) -> a + 1);
		int sum = intStream2.reduce(0, (a,b) -> a+b);
		
		OptionalInt max = intStream3.reduce(Integer::max);
		OptionalInt min = intStream4.reduce(Integer::min);
		
		System.out.println("count = " + count); //8 -> strArr의 갯수
		System.out.println("sum = " + sum); //58 -> strArr글자의 갯수
		System.out.println("max = " + max.getAsInt()); //14 -> strArr의 제일 긴 단어
		System.out.println("min = " + min.getAsInt()); //3 -> strArr의 제일 짧은 단어
	
	}
}
