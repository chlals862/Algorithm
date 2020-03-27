package javaStudy.ch12_제너릭스_열거형_어노테이션;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
	/*
	 * Collections.sort()를 이용해서 appleBox와 grapeBox에 담긴 과일을 무게별로 정렬하는 예제
	 * 
	 * */
class Fruit3 {
	String name;
	int weight;
	
	Fruit3(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	public String toString() { return name+"("+weight+")";}
}//end of Fruit3 class

class Apple3 extends Fruit3 {
	Apple3(String name, int weight) {
		super(name, weight);
	}
}
class Grape3 extends Fruit3 {
	Grape3(String name, int weight){
		super(name, weight);
	}
}

class AppleComp implements Comparator<Apple3> {
	public int compare(Apple3 t1, Apple3 t2) {
		return t2.weight - t1.weight;
	}
}
class GrapeComp implements Comparator<Grape3> {
	public int compare(Grape3 t1, Grape3 t2) {
		return t2.weight - t1.weight;
	}
}
class FruitComp implements Comparator<Fruit3> {
	public int compare(Fruit3 t1, Fruit3 t2) {
		return t1.weight - t2.weight;
	}
}
public class FruitBoxEx4 {

	public static void main(String[] args) {
	FruitBox3<Apple3> appleBox = new FruitBox3<Apple3>();
	FruitBox3<Grape3> grapeBox = new FruitBox3<Grape3>();
	
	appleBox.add(new Apple3("GreenApple", 300));
	appleBox.add(new Apple3("GreenApple", 100));
	appleBox.add(new Apple3("GreenApple", 200));
	
	grapeBox.add(new Grape3("GreenGrape", 400));
	grapeBox.add(new Grape3("GreenGrape", 300));
	grapeBox.add(new Grape3("GreenGrape", 200));
	
	Collections.sort(appleBox.getList(), new AppleComp());
	Collections.sort(grapeBox.getList(), new GrapeComp());
	System.out.println(appleBox);
	System.out.println(grapeBox);
	System.out.println();
	
	Collections.sort(appleBox.getList(), new FruitComp());
	Collections.sort(grapeBox.getList(), new FruitComp());
	System.out.println(appleBox);
	System.out.println(grapeBox);
	
	
	}
}

class FruitBox3<T extends Fruit3> extends Box3<T> {}
class Box3<T> {
	ArrayList<T> list = new ArrayList<T>();
	
	void add(T item) {
		list.add(item);
	}
	
	T get(int i) {
		return list.get(i);
	}
	
	ArrayList<T> getList() { return list; }
	
	int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
}