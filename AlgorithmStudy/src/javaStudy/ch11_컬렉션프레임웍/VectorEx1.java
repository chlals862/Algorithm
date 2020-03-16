package javaStudy.ch11_컬렉션프레임웍;

import java.util.Vector;

public class VectorEx1 {

	public static void main(String[] args) {
		Vector v = new Vector(5); //용량(capacity)이 5인 Vector를 생성
		
		v.add("1");
		v.add("2");
		v.add("3");
		print(v); //size : 3  capacity : 5
		
		v.trimToSize(); //빈 공간을 없앰(용량과 크기가 같아짐)
		System.out.println("=====After trimToSize()=====");
		print(v); //size : 3  capacity : 3
		
		v.ensureCapacity(6);
		System.out.println("=====After ensureCapacity(6)=====");
		print(v); //size : 3  capacity : 6
		
		v.setSize(7); //기본 capacity가 6이지만 6보다 큰 값을 setSize()해주면 기존의 capacity의 2배의 값으로 늘어남
		System.out.println("=====After setSize(7)=====");
		print(v); //size : 7  capacity : 12   
		//결고값 : 1,2,3,null,null,null,null
		
		v.clear();
		System.out.println("=====After clear()=====");
		print(v);
	}
	public static void print(Vector v) {
		System.out.println(v);
		System.out.println("size : " + v.size());
		System.out.println("capacity : " + v.capacity());
	}
}
