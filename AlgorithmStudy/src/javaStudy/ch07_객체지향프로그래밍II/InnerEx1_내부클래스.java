package javaStudy.ch07_객체지향프로그래밍II;

public class InnerEx1_내부클래스 {
	/*
	 * 내부클래스 -> 클래스 내에 선언된 클래스
	 * 
	 * 내부클래스로 선언하면 두 클래스 멤버들 간에 서로 쉽게 접근할 수 있는 장점이 있음
	 * 
	 * [종류]
	 * 인스턴스 클래스 
	 * 스태틱 클래스
	 * 지역 클래스
	 * 익명 클래스
	 * */
	class InstanceInner{
	int iv = 100;
//	static int cv = 100; -> static변수를 선언할 수 없음
	final static int CONST = 100; //final static은 상수이므로 허용함 , 모든 내부 클래스에서 가능
	}//instance class of end
	
	static class StaticInner {
		int iv = 200;
		static int cv = 200; //static클래스만 static멤버를 정의함
		final static int CONST = 200;
	}//static class of end
	
	void myMethod() {
		class LocalInner {
			int iv = 300;
//			static int c = 300; static변수를 선언할 수 없음
			final static int CONST = 300; 
		}//local class of end
	}
		public static void main(String[] args) {
			System.out.println(InstanceInner.CONST);
			System.out.println(StaticInner.cv);
			System.out.println(StaticInner.CONST);
			//System.out.println(LocalInner.iv);
		}
	
	}
