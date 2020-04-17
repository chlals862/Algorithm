package baekjoon.정렬;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//S = A[0]*B[0] + ... + A[N-1]*B[N-1]
//S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
//S의 최솟값을 출력하는 프로그램을 작성하시오.

//★ A 오름차순
//★ B 내림차순 
//sum += A*B
public class 보물 {
	
	static int x;
	static int y;
	static Integer[] A;
	static Integer[] B;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {

		inputData();
		logic();
		outputData();
	}

	private static void outputData() {
		for (int i = 0; i < A.length; i++) {
			sum += A[i] * B[i];
		}
		System.out.println(sum);
	}
	
	private static void logic() {
		// step1. A는 오름차순
		Arrays.sort(A);
		// step2. B는 내림차순
		Arrays.sort(B, Collections.reverseOrder());
	}
	// 입력
	private static void inputData() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int inputNum = sc.nextInt();
		A = new Integer[inputNum];
		B = new Integer[inputNum];

		for (int i = 0; i < inputNum; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < inputNum; i++) {
			B[i] = sc.nextInt();
		}

	}

}
