package baekjoon.정렬;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class N번째큰수 {
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[] arr = new int[10];
		for (int k = 0; k < N; k++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			bw.write(arr[7] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
