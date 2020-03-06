package javaStudy.ch7_객체지향프로그래밍II;

public class InnerEx2_내부클래스 {
	/*
	 * [Tip]인스턴스멤버는 같은 클래스에 있는 인스턴스멤버와 static멤버 모두 직접 호출이 가능 하지만
	 * static멤버는 인스턴스멤버를 직접 호출할 수 없는 것 처럼, 
	 * 
	 * 인스턴스 클래스는 외부클래스의 인스턴스멤버를 객체생성 없이 바로 사용할 수 있지만
	 * static 클래스는 외부클래스의 인스턴스멤버를 객체생성 없이 사용할 수 없음
	 * */
	class InstanceInner {} 
	static class StaticInner {} 
	//인스턴스멤버 간에는 서로 직접 접근이 가능함
	InstanceInner iv = new InstanceInner();
	
	//static 멤버 간에는 서로 직접 접근이 가능
	static StaticInner cv = new StaticInner();
	
	static void staticMethod() {
		//static멤버는 인스턴스멤버에 직접 접근할 수 없음
		//InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		
		//굳이 접근하려면 아래와 같은 방법을 수행
		InnerEx2_내부클래스 outer = new InnerEx2_내부클래스(); //1.객체생성
		InstanceInner obj1 = outer.new InstanceInner(); //2.인스턴스클래스는 외부 클래스를 먼저 생성해야만 생성 가능
	}//staticMethod of end
	
	void instanceMethod() {
		//인스턴스메서드에서는 인스턴스 멤버와 static멤버 모두 접근이 가능
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		//메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근 불가
	//	LocalInner lv = new LocalInner();
		
	}//instanceMethod of end
		
	void myMethod() {
		class LocalInner {}
		LocalInner lv = new LocalInner();
	}//myMethod of end
	
}
