package baekjoon.수학;

import java.util.Arrays;
import java.util.Scanner;

public class 주몽 {

	static int first;
	static int last;
	static int count;
	// 갑옷을 만드는데 필요한 재료의 갯수[2개]
	static int M;
	static int[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 6
		int M = sc.nextInt();// 9

		int[] list = new int[N];
		// 첫번째
		int first = 0;
		// 마지막
		int last = N - 1;
		// 갑옷 수
		int count = 0;

		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		// inputData();
		// logic(first,last,count,list);

		// private static int logic(int first,int last, int count,int[] list) {
		// 정렬하고 처음 + 마지막꺼 반복 비교
		Arrays.sort(list);
		/*
		 * for (int i = 0; i < N; i++) { System.out.print(list[i] + " "); }
		 */

		while (first < last) {
			// 처음 + 마지막이 <M이면 2번째꺼 비교
			if (list[first] + list[last] < M) {
				first++;

				// 처음 + 마지막이 >M이면 끝에서 2번째꺼 비교
			} else if (list[first] + list[last] > M) {
				last--;

			} else if (list[first] + list[last] == M) {
				last--;
				count++;
				first++;

			}
		}
		System.out.println(count);
		// private static void inputData() {

	}
}
