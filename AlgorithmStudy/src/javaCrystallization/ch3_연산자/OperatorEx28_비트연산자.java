package javaCrystallization.ch3_연산자;
/*
 * 비트연산의 결과를 2진수로 출력하기
 * 16진수 : 0x 
 * 123456789ABCDEF...
 * 
 * & 둘다 1일때만 1
 * | 하나라도 1일떄 1
 * ^ 둘다 값이 다를 떄 1
 * 
 * */




public class OperatorEx28_비트연산자 {
	public static void main(String[] args){
		int x = 0xAB, y = 0xF;
		//toBinaryString -> 비트연산의 결과를 2진수로 출력하기 위한 메서드
		System.out.printf("x = %#X \t%s%n", x, toBinaryString(x)); 
		
		System.out.printf("%#X | %#X = %#X \t%s%n" , x,y, x|y, toBinaryString(x|y));
		System.out.printf("%#X & %#X = %#X \t%s%n" , x,y, x&y, toBinaryString(x&y));
		System.out.printf("%#X ^ %#X = %#X \t%s%n" , x,y, x^y, toBinaryString(x^y));
		System.out.printf("%#X ^ %#X = %#X \t%s%n" , x,y, x^y^y, toBinaryString(x^y^y));
	
	}
	
static String toBinaryString(int x) { //10진 정수를 2진수로 변환하는 메서드
	/*
	 * 4byte의 정수를 32자리의 2진수로 변환
	 * */
	String zero = "00000000000000000000000000000000";
	String tmp = zero + Integer.toBinaryString(x);
	return tmp.substring(tmp.length()-32);
	
	}
}
