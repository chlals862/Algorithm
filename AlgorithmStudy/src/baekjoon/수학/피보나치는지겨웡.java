package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 피보나치는지겨웡 {
	static int input;
	static long[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = Integer.parseInt(br.readLine());
		arr = new long[51];
		arr[0] = 1; arr[1] = 1;
		for(int i=2;i<=input;i++) {
			arr[i] = (arr[i-2] + arr[i-1]+1) % 1000000007;
		}
		bw.write((int) arr[input]+"\n");
		bw.flush();
		bw.close();
	}
}
