package javaStudy.ch7_객체지향프로그래밍II;

public class BindingTest3_참조변수와인스턴스의연결 {

	public static void main(String[] args) {
		
		Parent2 p = new Child2();
		Child2 c = new Child2();
		
		System.out.println("p.x = " + p.x);
		p.method();
		System.out.println();
		System.out.println("c.x = " + c.x);
		c.method();
	}
}

class Parent2 {
	int x = 100;
	void method() {
		System.out.println("Parent2 Method");
	}
}

class Child2 extends Parent2 {
	int x = 200;
	
	void method() {
		System.out.println("x = " + x); //this.x와 동일
		System.out.println("super.x = " + super.x);
		System.out.println("this.x = " + this.x);
	}
}
