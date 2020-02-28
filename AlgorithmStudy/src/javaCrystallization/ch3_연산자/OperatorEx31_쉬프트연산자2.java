package javaCrystallization.ch3_연산자;

public class OperatorEx31_쉬프트연산자2 {

	public static void main(String[] args) {
		int dec = 1234;
		int hex = 0xABCD;
		int mask = 0xF;
		
		/*
		 * A = 1010
		 * B = 1011
		 * C = 1100
		 * D = 1101
		 * E = 1110
		 * F = 1111
		 * */
		System.out.printf("hex = %X%n", hex);
		System.out.printf("%X%n", hex & mask);
		
		hex = hex >> 4;
		System.out.printf("%X%n", hex & mask);
		
		hex = hex >> 4;
		System.out.printf("%X%n", hex & mask);
		
		hex = hex >> 4;
		System.out.printf("%X%n", hex & mask);
		
		int hex2 = 0x0ABC;
		System.out.printf("%X%n", hex2 & 0xF);
		/* 0X0ABC에 0XF로 비트AND연산자 수행 시 0XABCD으 오른쪽 끝에서 두번쨰 자리인 0XC의 결과를 얻을 수 있음
		 * 위의 과정을 반복 시 16진수 0XABCD의 각 자리를 하나씩 얻을 수 있음
		 *     0    A    B    C
		 * 	 0000 1010 1011 1100
		 * 	 0000 0000 0000 1111 
		 * &   0   0    0    F
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 0000 0000 0000 1100
		 *  0    0    0    C   
		 * */
	}
}
