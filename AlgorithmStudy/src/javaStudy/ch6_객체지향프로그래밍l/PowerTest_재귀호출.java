package javaStudy.ch6_객체지향프로그래밍l;

public class PowerTest_재귀호출 {
	/*
	 * x의 1승부터 x의 n승까지의 합을 구하는 예제
	 * 
	 * */
	public static void main(String[] args) {
		//x가 2 n이 5이기 때문에 2의 1승 ~ 2의 5승까지의 합인 62가 출력됨
		int x = 2;
		int n = 5;
		
		long result = 0;
		
		for(int i=1;i<=n;i++) {
			result += power(x, i);
		}//for of end
		System.out.println(result);
	}
	
	static long power(int x, int n) {
		if(n==1) return x;
		//x의 n제곱을 계산
		//f(x, n) = x*f(x,n-1), 단 f(x,1) = x
		return x * power(x, n-1);
		/* x=2 n=5일때
		 * -> f(2,5) = 2*(2,4);
		 * -> f(2,5) = 2*2*(2,3);
		 * -> f(2,5) = 2*2*2*(2,2);
		 * -> f(2,5) = 2*2*2*2(2,1);
		 * -> f(2,5) = 2*2*2*2*2 ->32 즉 2의 5제곱은 32라는 결과가 나옴
		 * 2의 5제곱이 32이므로 4제곱은 16 3제곱은 8 2제곱 4 2의 1제곱은 2이므로 합은 62
		 * */
	}
}
