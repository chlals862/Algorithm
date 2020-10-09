package 연습_재귀;
//반복 함수
public class 팩토리얼2 {
	static int factorial(int num) {
		int sum = 1;
		for(int i = 2; i<=num; i++) {
			sum *= i;
		}
		return sum;
	}
	static int factorial2(int num) {
		if(num==1) 
			return 1;
		else
			return num * factorial(num -1);
	}
	public static void main(String[] args) {
		System.out.println("반복 팩토리얼 :" + factorial(10));
		System.out.println("재귀 팩토리얼" + factorial2(10));
	}
}

