package javaStudy.practice.스트림;
	/*
	 * 스트림 -> 데이터소스를 추상화하고, 데이터를 다루는데 자주 사용되는 메서드들을 정의함
	 * 데이터소스를 추상화 -> 데이터소스가 무엇이던 간에 같은 방식으로 다룰 수 있게 되었다는것과 코드의 재사용이 높아짐
	 * --------------------------------------------------------------------------
	 * 스트림은 데이터소스를 반환하지 않음 -> 데이터를 읽기만 함
	 * 스트림은 일회용 -> 필요시 다시 생성해야함
	 * 스트림은 작업을 내부 반복으로 처리 -> 반복문을 메서드의 내부에 숨길 수 있다는 것
	 * */

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx1_기본 {

	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5); //가변인자
		Stream<Integer> intStream = list.stream(); //list를 소스로 하는 컬렉션 생성
		
		//forEach() -> 지정된 작업을 스트림의 모든 요소에 대해 수행
		
		intStream.forEach(System.out::print);
	  //intStream.forEach(System.out::print); 에러 -> 스트림은 일회용임 [닫힘]
		System.out.println();
		IntStream intStream2 = IntStream.range(1, 5); //end가 범위에 포함되지 않음
		IntStream intStream3 = IntStream.rangeClosed(1, 5); //end가 범위에 포함 됨
		intStream2.forEach(System.out::print);
		System.out.println();
		intStream3.forEach(System.out::print);
		
		/*
		 * 임의의 수
		 * 난수를 생성하는데 사용하는 Random클래스에는 아래와 같은 인스턴스 메서드들이 포함되어 있음
		 * IntStream ints()
		 * LongStream longs()
		 * DoubleStream doubles()
		 * 이 메서드들이 반환하는 스트림은 크기가 정해지지 않은 '무한 스트림이므로', limit()을 같이 사용해서 
		 * 스트림의 크기를 제한을 해줘야 함, limit()은 스트림의 개수를 지정하는 데 사용
		 * */
		System.out.println();
		IntStream intStream4 = new Random().ints(); //무한 스트림
	  //IntStream intStream4 = new Random().ints(5); //크기가 5인 난수 스트림 반환
		intStream4.limit(5).forEach(System.out::println);
		
		//두 스트림 연결
		String[] str1 = {"123","456","789"};
		String[] str2 = {"ABC","abc","DEF"};
		
		Stream<String> strs1 = Stream.of(str1);
		Stream<String> strs2 = Stream.of(str2);
		Stream<String> strs3 = Stream.concat(strs1, strs2); //두 스트림을 하나로 연결
		//strs1.forEach(System.out::print);
		//strs2.forEach(System.out::print);
		strs3.forEach(System.out::print);
		
		/*
		 * 스트림의 연산 -> 중간연산 / 최종연산으로 분류 됨
		 * 중간연산 -> 연산결과를 스트림으로 반환하기 때문에 중간 연산을 연속해서 연결할 수 있음
		 * 최종연산 -> 스트림의 요소를 소모하면서 연산을 수행하므로 단 한번만 연산이 가능
		 * ex)
		 * stream.distinct().sorted().forEach(System.out::println)
		 *         중간연산            중간연산                        최종연산
		 * ---------------------------------------------------------
		 * 중간연산
		 * 스트림 자르기 -> skip(), limit() -> 스트림의 일부를 잘라낼 때 사용
		 * Stream<T> skip(long n) -> 처음 n개의 요소를 건너뜀
		 * Stream<T> limit(long maxSize) -> 스트림의 요소를 n개로 제한
		 * */
		System.out.println();
		IntStream intStream5 = IntStream.rangeClosed(1, 10); //1~10의 요소를 가진 스트림
		intStream5.skip(3).limit(5).forEach(System.out::print); // 4,5,6,7,8 -> skip(3) 1,2,3을 건너 뛰고 , 5개
	
		/*
		 * 스트림의 요소 걸러내기 -> filter(), distinct()
		 * distinct() -> 스트림에서 중복된 요소를 제거
		 * filter()   -> 주어진 조건(Predicate)에 맞지 않는 요소를 걸러냄
		 * */
		//Stream<T> filter(Predicate<? super T> predicate)
		//Stream<T> distinct()
		System.out.println();
		IntStream intStream6 = IntStream.of(1,2,2,3,3,3,4,5,5,6);
		intStream6.distinct().forEach(System.out::print); //중복제거 -> 123456
		
		System.out.println();
		//filter()는 매개변수로 Predicate를 필요로 하는데, 아래와 같이 연산결과가 boolean인 람다식을 사용해도 됨
		IntStream intStream7 = IntStream.rangeClosed(1, 10);
		intStream7.filter(i -> i%2 == 0).forEach(System.out::print); //246810
		//filter()를 다른 조건으로 여러 번 사용할 수도 있음
		System.out.println();
		IntStream intStream8 = IntStream.rangeClosed(1, 10);//스트림은 일회용이므로 다시 생성
		intStream8.filter(i -> i%2 != 0 && i%3 != 0).forEach(System.out::print); //157
		
		System.out.println();
		IntStream intStream9 = IntStream.rangeClosed(1, 10);//스트림은 일회용이므로 다시 생성
		intStream9.filter(i -> i%2 != 0).filter(i -> i%3 != 0).forEach(System.out::print); //157
	
		/*
		 * 스트림 정렬 -> sorted()
		 * sorted()는 지정된 Comparator로 스트림을 정렬함, Comparator대신 int값을 반환하는 람다식을 사용하는 것도 가능
		 * */
		System.out.println();
		Stream<String> strStream = Stream.of("dd","aaa","CC","cc","b");
		strStream.sorted().forEach(System.out::print); //내림차순
		
	}
}
