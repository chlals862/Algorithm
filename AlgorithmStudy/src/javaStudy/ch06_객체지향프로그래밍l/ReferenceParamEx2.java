package javaStudy.ch06_객체지향프로그래밍l;

public class ReferenceParamEx2 {
	/*
	 * 배열도 객체와 같이 참조변수를 통해 데이터가 저장된 공간에 접근함
	 * 전 예제의 Data클래스 타입의 참조변수 d와 같이 변수 x도 int배열 타입의 참조변수이기 때문에 같은 결과를 얻음
	 * */
	public static void main(String[] args) {
		
		int[] x = {10}; //크기 1인 배열, x[0] = 10
		System.out.println("main() : x = " + x[0]);
		change(x);
		
		System.out.println("After change(x)");
		System.out.println("main() : x = " + x[0]);
		
	}
	
	static void change(int[] x) { //참조형 매개변수
		x[0] = 1000;
		System.out.println("change() : x = " + x[0]);
	}
}
