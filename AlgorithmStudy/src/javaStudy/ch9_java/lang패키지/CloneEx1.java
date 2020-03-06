package javaStudy.ch9_java.lang패키지;

class Point implements Cloneable {//clone()을 사용하려면 복제할 클래스가 Cloneable 인터페이스를 구현해야함
								  //또한 clone()을 오버라이딩하면서 접근 제어자를 protected에서 public으로 변경함
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x = " + x + "  y = " + y;
	}
	
	public Object clone() {
		Object obj = null ;
		try {
			obj = super.clone(); //clone()은 반드시 예외처리 해야함
		} catch (CloneNotSupportedException e) {} 
			return obj;
		}
}
public class CloneEx1 {
	
	public static void main(String[] args) {
		Point original = new Point(3, 5);
		Point copy = (Point)original.clone();
		System.out.println(original);
		System.out.println(copy);
	}
}

