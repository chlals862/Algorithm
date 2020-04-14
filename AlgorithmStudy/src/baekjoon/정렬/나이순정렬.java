package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 
*이때, 회원들을 나이가 증가하는 순으로,
나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.*/
public class 나이순정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static StringTokenizer st;
	static ArrayList<Person> persons = new ArrayList<Person>();
	
	static class Person {
		int joinNo;
		int age;
		String name;
		
		public Person(int joinNo, int age, String name) {
			this.joinNo = joinNo;
			this.age = age;
			this.name = name;
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		inputData();
		sorting();
		outputData();
		
		bw.flush();
		bw.close();
	}
	private static void outputData() throws IOException {
		for(Person person : persons) 
			bw.write(person.age + " " + person.name+"\n");
	}
	private static void sorting() { //정렬
		//step1. 회원 나이가 증가하는 순
		Collections.sort(persons,new Comparator<Person>() {
				@Override
				public int compare(Person p1, Person p2) {
					if(p1.age == p2.age) return Integer.compare(p1.joinNo, p2.joinNo);
					
					else return Integer.compare(p1.age, p2.age);
				}
		});
		
	}
	//int로 입력받은 수 만큼 person(arrayList)에 저장
	private static void inputData() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			persons.add(new Person(i, age, name));
		}
		
	}
	
	
	
	
}
