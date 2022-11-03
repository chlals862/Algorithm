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
/*
가장 나이가 적은 사람과 가장 많은 사람을 구하는 프로그램을 작성하시오.
*/
public class BOJ5635 {
	static class person {
		String name;
		int day;
		int month;
		int year;
		public person(String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<person> list = new ArrayList<person>();
		
		while(N --> 0) {
			st = new StringTokenizer(br.readLine());
			String name = String.valueOf(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			list.add(new person(name, day, month, year));
		}
		
		Collections.sort(list, new Comparator<person>() {

			@Override
			public int compare(person o1, person o2) {
				
				if(o1.year == o2.year) {
					if(o1.month == o2.month) {
						return -Integer.compare(o1.day, o2.day); //내림차순
					}
					return -Integer.compare(o1.month, o2.month);
				}
				return -Integer.compare(o1.year, o2.year);
			}
		});
		ArrayList<String> str = new ArrayList<String>();
		for(person p : list) {
			str.add(p.name);
		}
		bw.write(str.get(0) + "\n" + str.get(str.size()-1));
		br.close();
		bw.flush();
		bw.close();
	}
}
