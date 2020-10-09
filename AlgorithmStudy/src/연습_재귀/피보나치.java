package 연습_재귀;
//반복 함수
public class 피보나치 {
	//두개의 수를 합쳐서 한개의 수를 만드는 과정
	//1 1 -> 1 2 -> 2 3 -> 3 5 -> 5 8 ..
	static int fibonacci(int num) {
		//몇번쨰 행의 값이 무엇인지 알아보기
		int first = 1;
		int second = 1;
		int result = -1; //->-1은 문제가 발생했을때의 반환 값
		if(num == 1) {
			return first;
		}
		else if(num == 2)
		{
			return second;
		} 
		else {
			for(int i=2;i<num;i++) {
				result = first + second;
				first = second;
				second = result;
			}
		}
		return result;
	}
	
	static int fibonacci2(int num) {
		if(num == 1) {
			return 1;
		}
		else if(num == 2) {
			return 1;
		}
		else {
			return fibonacci2(num - 1) + fibonacci2(num -2);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("10번째의 원소는 : " + fibonacci(10));//반복 함수
		System.out.println("10번쨰의 원소는 : " + fibonacci2(10));//재귀 함수
	}

}
