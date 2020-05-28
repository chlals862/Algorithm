package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 피보나치수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int input = Integer.parseInt(st.nextToken());
		
		int[] num = new int[input+1];
		num[1]=1;
		for(int i=2;i<num.length;i++) {
			num[i] = num[i-2] + num[i-1];
		}
		bw.write(num[input]+"");
		bw.flush();
		bw.close();
	}
}
