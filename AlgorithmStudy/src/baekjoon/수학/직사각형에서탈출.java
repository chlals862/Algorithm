package baekjoon.수학;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class 직사각형에서탈출 {
	static int a,b,c,d;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		int result1 = Math.min(a-0, c-a);
		int result2 = Math.min(b-0, d-b);
		min = Math.min(result1, result2);
		bw.write(min+"");
		bw.flush();
		bw.close();
	}
}
