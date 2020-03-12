package javaStudy.ch03_연산자;

public class OperatorEx29_비트전환연산자 {
/*
 * 비트 전환연산자 ~
 * 피연산자를 2진수로 표현했을 떄, 0은 1로 1은 0으로 바꿈
 * 논리 부정연산자 !와 비슷함
 * 
 * x = 1일떄  ~x = 0
 * x = 0일때  ~x = 1
 * 비트연산자에 의해 비트전환이 되면 부호 있는 타입의 피연산자는 부호가 반대로 변경됨
 * 즉 피연산자의 1의 보수를 얻을 수 있음
 * 
 * 비트전환연산자 -> 1의 보수연산자 라고도 함
 * 
 * 10진수 10 
 * 00001010 을 비트전환 연산한 결과는
 * 11110101 이다 -> -11 (10의 1의 보수)
 * 
 * ★★★-11인 이유는 정수형 타입은 부호가 존재할 떄 양수보다 음수 값이 1이 더 큼 ★★★
 * 
 * */
	
	public static void main(String[] args) {
		byte p = 10;
		byte n = -10;
		
		System.out.printf("p = %d \t%s%n", p, toBinaString(p));
		System.out.printf("~p = %d \t%s%n", ~p, toBinaString(~p));
		System.out.printf("~p+1 = %d \t%s%n", ~p+1, toBinaString(~p+1));
		System.out.printf("~~p = %d \t%s%n", ~~p, toBinaString(~~p)); //비트전환 연산자를 두번 쓰면 원래의 값과 동일 , 연산결과의 타입은 byte가 아닌 int로 변환
		System.out.println();
		System.out.printf("n = %d%n", n);
		System.out.printf("~n = %d%n", ~n);
		System.out.printf("~(n-1)=%d%n", ~(n-1));
	}

	static String toBinaString(int x) {//10진 정수를 2진수로 변환하는 메서드
		/*
		 * 4byte의 정수를 32자리의 2진수로 변환
		 * */
		String zero = "00000000000000000000000000000000";
		String tmp = zero + Integer.toBinaryString(x);
		return tmp.substring(tmp.length()-32);
	}
	
	
}
