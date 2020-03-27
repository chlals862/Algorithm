package javaStudy.ch14_람다식_스트림;
	/*
	 * 람다식 내에서 외부에 선언된 변수에 접근하는 방법을 보여주는 에제
	 * ★★람다식 내에서 참조하는 지역변수는 final이 부지 않았어도 상수로 간주됨
	 * 람다식 내에서 지역변수 i와 val을 참조하고 있으므로 람다식 내에서나 다른 어느 곳에서도 이 변수들의 값을 변경하는 일은 허용되지 않음
	 * -------------------------------------------------------------------------------------
	 	반면에 Inner클래스와 Outer클래스의 인스턴스 변수인 
	 	this.val과 Outer.this.val은 상수로 간주되지 않으므로 값 변경 가능
	 * */
@FunctionalInterface
interface MyFunction2 {
	void myMethod();
}

class Outer {
	int val = 10; //Outer.this.val -> 인스턴스 변수
	
	class Inner {
		int val = 20; //this.val -> 인스턴스 변수
		
		void method(int i) { // void method(final int i) {
			int val = 30; //final int val = 30;
			//i = 10; //상수의 값은 변경 X 
		
		MyFunction2 f = () -> { // -> 람다식 사용
			System.out.println("i : " + i);
			System.out.println("val : " + val);
			System.out.println("this.val : " + ++this.val);
			System.out.println("Outer.this.val : " + ++Outer.this.val);
		};
			f.myMethod();
		}// method
	}// Inner
}// Outer

public class LambdaEx3 {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method(100);
	}
}