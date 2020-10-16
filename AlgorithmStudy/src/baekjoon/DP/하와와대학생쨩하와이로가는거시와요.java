package baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 하와와대학생쨩하와이로가는거시와요 {
	static int N;
	static long[] memo;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		memo = new long[50001];
		memo[1] = 1; memo[2] = 1; memo[3] = 2; memo[4] = 3;
		for(int i=5;i<=50000;i++) {
			memo[i] = (memo[i-1]+memo[i-3])%1000000009;
		}
		System.out.println(memo[N]);
	}
}
