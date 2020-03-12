package javaStudy.ch09_java.lang패키지;

import java.util.Random;

public class RandomEx1 {
	/*
	 * Random() -> System.현재시간을 종자값(seed)으로 이용하는 Random인스턴스를 생성
	 * Random(long seed) -> 매개변수 seed를 종자값으로 하는 Random인스턴스를 생성
	 * boolean nextBoolean() -> boolean타입의 난수를 반환
	 * void nextBytes(byte[] bytes) -> bytes배열에 byte타입의 난수를 채워서 반환
	 * double nextDouble() -> double타입의 난수를 반환 (0.0 <= x < 1.0)
	 * float nextFloat() -> float타입의 난수를 반환 (0.0 <= x < 1.0)
	 * double nextGaussian() -> 평균은 0.0이고 표준편차는 1.0인 가우시안 분포에 따른 double형의 난수를 반환
	 * int nextInt() -> int타입의 난수를 반환(int범위)
	 * int nextInt(int n) -> 0 ~ n의 범위에 있는 int값을 반환(n은 범위에 포함되지 않음)
	 * long nextLong() -> long타입의 난수를 반환(long범위)
	 * void setSeed(long seed) -> 종자값을 주어진 값(seed)로 변경
	 * */
	public static void main(String[] args) {
	
		Random rand = new Random(1);
		Random rand2 = new Random(1);
		
		System.out.println("= rand =");
		for(int i=0;i<5;i++) 
			System.out.println(i + ":" + rand.nextInt());
		System.out.println();
		
		System.out.println("= rand2 =");
		for(int i=0;i<5;i++)
			System.out.println(i + ":" + rand2.nextInt());
		//Random인스턴스 rand와 rand2가 같은 종자값(seed)를 사용하기 때문에 같은 값들을 같은 순서로 얻음
	}
}
