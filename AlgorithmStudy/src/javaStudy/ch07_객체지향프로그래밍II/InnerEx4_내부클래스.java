package javaStudy.ch07_객체지향프로그래밍II;

class Outer {
	class InstanceInner {
		int iv = 100;
	}// class InstanceInner of end

	static class StaticInner {
		int iv = 200;
		static int cv = 200;
	}// static class of end

	void myMethod() {
		class LocalInner {
			int iv = 400;

		}// LocalInner of end
	}// myMethod of end
}// class outer of end

public class InnerEx4_내부클래스 {

	public static void main(String[] args) {
		//인스턴스클래스의 인스턴스를 생성하려면
		//외부 클래스의 인스턴스를 먼저 생성해야 한다.
		Outer oc = new Outer();
		Outer.InstanceInner ii = oc.new InstanceInner();
		
		System.out.println("ii.iv : " + ii.iv);
		System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);
		
		//스태틱 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 됨
		Outer.StaticInner si = new Outer.StaticInner();
		System.out.println("si.iv : " + si.iv);
	}
}
