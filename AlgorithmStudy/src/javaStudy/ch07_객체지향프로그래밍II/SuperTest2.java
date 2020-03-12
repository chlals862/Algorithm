package javaStudy.ch07_객체지향프로그래밍II;

public class SuperTest2 {
	/*
	 * 같은 이름의 멤버변수가 조상 클래스인 Parent에도 있고 자손 클래스인 Child클래스에도 있을 때는
	 * super.x와 this.x는 서로 다른 값을 참조하게 됨
	 * super.x는 조상 클래스로부터 상속받은 멤버변수 x를 뜻함
	 * this.x는 자손 클래스에 선언된 멤버변수를 뜻함
	 * ======================================================================
	 * 이처럼 조상 클래스에 선언된 멤버변수와 같은 이름의 멤버변수를 자손 클래스에서 중복해서 정의하는 것이 가능하고
	 * super를 이용해서 서로 구별할 수 있음
	 * 변수만이 아니라 메서드 역시 super를 써서 호출가능
	 * 특히 조상 클래스의 메서드를 자손 클래스에서 오버라이딩한 경우에 super를 사용
	 * */
	public static void main(String[] args) {
		
		Child c = new Child();
		c.method();
	}
}
class Parent {
	int x = 10;
}

class Child extends Parent {
	int x = 20;
	
	void method() {
		System.out.println("x = " + x);
		System.out.println("this.x = " + this.x);
		System.out.println("super.x = " + super.x);
	}
}
