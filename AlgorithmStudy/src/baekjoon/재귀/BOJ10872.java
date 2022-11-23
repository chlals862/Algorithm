package baekjoon.재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10872 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		bw.write(recursive(N)+"\n");
		br.close();
		bw.flush();
		bw.close();
	}

	private static int recursive(int n) {
		if(n == 0) return 1;
		
		return n * recursive(n-1);
	}
}
