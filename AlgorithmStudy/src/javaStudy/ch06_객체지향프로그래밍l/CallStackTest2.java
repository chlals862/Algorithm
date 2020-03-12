package javaStudy.ch06_객체지향프로그래밍l;

public class CallStackTest2 {

	public static void main(String[] args) {
		System.out.println("main 실행!");
		firstMethod();
		System.out.println("main 종료!");
	}

	static void firstMethod() {
		System.out.println("firstMethod 실행!");
		secondMethod();
		System.out.println("firstMethod 종료!");
	}
	static void secondMethod() {
		System.out.println("secondMethod 실행!");
		System.out.println("secondMethod 종료!");
	}
}