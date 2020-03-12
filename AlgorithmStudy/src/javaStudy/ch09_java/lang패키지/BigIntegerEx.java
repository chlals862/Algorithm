package javaStudy.ch09_java.lang패키지;

import java.math.BigInteger;

public class BigIntegerEx {
	/* BigInteger -> long타입보다 훨씬 큰 정수를 가질 수 있음
	 * 팩토리얼 코드에서는 참조변수를 초기화 할 떄 사용한 ONE객체가 미리 정의된 상수 하나로 정수 1에 해당
	 * 그 외 0(ZERO)는 0
	 * 
	 * */
	public static void main(String[] args) throws Exception{
		for(int i=1;i<100;i++) {//1!부터 99!까지 출력
			System.out.printf("%d!=%s%n", i, calcFactorial(i));
			//Thread.sleep(1000);
		}
	}
	
	static String calcFactorial(int n) {
		return factorial(BigInteger.valueOf(n)).toString();
	}
	
	static BigInteger factorial(BigInteger n) {

		if(n.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		else //return n * factorial(n-1);
			return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}
	
}
