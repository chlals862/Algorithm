package javaStudy.ch6_객체지향프로그래밍l;

public class ReturnTest {
	/*
	 * 반환값이 있는 메서드를 반환값이 없는 메서드로 바꾸는 예제
	 * 참조형 매개변수를 활용하면 반환값이 없어도 메서드의 실행결과를 얻어 올 수 있음
	 * */
	public static void main(String[] args) {
		
		ReturnTest r = new ReturnTest();
		
		int result = r.add(3, 5);
		System.out.println(result);
		
		int[] result2 = {0}; //배열 생성 및 result2[0]의 값을 0으로 초기화
		r.add(3, 5, result2); //배열을 add메서드의 매개변수로 전달 -> add메서드와 매개변수를 맞춰야함
		System.out.println(result2[0]);
	}
	
	int add(int a, int b) {
		return a + b;
	}
	
	//메서드는 단 하나의 값만을 반환할 수 있지만 아래처럼 응용하면 여러 개의 값을 반환받는 것과 같은 효과를 얻음
	void add(int a, int b, int[] result) {//int배열인 result[0]에 a + b를 넣으면 여러개의 값
		result[0] = a + b; //매개변수로 넘겨받은 배열에 연산결과를 저장
	}
}
