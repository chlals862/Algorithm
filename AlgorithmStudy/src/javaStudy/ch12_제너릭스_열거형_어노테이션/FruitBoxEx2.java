package javaStudy.ch12_제너릭스_열거형_어노테이션;

import java.util.ArrayList;

class Fruit2 implements Eatable {
	public String toString() { return "Fruit2";}
}

class Apple2 extends Fruit2 { public String toString() { return "Apple2";}}
class Grape2 extends Fruit2 { public String toString() { return "Grape2";}}
class Toy2 { public String toString() { return "Toy2";}}

interface Eatable {}

public class FruitBoxEx2 {

	public static void main(String[] args) {
		
		FruitBox<Fruit2> fruitBox = new FruitBox<Fruit2>();
		FruitBox<Apple2> appleBox = new FruitBox<Apple2>();
		FruitBox<Grape2> grapeBox = new FruitBox<Grape2>();
	//FruitBox<Grape2> grapeBox = new FruitBox<Apple>(); -> 타입불일치
		
		fruitBox.add(new Fruit2());
		fruitBox.add(new Apple2());
		fruitBox.add(new Grape2());
		appleBox.add(new Apple2());
	//appleBox.add(new Grape2()); -> Grape는 Apple의 자손이 아님
		grapeBox.add(new Grape2());
		
		System.out.println("fruitbox =" + fruitBox);
		System.out.println("grapebox =" + grapeBox);
		System.out.println("applebox = " + appleBox);
	}
}
class FruitBox<T extends Fruit2 & Eatable> extends Box2<T> {}

class Box2<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); }
	T get(int i) { return list.get(i); }
	int size() { return list.size(); }
	public String toString() { return list.toString(); }
}