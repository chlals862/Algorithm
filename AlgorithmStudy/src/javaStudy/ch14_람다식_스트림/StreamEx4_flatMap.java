package javaStudy.ch14_람다식_스트림;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx4_flatMap {
	/*
	 * flatMap() -> 스트림의 요소가 배열이거나 map()의 연산결과가 배열인경우,
	 * 스트림의 타입이 Stream<T[]>인 경우 -> Stream<T>로 다루는 것이 더 편리할때가 있음
	 * 이럴땐 map()보다는 flatMap()을 사용
	 * ------------------------------------------------------------
	 * flatMap()은 map()과 달리 스트림의 스트림이 아닌 스트림으로 만들어 줌
	 * 
	 * map(Arrays::stream) = Stream<String[]> -> Stream<Stream<String>>
	 * flatMap(Arrays::stream) = Stream<String[]> -> Stream<String>
	 * */

	public static void main(String[] args) {
		Stream<String[]> strArrStrm = Stream.of(new String[] {"abc","def","jkl"},
												new String[] {"ABC","DEF","JKL"});
		
		//Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);  -> map()사용
		  Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
		  
		  strStrm.map(String::toLowerCase).distinct().sorted().forEach(System.out::println); //map output
		  System.out.println("------------------------------");
		  
		  String[] lineArr = { 
				  "Believe or not It is true",
				  "Do or do not There is no try",
		  };
		  
		  Stream<String> lineStream = Arrays.stream(lineArr);
		  lineStream.flatMap(line -> Stream.of(line.split(" +"))).map(String::toLowerCase)
		  .distinct().sorted().forEach(System.out::println);
		  System.out.println("------------------------------");

		  Stream<String> strStrm1 = Stream.of("AAA","ABC","bBb","Dd");
		  Stream<String> strStrm2 = Stream.of("bbb","aaa","ccc","dd");
		 
		  Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
		  Stream<String> strStream = strStrmStrm.map(s -> s.toArray(String[]::new)).flatMap(Arrays::stream);
		  
		  strStream.map(String::toLowerCase).distinct().forEach(System.out::println);
	}
}
