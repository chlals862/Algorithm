package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 피보나치비스무리한수열 {
	static long[] arr;
	static long num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		num = Long.parseLong(br.readLine());
		arr = new long[120];
		arr[1] = arr[2] = arr[3] = 1;
		for(int i=4;i<=num;i++) {
			arr[i] = arr[i-1] + arr[i-3];
		}
		bw.write(arr[(int) num]+"\n");
		bw.flush();
		bw.close();
	}
}
