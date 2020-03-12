package javaStudy.ch09_java.lang패키지;
	/*
	 * toString() -> 객체를 문자열로 표현해서 반환
	 * - 인스턴스에 대한 정보를 문자열(String)로 제공할 목적
	 * */
class Card {
	String kind;
	int number;
	
	Card() {
		this("SPADE",1);
	}
	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
}

public class CardToStringTest {
	
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();
		
		//클래스 작성시 toString()을 오버라이딩 하지 않으면, 16진수의 해시코드를 얻게됨
		//서로 다른 인스턴스에 대해 toString()을 호출하였으므로, 클래스의 이름은 같아도 해시코드값이 다름
		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}
}
