package javaStudy.ch07_객체지향프로그래밍II;

public class DrawShape_클래스관계 {
	/*
	 *	클래스간의 관계 - 포함관계 
	 *  포함관계 -> 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것
	 * 
	 * Ex) 원(Circle)은 점(Point)이다. - Circle is a Point   (is ~ a)
	 *     원(Circle)은 점(Point)를 가지고 있다. - Circle has a Point  (has ~ a)
	 * 
	 * 	'~은 ~이다'라는 문장이 성립한다면, 서로 상속관계를 맺어줌 
	 *  '~은 ~을 가지고 있다'라는 문장이 성립한다면, 포함관계를 맺어줌
	 *  따라서 Circle클래스와 Point클래스 간의 관계는 상속관계보다 포함관계를 맺어 주는게 맞음
	 *  
	 *  class Circle {
	 *  int x; 원점의 x좌표
	 *  int y; 원점의 y좌표
	 *  int z; 반지름(radius)
	 *  }
	 *  
	 *  class Point{
	 *  int x; x좌표
	 *  int y; y좌표
	 *  }
	 *  
	 *  ------------------------------------------
	 *  class Circle {
	 *   Point c = new Point(); //원점
	 *   int r;
	 *  }
	 *  
	 *  추가 Ex) Car클래스와 SportsCar클래스는 'SportCar'는 Car이다. 와 같이 문장을 만드는 것이 옳기 떄문에
	 *  	       이 두 클래스는 Car클래스는 조상으로 하는 상속관계를 맺어줌
	 *  
	 *         Card클래스와 Deck클래스는 'Deck은 Card를 가지고 있다.'와 같이 문장을 만드는 것이 옳기 때문에
	 *         이 두 클래스는 Deck클래스에 Card클래스를 포함시켜야 하는게 맞음
	 * */
	public static void main(String[] args) {
		//이 예제는 도형을 의미하는 Shape 클래스를 정의하고, 2차원 좌표에서의 점을 의미하는 Point클래스를 정의한 다음,
		//이 두 클래스를 재활용해서 Circle클래스와 Triangle클래스를 정의함
	Point[] p = { new Point(100, 100),
				  new Point(140,  50),
				  new Point(200, 100) 
	};
	Triangle t = new Triangle(p);
	Circle c = new Circle(new Point(150, 150), 50); 
	/*
	 * Circle c = new Circle(new Point(150, 150), 50); 이 문장은
	 * Point p = new Point(150, 150);
	 * Circle c = new Circle(p, 50)과 같은 문장
	 * */
	t.draw(); //삼각형 그리기
	c.draw(); //원 그리기
	}//main of end
}//public class of end

//원은 도형임 -> 상속관계
//원은 점을 가지고 있음 -> 포함관계
class Shape {
	String color = "black";
	void draw() {
		System.out.printf("[color=%s]%n", color);
	}
}//class Shape of end

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Point() {
		this(0,0);
	}
	String getXY() {
		return "("+x+","+y+")"; //x와 y의 값을 문자열로 반환
	}
}//Point class of end

class Circle extends Shape { //Circle과 Shape는 상속관계★★★
							 //Circle클래스는 Shape클래스로부터 모든 멤버를 상속받았으므로, Shape클래스에 정의된 color 또는 draw()사용 가능
	Point center; //원의 원점좌표  //Circle과 Point는 포함관계★★★
	int r; //반지름
	
	Circle() {
		this(new Point(0,0), 100); //Circle(Point Center, int r)를 호출
	}
	Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	void draw() { // 원을 그리는 대신 원의 정보를 출력
		System.out.printf("[center=(%d,%d), r=%d, color=%s]%n", center.x, center.y, r, color);
		//Shape클래스와 Circle클래스 모두 darw()를 가지고 있지만,
		//조상 클래스에 정의된 메서드와 같은 메서드를 자손 클래스에 정의하는 '오버라이딩'에 의해 Circle클래스의 draw()가 호출 됨
	}
}//Circle of end

class Triangle extends Shape {
	Point[] p = new Point[3]; //3개의 Point인스턴스를 담을 배열을 생성
	
	Triangle(Point[] p) {
		this.p = p;
	}
	
	void draw() {
		System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}
	
}