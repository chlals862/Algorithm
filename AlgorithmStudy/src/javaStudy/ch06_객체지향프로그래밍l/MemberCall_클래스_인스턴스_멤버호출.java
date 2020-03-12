package javaStudy.ch06_객체지향프로그래밍l;

public class MemberCall_클래스_인스턴스_멤버호출 {
	int iv = 10; //인스턴스 변수
	static int cv = 20; //클래스 변수
	
	int iv2 = cv; 
//	static int cv2 = iv; ERROR - 클래스변수는 인스턴스 변수를 사용할 수 없음
	static int cv2 = new MemberCall_클래스_인스턴스_멤버호출().iv; // 이처럼 객체를 생성해야 사용가능
	
	static void staticMethod1() {
		System.out.println(cv);
//		System.out.println(iv); ERROR - 클래스 메서드에서 인스턴스 변수 사용 불가
		MemberCall_클래스_인스턴스_멤버호출 c = new MemberCall_클래스_인스턴스_멤버호출();
		System.out.println(c.iv); // 객체를 생성한 후에야 인스턴스 변수의 참조 가능
	}//static of end
	
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv); //인스턴스 메서드에서는 인스턴스 변수를 바로 사용가능
	}//instance of end
	
	static void staticMethod2() {
		staticMethod1();
//		instanceMethod1(); ERROR - 클래스 메서드에서는 인스턴스 메서드를 호출할 수 없음
		MemberCall_클래스_인스턴스_멤버호출 c = new MemberCall_클래스_인스턴스_멤버호출();
		c.instanceMethod1(); //인스턴스를 생성한 후에야 호출할 수 있음
	}
	
	void instanceMethod2() { //인스턴스 메서드에서는 인스턴스 메서드와 클래스메서드 모두 인스턴스 생성없이 바로 호출 가능
		staticMethod1(); 
		instanceMethod1();
	}
}
