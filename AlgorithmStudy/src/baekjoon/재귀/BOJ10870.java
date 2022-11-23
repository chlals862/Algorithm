package baekjoon.재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		bw.write(fibonacci(n)+"\n");
		br.close();
		bw.flush();
		bw.close();
	}

	//0 1 1 2 3 5 8 13 21 ...
	private static int fibonacci(int n) {
		if(n == 1 || n == 2) return 1;
		
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
