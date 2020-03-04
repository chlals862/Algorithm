package javaStudy.ch7_객체지향프로그래밍II;

public class PointTest2_Super {
	/*
	 * Point3D클래스의 이스턴스를 생성할 때 어떤 순서로 인스턴스의 초기화가 진행되는지 보여주기 위한 예제
	 * 
	 * */
	public static void main(String[] args) {
		Point3D p3 = new Point3D();
		
		System.out.println("p3.x =" + p3.x);
		System.out.println("p3.y =" + p3.y);
		System.out.println("p3.z =" + p3.z);
	}//class of end
}

	class Point2 {
		int x = 10;
		int y = 20;
		
		Point2(int x, int y) {
			 				// <---- 생성자 첫 줄에서 다른 생성자를 호출하지 않기 때문에 컴파일러가 super();를 여기에 삽입함
							// super()는 Point2의 조상인 Object클래스의 기본 생성자인 Object()를 의미함
			this.x = x;
			this.y = y;
		}//Point of end
	}//Point2 class of end
	//==========================================================================================
	
	class Point3D extends Point2 {
		int z = 30;
		
		Point3D() { //1번
			this(100, 200, 300);//2번      Point3D(int x, int y, int z)를 호출 (35번째 줄)
		}
		
	Point3D(int x, int y, int z) {
		super(x,y);  //3번      Point(int x, int y)를 호출 (21번째 줄)
		this.z = z;
	}
}//Point3D class of end