package javaStudy.ch7_객체지향프로그래밍II;
	/*
	 * 내부 클래스와 외부 클래스에 선언된 변수의 이름이 같을 떄 변수 앞에 'this'
	 * 또는 '외부 클래스명.this'를 붙여서 서로 구별할 수 있다는 예제
	 * */
class Outer2 {
	int value = 10; //Outer2.this.value
	
	class Inner2 {
		int value = 20; //this.value
		
		void Method1() {
			int value = 30;
			System.out.println("value : " + value);
			System.out.println("this.value : " + this.value);
			System.out.println("Outer2.this.value : " + Outer2.this.value);
		}
	}
}

public class InnerEx5_내부클래스 {

	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		Outer2.Inner2 inner = outer.new Inner2();
		inner.Method1();
	}
}
