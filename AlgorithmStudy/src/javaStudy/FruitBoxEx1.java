package javaStudy.ch12_제너릭스_열거형_어노테이션;
	/*
	 * 제네릭스 -> 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스의 컴파일 시의 타입체크를 해주는 기능
	 * 장점
	 * 1. 타입 안정성을 제공
	 * 2. 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해짐
	 * 670p
	 * */
import java.util.ArrayList;

class Fruit {
	public String toString() { 
		return "Fruit";
	}
}
class Apple extends Fruit {
	public String toString() {
		return "Apple";
	}
}
class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
}
class Toy {
	public String toString() {
		return "Toy";
	}
}
public class FruitBoxEx1 {

	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy> toyBox = new Box<Toy>();
	  //Box<Grape> grapeBox = new Box<Apple>(); //에러. 타입 불일치
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple()); // void add(Fruit item)
	
		appleBox.add(new Apple());
		appleBox.add(new Apple());
	  //appleBox.add(new Toy()); //Box<Apple>에는 Apple만 담을 수 있음
		
		toyBox.add(new Toy());
	  //toyBox.add(new Apple()); //Box<Toy>에는 Toy만 담을 수 있음
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	}
}

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {
		list.add(item);
	}
	T get(int i) {
		return list.get(i);
	}
	int size() {
		return list.size();
	}
	public String toString() {
		return list.toString();
	}
}
