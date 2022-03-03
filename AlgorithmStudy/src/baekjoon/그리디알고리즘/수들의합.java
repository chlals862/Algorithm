package baekjoon.그리디알고리즘;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 수들의합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		int add = 0;
		
		while(sum <= S) {
			add++;
			sum += (add);
		}
		bw.write(add-1+"\n");
		bw.flush();
	}

}
