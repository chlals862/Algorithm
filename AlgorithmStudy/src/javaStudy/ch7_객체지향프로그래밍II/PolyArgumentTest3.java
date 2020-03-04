package javaStudy.ch7_객체지향프로그래밍II;

import java.util.Vector;

class Product {
	int price; 
	int bonusPoint;

	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	
	Product() {
		price = 0;
		bonusPoint = 0;
	}	
}//class Product of end

class Tv2 extends Product {
	Tv2() { super(100); }
	public String toString() { return "Tv2"; }
}//class Tv2 of end

class Computer extends Product {
	Computer() { super(200); }
	public String toString() { return "Computer"; }
}//class Computer of end

class Audio extends Product {
	Audio() { super(50); }
	public String toString() { return "Audio"; }
}//class Audio of end

class Buyer { //고객
	int money = 1000; //소유금액
	int bonusPoint = 0; //보너스 점수
	Vector item = new Vector(); //구입한 제품을 저장하는데 사용될 Vector객체
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액부족!");
			return;
		}
		money -= p.price; //가진돈에서 구입한 제품의 가격을 뺌
		bonusPoint += p.bonusPoint;
		item.add(p); //구입한 제품을 Vector에 저장
		System.out.println(p + "을/를 구입!");
	}//void buy of end
	
	void refund(Product p) {
		if(item.remove(p)) { //구입한 제품을 환불
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을/를 반품!");
		} else { //반품에 실패한 경우
			System.out.println("구입하신 제품 중 해당 제품이 없음");
		}
	}//void refund of end
	
	void summary() {
		int sum = 0; //구매한 물품에 대한 정보를 요약해서 보여줌
		String itemList = ""; //구입한 물품의 가격합계
		
		if(item.isEmpty()) { //Vector가 비었는지 확인
			System.out.println("구입하신 제품이 없음");
			return;
		}//if of end
		//반복문을 이용하여 구입한 물품의 총 가격과 목록을 만듦
		for(int i=0; i<item.size();i++) {
			Product p = (Product)item.get(i); //Vector의 i번째에 있는 객체를 얻어옴
			sum += p.price;
			itemList += (i==0) ? "" + p : ", " + p;
		}//for of end
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원");
		System.out.println("구입하신 제품은 " + itemList);	
	}//vod summary of end
}
public class PolyArgumentTest3 {

	public static void main(String[] args) {
		
		Buyer b = new Buyer();
		Tv2 tv = new Tv2();
		Computer com = new Computer();
		Audio audio = new Audio();
		
		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
		System.out.println();
		b.refund(com);
		b.summary();
	}
}
