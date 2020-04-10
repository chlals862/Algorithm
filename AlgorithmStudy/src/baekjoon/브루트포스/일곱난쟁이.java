package baekjoon.브루트포스;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이 {

	static int[] people = new int[9];
	static int[] nan = new int[7];
	//static int total = 0;
	//static int index = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < people.length; i++) {
			int input = sc.nextInt();
			people[i] = input;
		}

		for (int i = 0; i < people.length; i++) {
			for (int j = i + 1; j < people.length; j++) {
				int total = 0;
				int index = 0;
				
				for (int k = 0; k < people.length; k++) {
					// k가 i && j 아닐때
					if (k != i && k != j) {
						nan[index++] = people[k]; //7명이 들어갈 nan배열[1씩증가]에 if문에 만족하는 people를 삽입
						total += people[k];
					}
				} // k

				// 출력
				// 일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.
				// 7명의 난쟁이를 구한 총 total값이 100일 때
				if (total == 100) {
					Arrays.sort(nan);
					for (int a = 0; a <nan.length; a++) {
						System.out.println(nan[a]);
					}
					return;
				} // if
			} // j
		} // i
	}
}
