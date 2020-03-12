package javaStudy.ch07_객체지향프로그래밍II;

public class DectTest_상속_카드섞기 {
	/*
	 * Deck클래스를 작성하는데 Card클래스를 재사용하여 포함관계로 작성함
	 * Deck은 모두 52장의 카드로 이루어져 있으므로 Card클래스를 크기가 52인 배열로 처리함
	 * 
	 * */
	public static void main(String[] args) {
		
		Deck d = new Deck(); //카드 한 벌(Deck)을 만듦
		Card c = d.pick(); //섞기 전에 제일 위의 카드를 뽑음
		System.out.println("섞기 전 : "+c); //System.out.println(c.toString());과 같음
		
		d.shuffle(); //카드를 섞음
		c = d.pick(0); //섞은 후에 제일 위의 카드를 뽑음
		System.out.println("섞은 후 : "+c);
	}
}

class Deck {
	final int CARD_NUM = 52; //카드의 수
	Card cardArr[] = new Card[CARD_NUM]; //Card객체 배열을 포함

	Deck() { //Deck의 카드를 초기화
		int i = 0;
		
		for(int k=Card.KIND_MAX; k>0; k--)
			for(int n=0; n<Card.NUM_MAX; n++) 
				cardArr[i++] = new Card(k, n+1);//Card의 매개변수 kind, number
	}//Deck of end 
	
	Card pick(int index) { //지정된 위치(index)에 있는 카드 하나를 꺼내서 반환함
		return cardArr[index];
	}
	//pick()은 Card객체 배열 cardArr에 저장된 Card객체 중에서 하나를 꺼내서 반환
	//Card객체 배열은 참조변수 배열임
	//이 배열에 실제로 저장된 것은 객체가 아니라 객체의 주소임
	Card pick() { //Deck에서 카드 하나를 선택함
		int index = (int)(Math.random() * CARD_NUM);
		return pick(index);
}
	//shuffle()은 카드 한 벌의 첫 번째 카드부터 순서대로 임의로 위치에 있는 카드와 위치를 서로 바꾸는 방식으로 카드를 섞음
	//random()을 사용함으로서 매 실행시 마다 결과가 다르게 나타남
	void shuffle() { //카드의 순서 섞기
		for(int i=0; i<cardArr.length;i++) {
			int r = (int)(Math.random() * CARD_NUM);
			
			Card temp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = temp;
		}
	}
}
class Card {
	static final int KIND_MAX = 4; //카드의 무늬 수
	static final int NUM_MAX = 13; //무늬 별 카드 수
	
	static final int SPADE =   4;
	static final int DIAMOND = 3;
	static final int HEART =   2;
	static final int CLOVER =  1;
	int kind;
	int number;
	
	Card() {
		this(SPADE,1);
	}
	
	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	public String toString() { //toString()은 인스턴스의 정보를 문자열로 반환할 목적으로 정의된 것
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		String numbers = "0123456789XJQK"; //숫자 10은 X로 표현
		
		return "kind : " + kinds[this.kind] + ", number :" + numbers.charAt(this.number);
	}//toString() of end
}//Card Class of end



