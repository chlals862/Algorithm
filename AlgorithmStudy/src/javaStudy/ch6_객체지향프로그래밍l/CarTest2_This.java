package javaStudy.ch6_객체지향프로그래밍l;
	/*
	 * 생성자 간에도 서로 호출이 가능한데 
	 * 1. 생성자의 이름으로 클래스이름 대신 this를 사용한다.
	 * 2. 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에만 호출이 가능하다.
	 * 이 두 조건을 만족해야함
	 * ===================================================================
	 * 반드시 첫 줄에만 호출이 되야하는 이유는
	 * 생성자 내에서 초기화 작업도중에 다른 생성자를 호출하게 되면, 호출된 다른 생성자 내에서도
	 * 멤버변수들의 값을 초기화를 할 것이므로 다른 생성자를 호출하기 이전의 초기화 작업이 무의미해질 수 있기 떄문
	 * */
class Car2 {
	
	String color;
	String gearType;
	int door;
	
	Car2() {
		this("White","auto",4); //Car(String color,String gearType,int door)를 호출
	}

	Car2(String color) {
		this(color,"auto",4);
	}
	
	Car2(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

public class CarTest2_This {

	public static void main(String[] args) {
		Car2 c1 = new Car2();
		Car2 c2 = new Car2("blue");

		System.out.println("c1의 color =" + c1.color + ", c2.gearType=" + c1.gearType +", c1.door =" + c1.door);
		System.out.println("c2의 color =" + c2.color + ", c2.gearType=" + c2.gearType +", c2.door =" + c2.door);
	
	}
}
