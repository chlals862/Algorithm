package baekjoon.재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			int n = Integer.parseInt(br.readLine());
			bw.write(recursive(n)+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	private static int recursive(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(n == 3) return 4;
		
		return recursive(n-1) + recursive(n-2) + recursive(n-3);
	}
}
