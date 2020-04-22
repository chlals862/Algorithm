package baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 콘테스트 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] Y = new int[10]; // 연
		int Ysum = 0;
		int[] K = new int[10]; // 고
		int Ksum = 0;

		for (int i = 0; i < 10; i++) {
			Y[i] = sc.nextInt();
		}
		Arrays.sort(Y);
		Ysum = Y[Y.length - 1] + Y[Y.length - 2] + Y[Y.length - 3];
		
		//---------------------------------------------------------
		for (int i = 0; i < 10; i++) {
			K[i] = sc.nextInt();
		}
		Arrays.sort(K);
		Ksum = K[K.length - 1] + K[K.length - 2] + K[K.length - 3];
		System.out.print(Ysum + " " + Ksum);
	}
}
