package javaStudy.ch12_제너릭스_열거형_어노테이션;
	/*
	 * 열거형에 추상 메서드를 선언하면 각 열거형 상수가 이 추상 메서드를 반드시 구현해야 함★ 
	 * */
enum Transportation {
	BUS(100) { int fare(int distance) { return distance*BASIC_FARE;}},
	TRAIN(150) { int fare(int distance) { return distance*BASIC_FARE;}},
	SHIP(100) { int fare(int distance) { return distance*BASIC_FARE;}},
	AIRPLANE(200) { int fare(int distance) { return distance*BASIC_FARE;}};
	
	protected final int BASIC_FARE; //protected로 해야 각 상수에서 접근이 가능
	
	Transportation(int basicFare) { //private Transportation(int basicFare) 
		BASIC_FARE = basicFare;
	}
	public int getBasicFare() { return BASIC_FARE; }
	
	abstract int fare(int distance);
	
}//end of enum


public class EnumEx3_추상메서드추가 {

	public static void main(String[] args) {
		System.out.println("bus fare = " + Transportation.BUS.fare(100));
		System.out.println("train fare = " + Transportation.TRAIN.fare(100));
		System.out.println("ship fare = " + Transportation.SHIP.fare(100));
		System.out.println("airplane fare = " + Transportation.AIRPLANE.fare(100));
	}
}
