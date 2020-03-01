package javaStudy.ch3_연산자;

public class OperatorEx30_쉬프트연산자 {
/* 쉬프트연산자를 사용하는 것이 나눗셈,곱셈 연산자를 사용하는 것보다 빠름
 * 
 * 00001000 10진수 8
 * 8<<2 -> 10진수 8의 2진수를 왼쪽으로 2자리 이동
 * 00100000 빈자리는 0으로 채워짐 -> 결과값: 32
 * 
 * >>연산자는 오른쪽으로 이동시키기 때문에 부호있는 정수는 부호를 유지하기 위해
 * 왼쪽 피연산자가 음수인 경우 빈자리를 1로 채우고 양수인 경우 0을 채운다.
 * 
 * 11111000 10진수 -8
 * -8>>2 -> 10진수 -8의 2진수를 오른쪽으로 2자리 이동
 * 11111110 빈자리는 1로 채워짐 -> 결과값: -2
 * 
 * 좌측 피연산자는 산술변환이 적용되어 int보다 작은 타입은 int타입으로 자동 변환 되고 연산결과 역시 int타입으로 변환
 * 하지만 쉬프트 연산자는 다른 이항연산자들과 달리 피연산자의 타입을 일치시킬 필요가 없기 때문에 우측 피연산자에서는 산술변환이 적용되지 않음
 * 
 * x << n은 x * 2의 n승의 결과와 같음
 * x >> n은 x / 2의 n승의 결과와 같음
 * 
 * */
	
	static String toBinaString(int x) {//10진 정수를 2진수로 변환하는 메서드
		/*
		 * 4byte의 정수를 32자리의 2진수로 변환
		 * */
		String zero = "00000000000000000000000000000000";
		String tmp = zero + Integer.toBinaryString(x);
		return tmp.substring(tmp.length()-32);
	}
	
	public static void main(String[] args) {
		int dec = 8;
		System.out.println("dec = " + dec);
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 1, dec >> 1, toBinaString(dec >> 1));
		System.out.printf("%d << %d = %4d \t%s%n", dec, 1, dec << 1, toBinaString(dec << 1));
	
		dec = -8;
		System.out.println("dec = " + dec);
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 1, dec >> 1, toBinaString(dec >> 1));
		System.out.printf("%d << %d = %4d \t%s%n", dec, 1, dec << 1, toBinaString(dec << 1));
	}
	
	
	
	
	
	
}
