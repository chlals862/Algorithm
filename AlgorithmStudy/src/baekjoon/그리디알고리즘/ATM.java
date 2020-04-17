package baekjoon.그리디알고리즘;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ATM {
	// static BufferedReader br = new BufferedReader(new
	// InputStreamReader(System.in));
	// static BufferedWriter bw = new BufferedWriter(new
	// OutputStreamWriter(System.out));
	static int inputNum;
	static int num[];
	static int min;

	public static void main(String[] args) {
		// logic();
//	private static void logic() {
//		
//		for(int i=0; i<num.length;i++) {
//		
//		}
//	}
		//입력
		Scanner sc = new Scanner(System.in);

		inputNum = sc.nextInt();
		int num[] = new int[inputNum];

		for (int i = 0; i < inputNum; i++) {
			num[i] = sc.nextInt();

		}
		// 로직
		//31432 -> 12334
		Arrays.sort(num);
		
		for (int i = 0; i < inputNum; i++) {
			for (int j = 0; j < i + 1; j++) {
				min += num[j];
				//System.out.println("num[i] = " + num[i]);
				//System.out.println("num[j] = " + num[j]);
				//1 + 1+2 + 1+2+3 + 1+2+3+3 + 1+2+3+3+4 -> 1+3+6+9+13 -> 32
				//System.out.println("min = " + min);
			}
		}
		//출력
		System.out.println(min);

	}
}
