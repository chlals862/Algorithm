package 연습_재귀;

public class 팩토리얼 {

	public static void main(String[] args) {
		//각각의 방식으로 구현한 n! 출력 (n=5)
		System.out.println("반복적으로 구현 :" + factorialIterative(10));
		System.out.println("재귀적으로 구현 :" + factorialRecursive(10));
	}
	//재귀적
	private static int factorialRecursive(int n) {
		//n이 1이하인 경우 1을 반환
		if(n<= 1)return 1;
		// n! = n*(n-1) 작성
		return n*factorialRecursive(n-1);
	}
	//반복적
	private static int factorialIterative(int n) {
		int result = 1;
		//1부터 n까지의 수를 차례대로 곱하기
		for(int i=1;i<=n;i++) {
			result *= i;
		}
		return result;
	}
}
