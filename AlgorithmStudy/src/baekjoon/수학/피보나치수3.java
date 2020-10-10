package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//피사노 주기 : 피보나치 수를 나눈 나머지는 항상 주기를 가진다. 이를 피사노 주기(Pisano Period)라 한다.
public class 피보나치수3 {
	static long input;
	static int pisano = 1500000;
	static long[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		input = Long.parseLong(br.readLine());
		arr = new long[pisano];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < pisano && i <= input; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000;
			
		}
		if (input >= pisano) {
			input %= pisano;
		}
		bw.write((int) arr[(int) input] + "\n");
		bw.flush();
		bw.close();
	}
}
