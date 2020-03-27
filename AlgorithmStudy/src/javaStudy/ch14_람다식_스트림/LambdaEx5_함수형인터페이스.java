package javaStudy.ch14_람다식_스트림;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx5_함수형인터페이스 {
	/*	T -> Type
	 *  R -> Return Type
	 * */
	public static void main(String[] args) {
		Supplier<Integer> s = () -> (int)(Math.random() * 100) +1; //Supplier<T> -> 매개변수는 없고, 반환값만 있음  -> 메서드 T get()
		Consumer<Integer> c = i -> System.out.print(i + ", ");     //Consumer<T> -> 매개변수만 있고, 반화값이 없음 -> 메서드 void accept(T t)
		Predicate<Integer> p = i -> i%2==0;                        //Predicate<T>-> 조건식을 표현하는데 사용됨, 매개변수는 하나, 반환 타입은 boolean -> 메서드 boolean test(T t)
		Function<Integer, Integer> f = i -> i/10*10; //i의 일의 자리를 없앰   //Function<T,R> -> 일반적인 함수, 하나의 매개변수를 받아서 결과를 반환 -> 메서드 apply(T t)
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list);
		System.out.println(list);
		printEvenNum(p, c, list);
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
	
	}
	
	static<T> List<T> doSomething(Function<T, T> f, List<T> list) { //하나의 매개변수를 받아서 반환
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i : list) {
			newList.add(f.apply(i));
		}
		return newList;
	}
	
	static<T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) { //조건식을 표현하는데 사용됨, 매개변수는 하나, 반환 타입은 boolean
		System.out.print("[");
		for(T i : list) {
			if(p.test(i))
				c.accept(i);
		}
		System.out.println("]");
	}
	
	static<T> void makeRandomList(Supplier<T> s, List<T> list) { //매개변수는 없고, 반환값만 있음
		for(int i=0;i<10;i++) {
			list.add(s.get());
		}
	}

}//classs
