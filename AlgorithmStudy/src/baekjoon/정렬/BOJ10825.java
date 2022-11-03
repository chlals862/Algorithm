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

public class BOJ10825 {
	
	static class students {
		String name;
		int kor;
		int eng;
		int math;
		public students(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<students> stu = new ArrayList<students>();
		while(N --> 0) {
			st = new StringTokenizer(br.readLine());
			String name = String.valueOf(st.nextToken());
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			stu.add(new students(name, kor, eng, math));
		}
		
		Collections.sort(stu, new Comparator<students>() {
			@Override
			public int compare(students o1, students o2) {
				if(o1.kor == o2.kor) {
					if(o1.eng == o2.eng) {
						if(o1.math == o2.math) {
							return o1.name.compareTo(o2.name);
						}//math
						return -Integer.compare(o1.math, o2.math);
					}//eng
					return Integer.compare(o1.eng, o2.eng);
				}//kor
				return -Integer.compare(o1.kor, o2.kor);
			}
		});
		for(students result : stu) {
			bw.write(result.name+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
