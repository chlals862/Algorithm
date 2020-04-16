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

public class 국영수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Student> student = new ArrayList<Student>();
	static int inputNum;

	static class Student {
		String name;
		int kor;
		int eng;
		int math;

		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		inputData();
		sorting();
		outputData();

		bw.flush();
		bw.close();
	}

	private static void outputData() throws IOException {
		for (Student s : student)
			bw.write(s.name + "\n");

	}

	private static void sorting() {
		/*
		 * 1. 국어 점수가 감소하는 순서 2. 국어 점수가 같으면 영어 점수가 증가하는 순서 3. 국어 점수와 영어 점수가 같으면 수학 점수가
		 * 감소하는 순서로 4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로
		 * 앞에 옴)
		 */

		Collections.sort(student, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (s1.kor == s2.kor) { 

					if (s1.eng == s2.eng) { 

						if (s1.math == s2.math) {
							// 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서
							return s1.name.compareTo(s2.name);
						}
						//국어 점수,영어 점수가 같을 때 수학점수가 감소하는 순서
						return -Integer.compare(s1.math, s2.math);
					}
					//국어 점수가 같으면 영어 점수가 증가하는 순서
					return Integer.compare(s1.eng, s2.eng);
				} 
					//국어 점수가 감소하는 순서
					return -Integer.compare(s1.kor, s2.kor);
			}
		});//sort
	}

	private static void inputData() throws NumberFormatException, IOException {

		inputNum = Integer.parseInt(br.readLine());

		for (int i = 0; i < inputNum; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());

			student.add(new Student(name, kor, eng, math));
		}
	}
}
