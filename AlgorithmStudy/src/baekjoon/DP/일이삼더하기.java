package baekjoon.DP;
/* 정수1 = 1개 -> 1
 * 정수2 = 2개 -> 1+1 , 2
 * 정수3 = 4개 -> 1+1+1,1+2,2+1,3
 * 정수4 = 7개  */
//A[N] = A[N-1]+A[N-2]+A[N-3]
import java.util.Scanner;

public class 일이삼더하기 {
	static int[] A;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int inputNum = sc.nextInt();

		for (int i = 0; i < inputNum; i++) {
			int N = sc.nextInt();
			if (N < 11) {
				int[] A = new int[N + 1];

				if (N == 1) {
					System.out.println(1);
				} else if (N == 2) {
					System.out.println(2);
				} else if (N == 3) {
					System.out.println(4);
				} else {
					A[1] = 1;
					A[2] = 2;
					A[3] = 4;
					for (int j = 4; j <= N; j++) {
						A[j] = A[j - 3] + A[j - 2] + A[j - 1];
					}
					System.out.println(A[N]);
				}
			}
		}
	}
}
