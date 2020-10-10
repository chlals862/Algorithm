package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 피보나치수7 {
	static int input;
	static BigInteger[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		input = Integer.parseInt(st.nextToken());
		arr = new BigInteger[input+2];
		arr[0] = BigInteger.ZERO;
		arr[1] = BigInteger.ONE;
		for(int i=2;i<=input;i++) {
			arr[i] = (arr[i-2].add(arr[i-1])).mod(BigInteger.valueOf(1000000007));
		}
		bw.write(String.valueOf(arr[input]));
		bw.flush();
		bw.close();
	}
}
