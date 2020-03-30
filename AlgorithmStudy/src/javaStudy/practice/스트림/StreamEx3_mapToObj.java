package javaStudy.practice.스트림;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3_mapToObj {
	/*
	 * IntStream -> Stream<T>로 변환할 때는 mapToObj()
	 * IntStream -> Stream<Integer>로 변환할 때는 boxed()
	 * 
	 * */
	public static void main(String[] args) {
		IntStream intStream = new Random().ints(1,46); //1~45의 정수(46은 포함되지 않음)
		Stream<String> lottoStream = intStream.distinct().limit(6).sorted().mapToObj(i -> i+ ","); //중복X,6개제한,정렬
		
		lottoStream.forEach(System.out::print);
	}
}
