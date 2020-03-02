package javaStudy.ch6_객체지향프로그래밍l;
	/* 클래스 메서드와 인스턴스 메서드
	 * 메서드 앞에 static -> 클래스메서드 , 붙어있지 않으면 인스턴스 메서드  
	 * 클래스 메서드도 클래스 변수처럼 객체를 생성하지 않고도 '클래스이름.메서드이름(매개변수)로 호출 가능
	 * 인스턴스 메서드는 반드시 객체를 생성해야만 호출 가능
	 * 
	 * 1.클래스를 설계할 때, 멤버변수(클래스 영역에 선언된 변수) 중 모든 인스턴스에 공통으로 사용하는 것에 static을 붙임
	 * 2.클래스 변수(static 변수)는 인스턴스를 생성하지 않아도 사용 가능
	 * 3.클래스 메서드(static 메서드)는 인스턴스 변수를 사용할 수 없음
	 * 4.메서드 내에서 인스턴스 변수를 사용하지 않는다면, static을 붙이는 것을 고려
	 * ==============================================================================
	 * ★★★ random()과 같은 Math클래스의 메서드는 모두 클래스 메서드임
	 * ★★★ Math클래스에는 인스턴스변수가 하나도 없거니와 작업을 수행하는데 필요한 값들을 모두 매개변수로 받아서 처리하기 떄문
	 * */
class MyMath2 {
	long a,b;
	
	//인스턴스 변수 a,b 만을 이용해서 작업하므로 매개변수가 필요없음
	long add() { return a+b; }
	long subtract() { return a-b; }
	long multiply() { return a*b; }
	long divide() { return a/b; }
	
	//인스턴스 변수와 관계없이 매개변수만으로 작업이 가능
	static long add(long a, long b) { return a+b; } //a,b는 지역변수
	static long subtract(long a, long b) { return a-b; } 
	static long multiply(long a, long b) { return a*b; }
	static double divide(double a, double b) { return a/b; }
	}


public class MyMathTest2_클래스_인스턴스메서드 {

	public static void main(String[] args) {
		
		//클래스메서드 호출, 인스턴스 생성없이 호출 가능
		System.out.println(MyMath2.add(200L, 100L));
		System.out.println(MyMath2.subtract(200L, 100L));
		System.out.println(MyMath2.multiply(200L, 100L));
		System.out.println(MyMath2.divide(200.0, 100.0));
	
		MyMath2 mm = new MyMath2(); //인스턴스 생성
		mm.a = 200L;
		mm.b = 100L;
		
		//인스턴스 메서드는 객체생성 후에만 호출이 가능함
		System.out.println(mm.add());
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
	}//main of end
}
