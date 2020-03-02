package javaStudy.ch6_객체지향프로그래밍l;

public class FactorialTest2_재귀호출 {
	/*
	 * 재귀호출 -> 메서드 내부에서 메서드 자신을 다시 호출
	 * 재귀호출 하는 메서드는 재귀메서드
	 * 메서드 factorial의 매개변수 n이 음수이거나 20보다 크면 -1을 반환
	 * */
	static long factorial(int n) {
		if(n<=0 || n>20) return  -1; //n이 0보다 작거나 0이거나, 20보다 클때 -1반환
		if(n<=1) return 1; // n이 1이거나 1보다 클때 1반환
		return n * factorial(n-1);
	}//static of end
	public static void main(String[] args) {
		
		int n = 21;
		long result = 0;
		
		for(int i=1;i<=n;i++) {
			result = factorial(i); 
			
			if(result==-1) { //결과값이 -1일때 아래 문장 수행 후 반복문 벗어나기
				System.out.printf("유효하지 않은 값 (0<n<=20):%d%n",n);
				break;
			}
			//-1이 아닐때 아래 문장 수행
			System.out.printf("%2d!=%20d%n",i,result);
		}
	}//main of end
}
