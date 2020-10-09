package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 피보나치수4 {
	static int input;
	static BigInteger[] result;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		input = Integer.parseInt(st.nextToken());
		result = new BigInteger[input+2];
		result[0] = BigInteger.ZERO;
		result[1] = BigInteger.ONE;
		for(int i=2;i<=input;i++) {
			result[i] = result[i-2].add(result[i-1]);
		}
		bw.write(String.valueOf(result[input]));
		bw.flush();
		bw.close();
	}
}
