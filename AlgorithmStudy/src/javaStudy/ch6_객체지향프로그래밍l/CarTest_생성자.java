package javaStudy.ch6_객체지향프로그래밍l;

class Car {
	String color;
	String gearType; //변속기 종류 auto, manual
	int door; //자동차 문의 개수
	Car() {}
	Car(String c, String g,int d) {
		color = c;
		gearType = g;
		door = d;
	}
}

public class CarTest_생성자 {

	public static void main(String[] args) {
		
		Car c1 = new Car();
		c1.color = "White";
		c1.gearType = "manual";
		c1.door = 4;
		//c1보단 c2가 간결하고 직관적
		Car c2 = new Car("Red","auto",2);
		
		System.out.println("c1의 color =" + c1.color + ", c2.gearType=" + c1.gearType +", c1.door =" + c1.door);
		System.out.println("c2의 color =" + c2.color + ", c2.gearType=" + c2.gearType +", c2.door =" + c2.door);
	}
}
