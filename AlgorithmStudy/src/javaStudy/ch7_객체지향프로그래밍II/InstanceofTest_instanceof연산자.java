package javaStudy.ch7_객체지향프로그래밍II;

public class InstanceofTest_instanceof연산자 {
	 
	/*
	 * instanceof연산자 -> 참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 사용
	 * 주로 조건문에 사용되고, instanceof의 왼쪽에는 참조변수를, 오른쪽에는 타입(클래스명)이 피연산자로 위치함
	 * 연산의 결과로 boolean값인 true와 false 중의 하나를 반환함
	 * instanceoof를 이용한 연산결과로 true를 얻었다는 것은 참조변수가 검사한 타입으로 형변환이 가능하다는 뜻임
	 * */
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		
		if(fe instanceof FireEngine) {
			System.out.println("This is a FireEngine instance.");
		}
		
		if(fe instanceof Car) {
			System.out.println("This is a Car instance.");
		}
		
		if(fe instanceof Object) {
			System.out.println("This is a Object instance.");
		}
		//참조변수.getClass().getName()은 참조변수가 가리키고 있는 인스턴스의 클래스 이름을 문자열(String)으로 반환함
		System.out.println(fe.getClass().getName()); //클래스 이름을 출력
	}
}
/* 생성된 인스턴스는 FireEngine타입인데도, Object타입과 Car타입의 instanceof연산에서도 true를 결과로 얻음
 * 그 이유는 FireEngine클래스는 Object클래스와 Car클래스의 자손 클래스이므로 조상의 멤버들을 상속받았기 때문에, FireEngine인스턴스는 Object인스턴스와 Car인스턴스를 포함하고 있는 셈
 * p363
 * */



//class Car {} //다른 클래스에서 이미 사용하므로 생략함 
//class FireEngine extends Car {}