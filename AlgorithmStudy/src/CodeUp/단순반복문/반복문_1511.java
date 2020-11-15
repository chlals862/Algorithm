package CodeUp.단순반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 반복문_1511 {
	static int N;
	static int[][] num;
	static boolean[][] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		int number = 1;
		int sum = 0;
		num = new int[N + 1][N + 1];
		visit = new boolean[N + 1][N + 1];
		for (int row = 1; row <= N; row++) {
			for (int col = 1; col <= N; col++) {
				num[row][col] = number++;
			}
		}

		for (int row = 1; row <= N; row++) {
			for (int col = 1; col <= N; col++) {
				visit[1][col] = true;
				visit[N][col] = true;
				if (!visit[row][col]) {
					visit[row][1] = true;
					visit[row][N] = true;
				}
			}
		}
		for (int row = 1; row <= N; row++) {
			for (int col = 1; col <= N; col++) {
				if (visit[row][col]) {
					sum += num[row][col];
				}
			}
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}
}
