package baekjoon.정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ10814 {

	static class person {
		int no;
		int age;
		String name;
		public person(int no, int age, String name) {
			this.no = no;
			this.age = age;
			this.name = name;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		ArrayList<person> persons = new ArrayList<person>();
		while(N --> 0) {
			int age = sc.nextInt();
			String name = sc.next();
			
			persons.add(new person(N,age, name));
		}
		
		Collections.sort(persons, new Comparator<person>() {

			@Override
			public int compare(person o1, person o2) {
				if(o1.age == o2.age) {
					return -Integer.compare(o1.no, o2.no);
				}else {
					return Integer.compare(o1.age, o2.age);
				}
			}
		});
		for(person p : persons) {
			System.out.println(p.age+ " " + p.name);
		}
	}
}
