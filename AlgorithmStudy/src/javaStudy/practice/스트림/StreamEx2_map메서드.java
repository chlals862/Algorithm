package javaStudy.practice.스트림;

import java.io.File;
import java.util.stream.Stream;

/*
	 * map() -> 변환
	 * 스트림의 요소에 저장된 값 중에서 원하는 필드만 뽑아내거나 특정 형태로 변환해야 할 때
	 * 매개변수로 T타입을 R타입으로 변환해서 반환하는 함수를 지정해야 함
	 * Stream<R> map(Function<? super T,? extends R> mapper)
	 * */
public class StreamEx2_map메서드 {

	public static void main(String[] args) {
		//Ex) File의 스트림에서 파일의 이름만 뽑아서 출력하고 싶을 때, 아래와 같이 map()을 이용하면 
		Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex1"),new File("Ex1.bak"),new File("Ex2.java"),new File("Ex1.txt"));
		//map()으로 Stream<File>을 Stream<String>으로 변환
		Stream<String> fileNameStream = fileStream.map(File::getName);
		fileNameStream.forEach(System.out::println); //스트림의 모든 파일이름을 출력
		/*
		 * map() 역시 중간 연산이므로 연산결과는 String을 요소로 하는 스트림이다.
		 * map()으로 Stream<File>을 Stream<String>으로 변환했다고 볼 수 있음
		 * 
		 * 그리고 map()도 filter()처럼 하나의 스트림에 여러 번 적용할 수 있음
		 * */
		
		//스트림은 일회용이므로 스트림 다시 생성
		Stream<File> fileStream2 = Stream.of(new File("Ex1.java"), new File("Ex1"),new File("Ex1.bak"),new File("Ex2.java"),new File("Ex1.txt"));
		fileStream2.map(File::getName) //Stream<File> -> Stream<String>
		.filter(s -> s.indexOf('.') != -1) //확장자가 없는 것은 제외
		.map(s -> s.substring(s.indexOf('.') +1)) //Stream<String> -> Stream<String>
		.map(String::toUpperCase)//모두 대문자로 변환
		.distinct() //중복제거
		.forEach(System.out::print); //JAVABAKTXT
		
	}
}
